package dals;

import models.Orders;
import models.Staffs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class OrderDAO extends DBContext{
  public Vector<Orders> getOrder(){
    Vector<Orders> ordersVector = new Vector<>();
    String query = "select * from orders";
    Statement statement;
    ResultSet resultSet;
    try{
      statement = connection.createStatement();
      resultSet = statement.executeQuery(query);
      while (resultSet.next()){
        int order_id = resultSet.getInt(1);
        int customer_id = resultSet.getInt(2);
        int order_status = resultSet.getInt(3);
        String order_date = resultSet.getString(4);
        String required_date = resultSet.getString(5);
        String shipped_date = resultSet.getString(6);
        int store_id = resultSet.getInt(7);
        int staff_id = resultSet.getInt(8);
        Orders orders = new Orders(order_id, customer_id, order_status, order_date,  required_date, shipped_date, store_id, staff_id );
        ordersVector.add(orders);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return ordersVector;
  }
  public void insertOrder( Orders orders) {
    String sql = "insert into orders(order_id, customer_id, order_status, order_date, required_date, shipped_date," +
      " store_id, staff_id) VALUES (?,?,?,?,?,?,?,?)";
    PreparedStatement preparedStatement;
    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1, getOrderMaxId()+1);
      preparedStatement.setInt(2, orders.getCustomer_id());
      preparedStatement.setInt(3, orders.getOrder_status());
      preparedStatement.setString(4, orders.getOrder_date());
      preparedStatement.setString(5, orders.getRequired_date());
      preparedStatement.setString(6, orders.shipped_date);
      preparedStatement.setInt(7, orders.getStore_id());
      preparedStatement.setInt(8, orders.getStaff_id());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
  public void editOrder( Orders orders) {
    String sql = "update orders set customer_id=?, order_status=?, order_date=?, required_date=?, " +
      "shipped_date=?, store_id=?, staff_id=? where order_id=?";
    PreparedStatement preparedStatement;
    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1, orders.getCustomer_id());
      preparedStatement.setInt(2, orders.getOrder_status());
      preparedStatement.setString(3, orders.getOrder_date());
      preparedStatement.setString(4, orders.getRequired_date());
      preparedStatement.setString(5, orders.getShipped_date());
      preparedStatement.setInt(6, orders.getStore_id());
      preparedStatement.setInt(7, orders.getStaff_id());
      preparedStatement.setInt(8, orders.getOrder_id());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
   public void deleteOrder(String id) {
    String sql = "delete from orders where order_id=?";
    PreparedStatement preparedStatement;
    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1, Integer.parseInt(id));
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
   }
  public Vector<Orders> searchNameOrders(String nameOrder) {
    String sql = "select orders.order_id, orders.customer_id, orders.order_status, orders.order_date, orders.required_date, orders.shipped_date, orders.store_id, orders.staff_id from orders inner join customers on orders.customer_id = customers.customer_id where  CONCAT( first_name, ' ' , last_name ) like  '%" + nameOrder + "%'" ;
    Statement statement;
    ResultSet resultSet;
    Vector<Orders> ordersVector = new Vector<>();
    try {
      statement = connection.createStatement();
      resultSet = statement.executeQuery(sql);
      while (resultSet.next()) {
        int order_id = resultSet.getInt(1);
        int customer_id = resultSet.getInt(2);
        int order_status = resultSet.getInt(3);
        String order_date = resultSet.getString(4);
        String required_date = resultSet.getString(5);
        String shipped_date = resultSet.getString(6);
        int store_id = resultSet.getInt(7);
        int staff_id = resultSet.getInt(8);

        Orders orders = new Orders(order_id, customer_id, order_status, order_date, required_date, shipped_date, store_id, staff_id);
        ordersVector.add(orders);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return ordersVector;
  }
  public int getOrderMaxId() {
    String query = "select Max(order_id) from orders";
    Statement statement;
    int order_id = 0;
    try {
      statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(query);
      if (resultSet.next()) {
        order_id = resultSet.getInt(1);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return order_id;
  }
  public Orders getOrderId(String id) {
    String sql = "select * from orders where order_id=?";
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    Orders orders = new Orders();
    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1, Integer.parseInt(id));
      resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        int order_id = resultSet.getInt(1);
        int staff_id = resultSet.getInt(2);
        int store_id = resultSet.getInt(3);
        String shipped_date = resultSet.getString(4);
        String required_date = resultSet.getString(5);
        String order_date = resultSet.getString(6);
        int order_status = resultSet.getInt(7);
        int customer_id = resultSet.getInt(8);
       orders = new Orders(order_id, staff_id, store_id, shipped_date, required_date, order_date, order_status, customer_id);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return orders;
  }
}
