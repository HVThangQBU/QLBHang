package dals;

import models.Staffs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StaffsDAO extends DBContext{
  public List<Staffs> getStaffs(){
    List<Staffs> staffsList = new ArrayList<Staffs>();
    String query = "select * from staffs";
    try{
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(query);
      while (resultSet.next()){
        int staff_id = resultSet.getInt(1);
        String first_name = resultSet.getString(2);
        String last_name = resultSet.getString(3);
        String email = resultSet.getString(4);
        String phone = resultSet.getString(5);
        int active = resultSet.getInt(6);
        int store_id = resultSet.getInt(7);
        int manager_id = resultSet.getInt(8);
        String username = resultSet.getString(9);
        String password = resultSet.getString(10);
        Staffs staffs = new Staffs(staff_id, first_name, last_name,email,phone, active,store_id,manager_id, username,password);
        staffsList.add(staffs);
      }
    }catch (SQLException e){
      throw new RuntimeException(e);
    }
    return staffsList;
  }
  public void insertStaffs(Staffs staffs){
    String query = "insert into staffs(staff_id, first_name, last_name,email, phone, active, store_id, manager_id," +
      " username, password) VALUES (?,?,?,?,?,?,?,?,?,?)";
    PreparedStatement pre;
    try{
      pre = connection.prepareStatement(query);
      pre.setInt(1,getMaxIdStaff()+ 1);
      pre.setString(2,staffs.getFirst_name());
      pre.setString(3,staffs.getLast_name());
      pre.setString(4,staffs.getEmail());
      pre.setString(5,staffs.getPhone());
      pre.setInt(6,staffs.getActive());
      pre.setInt(7,staffs.getStore_id());
      pre.setInt(8,staffs.getManager_id());
      pre.setString(9,staffs.getUsername());
      pre.setString(10,staffs.getPassword());
      pre.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public List<Staffs> getListManager(){
    String query = "select staff_id, first_name , last_name from staffs " +
      "where staff_id in (select distinct(manager_id) from staffs)";
    List<Staffs> listStaffs = new ArrayList<>();
    try {
      Statement statement = connection.createStatement();
      ResultSet rs = statement.executeQuery(query);
      while (rs.next()){
        int staff_id = rs.getInt(1);
        String first_name = rs.getString(2);
        String last_name = rs.getString(3);
        Staffs staff = new Staffs(staff_id, first_name, last_name);
        listStaffs.add(staff);
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return listStaffs;
  }

  public void updateStaff(Staffs staffs){

    String sql = "update staffs set first_name =?, last_name =?, email=?,phone=?,active=?,store_id =?,manager_id=?,username=?,password=? where staff_id=?";
    PreparedStatement pre;
    try{
      pre = connection.prepareStatement(sql);
      pre.setString(1,staffs.getFirst_name());
      pre.setString(2,staffs.getLast_name());
      pre.setString(3,staffs.getEmail());
      pre.setString(4,staffs.getPhone());
      pre.setInt(5,staffs.getActive());
      pre.setInt(6,staffs.getStore_id());
      pre.setInt(7,staffs.getManager_id());
      pre.setString(8,staffs.getUsername());
      pre.setString(9,staffs.getPassword());
      pre.setInt(10,staffs.getStaff_id());
      pre.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
  public void deleteStaff(String id){
    String sql = "delete from staffs where staff_id=?";
    PreparedStatement pre;
    try{
      pre = connection.prepareStatement(sql);
      pre.setInt(1,Integer.parseInt(id));
      pre.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
  public List<Staffs> searchNameStaff(String name){
    String sql ="select * from staffs where CONCAT( first_name, ' ' , last_name ) like '%" + name + "%'";
    Statement statement;
    ResultSet resultSet;
    List<Staffs> staffsList = new ArrayList<>();
    try{
      statement = connection.createStatement();
      resultSet = statement.executeQuery(sql);
      while (resultSet.next()){
        int staff_id = resultSet.getInt(1);
        String first_name = resultSet.getString(2);
        String last_name = resultSet.getString(3);
        String email = resultSet.getString(4);
        String phone = resultSet.getString(5);
        int active = resultSet.getInt(6);
        int store_id = resultSet.getInt(7);
        int manager_id = resultSet.getInt(8);
        String username = resultSet.getString(9);
        String password = resultSet.getString(10);
        Staffs staffs = new Staffs(staff_id,first_name,last_name,email,phone, active,store_id,manager_id,username,password);
        staffsList.add(staffs);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return staffsList;
  }
  public Staffs getStaffId(String id){
    String query = "select * from staffs where staff_id=?";
    PreparedStatement pre;
    ResultSet resultSet;
    Staffs staffs1 = new Staffs();
    try {
      pre = connection.prepareStatement(query);
      pre.setInt(1, Integer.parseInt(id));
      resultSet = pre.executeQuery();
      if (resultSet.next()){
        int staff_id = resultSet.getInt(1);
        String first_name = resultSet.getString(2);
        String last_name = resultSet.getString(3);
        String email = resultSet.getString(4);
        String phone = resultSet.getString(5);
        int active = resultSet.getInt(6);
        int store_id = resultSet.getInt(7);
        int manager_id = resultSet.getInt(8);
        String username = resultSet.getString(9);
        String password = resultSet.getString(10);
        staffs1 = new Staffs(staff_id,first_name,last_name,email,phone,active,store_id,manager_id,username,password);

      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  return staffs1;
  }

  public int getMaxIdStaff(){
    String query = "select MAX(staff_id) from staffs";
    Statement statement;
    int staffs_id = 0;
    try{
      statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(query);
      if(resultSet.next()){
        staffs_id = resultSet.getInt(1);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return staffs_id;
  }
}
