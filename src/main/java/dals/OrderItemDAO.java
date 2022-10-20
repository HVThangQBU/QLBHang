package dals;

import models.OrderItems;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderItemDAO extends DBContext{
  public List<OrderItems> getAllOrderItem() {
    String sql = "select * from order_items";
    Statement statement;
    ResultSet resultSet;
    List<OrderItems> orderItemsList  = new ArrayList<>();;
    try {
      statement = connection.createStatement();
      resultSet = statement.executeQuery(sql);
      while (resultSet.next()) {
        int orderId = resultSet.getInt(1);
        int itemId = resultSet.getInt(2);
        int productId = resultSet.getInt(3);
        int quanlity = resultSet.getInt(4);
        float listPrice = resultSet.getFloat(5);
        float discount = resultSet.getFloat(6);
        OrderItems orderItems = new OrderItems(itemId, orderId, productId, quanlity, discount, listPrice);
        orderItemsList.add(orderItems);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return orderItemsList;
  }
  public void insertOrderItem(OrderItems orderItems) {
    String query = "insert into order_items(order_id, item_id, product_id, quantity, list_price, discount) VALUES(?,?,?,?,?,?)";
    PreparedStatement preparedStatement;
    try {
      preparedStatement = connection.prepareStatement(query);
      preparedStatement.setInt(1, orderItems.getOrderId());
      preparedStatement.setInt(2, orderItems.getItemId());
      preparedStatement.setInt(3, orderItems.getProductId());
      preparedStatement.setInt(4, orderItems.getQuanlity());
      preparedStatement.setFloat(5, orderItems.getListPrice());
      preparedStatement.setFloat(6, orderItems.getDiscount());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
  public void update (OrderItems orderItems) {
    String sql = "update order_items set product_id=?,quantity=?,list_price=?,discount=? where item_id=? and order_id=?";
    PreparedStatement preparedStatement;
    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1, orderItems.getProductId());
      preparedStatement.setInt(2, orderItems.getQuanlity());
      preparedStatement.setFloat(3, orderItems.getListPrice());
      preparedStatement.setFloat(4, orderItems.getDiscount());
      preparedStatement.setInt(5, orderItems.getItemId());
      preparedStatement.setInt(6, orderItems.getOrderId());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
  public OrderItems getOrderItemId(String idOrder , String idItem ) {
    String sql = "select * from order_items where order_id =? and item_id=?";
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    OrderItems orderItems = new OrderItems();
    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1, Integer.parseInt(idOrder));
      preparedStatement.setInt(2, Integer.parseInt(idItem));
      resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        int orderId = resultSet.getInt(1);
        int itemId = resultSet.getInt(2);
        int productId = resultSet.getInt(3);
        int quanlity = resultSet.getInt(4);
        float listPrice = resultSet.getFloat(5);
        float discount = resultSet.getFloat(6);
        orderItems = new OrderItems(orderId, itemId, productId, quanlity, listPrice, discount);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return orderItems;
  }
  public int getMaxOrderItem () {
    String sql = "select Max(item_id) from order_items";
    Statement statement;
    ResultSet resultSet;
    int orderItemId = 0;
    try {
      statement = connection.createStatement();
      resultSet = statement.executeQuery(sql);
      if (resultSet.next()) {
        orderItemId = resultSet.getInt(1);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return orderItemId;
  }
}
