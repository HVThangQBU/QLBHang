package dals;

import models.Stores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class StoreDAO extends DBContext{
  public Vector<Stores> getStore(){
    Vector<Stores> store = new Vector<>();
    String query = "select * from stores";
    try{
      Statement state = connection.createStatement();
      ResultSet resultSet = state.executeQuery(query);
      while (resultSet.next()){
        int store_id = resultSet.getInt(1);
        String store_name = resultSet.getString(2);
        String phone = resultSet.getString(3);
        String email = resultSet.getString(4);
        String street = resultSet.getString(5);
        String city = resultSet.getString(6);
        Stores stores = new Stores(store_id,store_name,phone,email,street,city);
        store.add(stores);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return store;
  }

  public Map<Integer, String> getStoreMap(){
    Map<Integer, String> map = new HashMap<>();
    String query = "select store_id, store_name from stores";
    try{
      Statement state = connection.createStatement();
      ResultSet resultSet = state.executeQuery(query);
      while (resultSet.next()){
        int store_id = resultSet.getInt(1);
        String store_name = resultSet.getString(2);
        map.put(store_id, store_name);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return map;
  }

  public void insertStore(Stores st) {
    String sql = "insert into stores(store_id,store_name,phone,email,street" +
      ",city) VALUES(?,?,?,?,?,?)";
    PreparedStatement pre;
    try {
      pre = connection.prepareStatement(sql);
      pre.setInt(1,getMaxIdStore()+1);
      pre.setString(2,st.getStore_name());
      pre.setString(3,st.getPhone());
      pre.setString(4,st.getEmail());
      pre.setString(5,st.getStreet());
      pre.setString(6,st.getCity());
      pre.executeUpdate();
    } catch (SQLException ex) {
      throw new RuntimeException(ex);
    }
  }
  public void updateStore(Stores stores){
    String sql = "update stores set store_name=?,phone=?,email=?,street=?,city=? where store_id =?";
    PreparedStatement pre;
      try {
        pre = connection.prepareStatement(sql);
        pre.setString(1, stores.getStore_name());
        pre.setString(2,stores.getPhone());
        pre.setString(3,stores.getEmail());
        pre.setString(4,stores.getStreet());
        pre.setString(5,stores.getCity());
        pre.setInt(6,stores.getStore_id());
        pre.executeUpdate();
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
  }
  public void deleteStore(String id){
    String sql = "delete from stores where store_id=?";
    PreparedStatement pre;
    try{
      pre = connection.prepareStatement(sql);
      pre.setInt(1,Integer.parseInt(id));
      pre.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
  public Vector<Stores> searchNameStore(String name){
    String sql = "select * from stores where store_name like  '"+ name +"' limit 10";
    Statement statement;
    ResultSet resultSet;
    Vector<Stores> stores = new Vector<>();
    try {
      statement = connection.createStatement();
      resultSet = statement.executeQuery(sql);
      while (resultSet.next()){
        int store_id = resultSet.getInt(1);
        String store_name = resultSet.getString(2);
        String phone = resultSet.getString(3);
        String email = resultSet.getString(4);
        String street = resultSet.getString(5);
        String city = resultSet.getString(6);
        Stores stores1 = new Stores(store_id,store_name,phone,email,street,city);
        stores.add(stores1);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return stores;
  }


  public Stores getStoreID(String stores){
    String sql = "select * from stores where store_id=?";
    PreparedStatement pre;
    ResultSet resultSet;
    Stores stores1 = new Stores();
    try{
      pre = connection.prepareStatement(sql);
      pre.setInt(1,Integer.parseInt(stores));
      resultSet = pre.executeQuery();
      if(resultSet.next()){
        int store_id = resultSet.getInt(1);
        String store_name = resultSet.getString(2);
        String phone = resultSet.getString(3);
        String email = resultSet.getString(4);
        String street = resultSet.getString(5);
        String city = resultSet.getString(6);
        stores1 = new Stores(store_id,store_name,phone,email,street,city);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return stores1;
  }
  public int getMaxIdStore(){
    String query = "select Max(store_id) from stores";
    Statement statement;
    int store_id = 0;
    try{
      statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(query);
      if(resultSet.next()){
        store_id = resultSet.getInt(1);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return store_id;
  }
}
