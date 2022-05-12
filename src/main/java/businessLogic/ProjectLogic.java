package businessLogic;

import dataAccess.MySQLAccess;
import domain.Dish;
import domain.Employee;
import domain.Guide;

import java.util.Collection;
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

    public Collection<Dish> searchDishes() throws Exception {
        MySQLAccess mySQLAccess = new MySQLAccess();
        return mySQLAccess.getDishes();
    }

    public void updateDish(Dish dish) {
        MySQLAccess mySQLAccess = new MySQLAccess();
        mySQLAccess.updateDish(dish);
    }

    public void insertDish(Dish dish) {
        MySQLAccess mySQLAccess = new MySQLAccess();
        mySQLAccess.insertDish(dish);
    }

    public void deleteDish(Dish selectedItem) {
        MySQLAccess mySQLAccess = new MySQLAccess();
        mySQLAccess.deleteDish(selectedItem);
    }

    public Collection<Guide> serchGuides() {
        MySQLAccess mySQLAccess = new MySQLAccess();
        return mySQLAccess.getGuides();
    }

    public void insertGuide(Guide guide) {
        MySQLAccess mySQLAccess = new MySQLAccess();
        mySQLAccess.insertGuide(guide);
    }

    public void deleteGuide(Guide selectedItem) {
        MySQLAccess mySQLAccess = new MySQLAccess();
        mySQLAccess.deleteGuide(selectedItem);
    }

    public void updateGuide(Guide g) {
        MySQLAccess mySQLAccess = new MySQLAccess();
        mySQLAccess.updateGuide(g);
    }

    public List<Object> runQuery(String text) throws Exception {
        MySQLAccess mySQLAccess = new MySQLAccess();
        return mySQLAccess.runQuery(text);

    }


}

