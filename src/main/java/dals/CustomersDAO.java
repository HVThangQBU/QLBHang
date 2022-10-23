package dals;

import models.Customers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class CustomersDAO extends DBContext{
    public Vector<Customers> getCustomers() {
        Vector<Customers> customers = new Vector<>();
        String query = "select * from customers";
        try{
            Statement state = connection.createStatement();
            ResultSet resultSet = state.executeQuery(query);
            while (resultSet.next()){
                int customers_id = resultSet.getInt(1);
                String first_name= resultSet.getString(2);
                String last_name = resultSet.getString(3);
                String phone = resultSet.getString(4);
                String email = resultSet.getString(5);
                String street = resultSet.getString(6);
                String city = resultSet.getString(7);
                String username = resultSet.getString(8);
                String password = resultSet.getString(9);
                int roleId = resultSet.getInt(10);
                Customers customers1 = new Customers(customers_id,first_name, last_name, phone, email, street, city, username, password, roleId);
                customers.add(customers1);

            }
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return customers;
    }
    public void insertCustomer(Customers cus){
        String sql= "insert into customers(customer_id"
                +",first_name,last_name,phone"
                +",email,street,city,username,password, role_id)"
                +" VALUES(?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement pre;
        try {
            pre = connection.prepareStatement(sql);
            pre.setInt(1, getMaxIdCus()+1);
            pre.setString(2, cus.getFirst_name());
            pre.setString(3, cus.getLast_name());
            pre.setString(4, cus.getPhone());
            pre.setString(5, cus.getEmail());
            pre.setString(6, cus.getStreet());
            pre.setString(7, cus.getCity());
            pre.setString(8,cus.getUsername());
            pre.setString(9,cus.getPassword());
            pre.setInt(10, cus.getRoleId());
            pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    public void deleteCustomer(String id){
        String sql  = "DELETE\n" +
                "FROM customers\n" +
                "WHERE customer_id =?";
        PreparedStatement pre;
        try{
            pre = connection.prepareStatement(sql);
            pre.setInt(1, Integer.parseInt(id));
            pre.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Vector<Customers> searchNameCustomer(String name){
        String sql = "select * from customers where CONCAT( first_name, ' ' , last_name ) like '%" + name + "%'";
        Statement statement;
        ResultSet resultSet;
        Vector<Customers> vec = new Vector<>();
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
              int customers_id = resultSet.getInt(1);
              String first_name= resultSet.getString(2);
              String last_name = resultSet.getString(3);
              String phone = resultSet.getString(4);
              String email = resultSet.getString(5);
              String street = resultSet.getString(6);
              String city = resultSet.getString(7);
              String username = resultSet.getString(8);
              String password = resultSet.getString(9);
              int roleId = resultSet.getInt(10);
              Customers customers = new Customers(customers_id,first_name, last_name, phone, email, street, city, username, password, roleId);
              vec.add(customers);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vec;
    }
    public void updateCustomer(Customers customers){
        String sql = "update customers set first_name =?,last_name=?" +
                ",phone=?,email=?,street=?,city=?, role_id=? where customer_id=?";
        PreparedStatement pre;
        try{
            pre = connection.prepareStatement(sql);
            pre.setString(1,customers.getFirst_name());
            pre.setString(2,customers.getLast_name());
            pre.setString(3,customers.getPhone());
            pre.setString(4, customers.getEmail());
            pre.setString(5, customers.getStreet());
            pre.setString(6,customers.getCity());
            pre.setInt(7, customers.getRoleId());
            pre.setInt(8,customers.getCustomer_id());
            pre.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Customers getCusID(String id){
        String sql = "select * from customers where customer_id=?";
        PreparedStatement pre;
        ResultSet resultSet;
        Customers customers = new Customers();
        try{
            pre = connection.prepareStatement(sql);
            pre.setInt(1,Integer.parseInt(id));
            resultSet = pre.executeQuery();
            if(resultSet.next()){
                int customer_id = resultSet.getInt(1);
                String first_name = resultSet.getString(2);
                String last_name = resultSet.getString(3);
                String phone = resultSet.getString(4);
                String email = resultSet.getString(5);
                String street = resultSet.getString(6);
                String city = resultSet.getString(7);
                String usename = resultSet.getString(8);
                String pass = resultSet.getString(9);
              int roleId = resultSet.getInt(10);
                customers = new Customers(customer_id,first_name,last_name,phone,email,street,city, usename, pass, roleId);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return customers;
    }
    public int getMaxIdCus(){
        String query = "select Max(customer_id) from customers";
        Statement statement;
        int customer_id = 0;
        try{
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()) {
                customer_id = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customer_id;
    }
    public Customers getUsernameCus(String uname, String pass) {
      String query ="select * from customers where username like '"+ uname + "' and password like '"+ pass +"'";
      Statement statement;
      ResultSet resultSet;
      Customers customers = new Customers();
      try {
        statement = connection.createStatement();
        resultSet = statement.executeQuery(query);
        if (resultSet.next()) {
          int customers_id = resultSet.getInt(1);
          String first_name= resultSet.getString(2);
          String last_name = resultSet.getString(3);
          String phone = resultSet.getString(4);
          String email = resultSet.getString(5);
          String street = resultSet.getString(6);
          String city = resultSet.getString(7);
          String username = resultSet.getString(8);
          String password = resultSet.getString(9);
          int roleId = resultSet.getInt(10);
          customers = new Customers(customers_id,first_name, last_name, phone, email, street, city, username, password, roleId);
        }
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
      return customers;
    }
}
