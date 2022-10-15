package dals;

import models.Orders;

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
        int staff_id = resultSet.getInt(2);
        int store_id = resultSet.getInt(3);
        String shipped_date = resultSet.getString(4);
        String required_date = resultSet.getString(5);
        String order_date = resultSet.getString(6);
        int order_status = resultSet.getInt(7);
        int customer_id = resultSet.getInt(8);
        Orders orders = new Orders(order_id,staff_id, store_id, shipped_date, required_date, order_date, order_status, customer_id);
        ordersVector.add(orders);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return ordersVector;
  }
}
