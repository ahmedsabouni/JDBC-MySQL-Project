package dataAccess;

import domain.Dish;
import domain.Employee;
import domain.Guide;

import java.sql.*;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

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

    public Collection<Dish> getDishes() throws Exception {
        Collection<Dish> dishes = new ArrayList<>();

            Connection connection = ConnectDb();
            String query = "SELECT * FROM dishes";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Dish dish = new Dish();
                dish.setDish(resultSet.getString("dish"));
                dish.setCuisine(resultSet.getString("cuisine"));
                dish.setCategory(resultSet.getString("category"));
                dish.setDifficulty(resultSet.getString("difficulty"));
                dishes.add(dish);
            }
            connection.close();
            return dishes;


    }

    public void updateDish(Dish dish) {
        try {
            Connection connection = ConnectDb();
            String query = "UPDATE dishes SET  dish = ?, cuisine = ?, category = ?, difficulty = ? where dish=?";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1, dish.getDish());
            preparedStatement.setString(2, dish.getCuisine());
            preparedStatement.setString(3, dish.getCategory());
            preparedStatement.setString(4, dish.getDifficulty());
            preparedStatement.setString(5, dish.getDish());
            preparedStatement.execute();
            connection.close();
    } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void insertDish(Dish dish) {
        try {
            Connection connection = ConnectDb();
            String query = "INSERT INTO dishes (dish, cuisine, category, difficulty) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1, dish.getDish());
            preparedStatement.setString(2, dish.getCuisine());
            preparedStatement.setString(3, dish.getCategory());
            preparedStatement.setString(4, dish.getDifficulty());
            preparedStatement.execute();
            connection.close();
    } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
 /*public ArrayList <String> query11(String ssn) throws Exception {
            ArrayList <String> list = new ArrayList<String>();
            Connection connection = ConnectDb();
            String query = "SELECT MIN(person.AGE)FROM frequents INNER JOIN restaurant ON frequents.restaurname=restaurant.restaurname INNER JOIN person on frequents.nameId=person.nameId where restaurant.city=? AND person.gender=?";
            PreparedStatement preparedStatement=connection.prepareStatement((java.lang.String) query);
            preparedStatement.setString(1, "Paris");
            preparedStatement.setString(2, "male");
            ResultSet result= preparedStatement.getResultSet();






        }*/}

    public void deleteDish(Dish selectedItem) {
        try {
            Connection connection = ConnectDb();
            String query = "DELETE FROM dishes WHERE dish = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, selectedItem.getDish());
            preparedStmt.execute();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Collection<Guide> getGuides() {
        Collection<Guide> guides = new ArrayList<Guide>();
        try {
            Connection connection = ConnectDb();
            String query = "SELECT * FROM tourguide";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            ResultSet result= preparedStatement.executeQuery();
            while (result.next()) {
                Guide guide = new Guide();

                guide.setName(result.getString("guidename"));
                guide.setPhone(result.getString("guidephone"));
                guide.setId(result.getString("GuideId"));
                guides.add(guide);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return guides;
}

    public void insertGuide(Guide guide) {
        try {
            Connection connection = ConnectDb();
            String query = "INSERT INTO tourguide (GuideId, guidephone, guidename) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1, guide.getId());
            preparedStatement.setString(2, guide.getPhone());
            preparedStatement.setString(3, guide.getName());
            preparedStatement.execute();
            connection.close();
    } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteGuide(Guide selectedItem) {
        try {
            Connection connection = ConnectDb();
            String query = "DELETE FROM tourguide WHERE GuideId = ?";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1, selectedItem.getId());
            preparedStatement.execute();
            connection.close();
    } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateGuide(Guide g) {
        try {
            Connection connection = ConnectDb();
            String query = "UPDATE tourguide SET guidephone = ?, guidename = ? WHERE GuideId = ?";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1, g.getPhone());
            preparedStatement.setString(2, g.getName());
            preparedStatement.setString(3, g.getId());
            preparedStatement.execute();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Object> runQuery(String text) throws Exception {
        List<Object> list = new ArrayList<Object>();
        Connection connection = ConnectDb();
        String query = text;
        PreparedStatement preparedStmt = connection.prepareStatement(query);
        ResultSet resultSet = preparedStmt.executeQuery();
        System.out.println("Query executed");
        // print result set
        while (resultSet.next()) {
            Object obj = new Object();
            obj="\n";
            for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {

            obj += resultSet.getMetaData().getColumnName(i) + ": " + resultSet.getString(i) + "\n";

            }
            list.add(obj);
        }
        connection.close();
        return list;
    }

}