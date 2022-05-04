package dataAccess;

import domain.Employee;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class MySQLAccess {
    public Connection ConnectDb() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Success loading Driver!");
        String password = "projectdb";
        String user = "DBI23";
        String url = "jdbc:mysql://dif-mysql.ehu.es:3306/dbi23?autoReconnect=true&useSSL=false";
        Connection connection =DriverManager.getConnection(url, user, password);
        System.out.println("Database connection established");
        return connection;
    }



    public List<Employee> getEmployees() throws Exception {
        Connection connection = ConnectDb();
        String query = "SELECT * FROM employee";
        ResultSet resultSet = connection.createStatement().executeQuery(query);
        List<Employee> employees = new java.util.ArrayList<>();
        while (resultSet.next()) {
            employees.add(CreateEmployee(resultSet));
        }
        connection.close();
        System.out.println("closed");
        return employees;
    }

    public Employee CreateEmployee(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        employee.setAddress(resultSet.getString("Address"));
        employee.setBdate( resultSet.getDate("Bdate").toLocalDate());
        employee.setDno(resultSet.getInt("Dno"));
        employee.setFname(resultSet.getString("Fname"));
        employee.setLname(resultSet.getString("Lname"));
        employee.setSalary(resultSet.getInt("Salary"));
        employee.setSsn(resultSet.getString("Ssn"));
        employee.setMinit(resultSet.getString("Minit"));
        employee.setSex(resultSet.getString("Sex"));
        employee.setSuper_ssn(resultSet.getString("Super_ssn"));
        return employee;

    }


    public void insertEmployee(Employee employee) throws Exception {
        Connection connection = ConnectDb();
        String query = "INSERT INTO employee (Ssn, Fname, Minit, Lname, Address,Bdate,Sex,Salary,Super_ssn,Dno) VALUES (?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setString (1, employee.getSsn());
        preparedStmt.setString(2, employee.getFname());
        preparedStmt.setString(3, employee.getMinit());
        preparedStmt.setString(4, employee.getLname());
        preparedStmt.setString(5, employee.getAddress());
        preparedStmt.setObject(6,  (employee.getBdate()));

        preparedStmt.setString(7, employee.getSex());
        preparedStmt.setInt(8, employee.getSalary());
        preparedStmt.setString(9, employee.getSuper_ssn());
        preparedStmt.setInt(10, employee.getDno());
        preparedStmt.execute();
        connection.close();
    }

    public void deleteEmployee(String ssn) {
        try {
            Connection connection = ConnectDb();
            String query = "DELETE FROM employee WHERE Ssn = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, ssn);
            preparedStmt.execute();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Employee getEmployee(String ssn) throws Exception {
        Connection connection = ConnectDb();
        String query = "SELECT * FROM employee WHERE Ssn = ?";
        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setString(1, ssn);
        ResultSet resultSet = preparedStmt.executeQuery();
        return CreateEmployee(resultSet);
    }

    public void updateEmployee(Employee employee) {
        try {
            Connection connection = ConnectDb();
            String query = "UPDATE employee SET  Fname = ?, Minit = ?, Lname = ?, Address = ?, Bdate = ?,Dno = ?, Super_ssn = ?, Sex=?,Salary=? where Ssn=?";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1, employee.getFname());
            preparedStatement.setString(2, employee.getMinit());
            preparedStatement.setString(3, employee.getLname());
            preparedStatement.setString(4, employee.getAddress());
            preparedStatement.setObject(5, employee.getBdate());
            preparedStatement.setInt(6, employee.getDno());
            preparedStatement.setString(7, employee.getSuper_ssn());
            preparedStatement.setString(8, employee.getSex());
            preparedStatement.setInt(9, employee.getSalary());
            preparedStatement.setString(10, employee.getSsn());

            preparedStatement.execute();
            connection.close();

    } catch (Exception e) {
            e.printStackTrace();
        }
    }
}