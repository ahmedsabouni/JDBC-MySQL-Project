package businessLogic;

import dataAccess.MySQLAccess;
import domain.Employee;

import java.util.Date;
import java.util.List;

public class ProjectLogic {

    public List<Employee> serchEmployees() throws Exception {
        MySQLAccess mySQLAccess = new MySQLAccess();

        System.out.println("logic");

        return mySQLAccess.getEmployees();

    }

    public void insertEmployee(Employee employee ) throws Exception {
        MySQLAccess mySQLAccess = new MySQLAccess();
        mySQLAccess.insertEmployee(employee);
    }

    public void deleteEmployee(String ssn) {
        MySQLAccess mySQLAccess = new MySQLAccess();
        mySQLAccess.deleteEmployee(ssn);
    }

    public void updateEmployee(Employee employee) {
        MySQLAccess mySQLAccess = new MySQLAccess();
        mySQLAccess.updateEmployee(employee);
    }

    }

