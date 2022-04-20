package dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLAccess {
    public void ConnectDb() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String password = "projectdb";
        String user = "DBI23";
        String url = "jdbc:mysql://dif-mysql.ehu.es:3306/dbi23?autoReconnect=true&useSSL=false";
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("Database connection established");


    }

    public void writeResultSet(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            
        }
    }
    public static void main(String[] args) {
        try {
            MySQLAccess mySQLAccess = new MySQLAccess();
            mySQLAccess.ConnectDb();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}