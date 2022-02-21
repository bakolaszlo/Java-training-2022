package com.principal.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBConnection {
    public static Connection getConnection(String url, String username, String password){
        Connection con = null;
        Statement statement = null;
        try{
            Properties prop = new Properties();
            prop.put("user","test");
            prop.put("password","test");
            // con = DriverManager.getConnection(url, username,password);
            con = DriverManager.getConnection("jdbc:mysql://localhost/BookLibrary?" + prop);
            con.setAutoCommit(false);
            statement = con.createStatement();

            // used to execute SQL queries to insert new rows and update/delete existing ones
            int result = statement.executeUpdate("INSERT INTO transaction " +
                    "VALUES " + "(1, '5555', 'db', 55.0, '2022-04-02')");

            result = statement.executeUpdate("INSERT INTO transaction " +
                    "VALUES " + "(2, '7777', 'db', 55.0, '2022-04-02')");

            result = statement.executeUpdate("UPDATE bnk_account " +
                    "SET balance = 994, "+
                    "WHERE acct_no = '567'");

            con.commit();
        }
        catch (SQLException e) {
            System.out.println(e);
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        finally {
            try{
                if(statement != null) {
                    statement.close();
                }
                if(con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println(con);
        return con;
    }
}
