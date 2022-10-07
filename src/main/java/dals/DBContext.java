package dals;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBContext {
    public Connection connection;
    public DBContext()
    {
        try {
            //Change the username password and url to connect your own database
            String username = "root";
            String password = "2001";
//            String username = "lelong";
//            String password = "123";
            String url = "jdbc:mysql://localhost:3307/quanlybanhang";
//         String url = "jdbc:sqlserver://DCNG249\\SQLEXPRESS:1433;databaseName=LaptopShop1";
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("connect");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ResultSet getData(String sql){
        ResultSet rs =null;
        try {
            Statement state= connection.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs=state.executeQuery(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rs;
    }
    public static void main(String[] args) {
        new DBContext();
        ResultSet rs = new DBContext().getData("select * from customers ");
        try {
            while(
                    rs.next
                            ()){
                System.out.println(rs.getInt(1) + " customers_id " + rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

