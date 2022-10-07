package dals;

import models.Products;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class ProductsDAO extends DBContext {
    public Vector<Products> getProducts(){
        Vector<Products> products = new Vector<>();
        String sql = "select * from products";
        try {
            Statement state = connection.createStatement();
            ResultSet resultSet = state.executeQuery(sql);
            while (resultSet.next()){
                int product_id = resultSet.getInt(1);
                String product_name = resultSet.getString(2);
                String image = resultSet.getString(3);
                int model_year = resultSet.getInt(4);
                double list_prices = resultSet.getDouble(5);
                String brand_name = resultSet.getString(6);
                String category_name = resultSet.getString(7);
                Products products1 = new Products(product_id, product_name,image,model_year, list_prices, brand_name, category_name);
                products.add(products1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
    public void insertProduct(Products products){
        String sql = "insert into products(product_id" +
                ",product_name,image,model_year,list_price," +
                "brand_name,category_name) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement pre;
        try{
            pre = connection.prepareStatement(sql);
            pre.setInt(1, getMaxIdPro()+1);
            pre.setString(2, products.getProduct_name());
            pre.setString(3, products.getImage());
            pre.setInt(4, products.getModel_year());
            pre.setDouble(5, products.getList_price());
            pre.setString(6, products.getBrand_name());
            pre.setString(7, products.getCategory_name());
            pre.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void updateProduct(Products products){
        String sql = "update products set  product_name=?,image=?,model_year=?,list_price=?,brand_name=?,category_name=? where product_id=?";
        PreparedStatement pre;
        try{
            pre = connection.prepareStatement(sql);
           // pre.setInt(1, getMaxIdPro()+1);
            pre.setString(1, products.getProduct_name());
            pre.setString(2, products.getImage());
            pre.setInt(3, products.getModel_year());
            pre.setDouble(4, products.getList_price());
            pre.setString(5, products.getBrand_name());
            pre.setString(6, products.getCategory_name());
            pre.setInt(7, products.getProduct_id());
            pre.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteProduct(String id){
        String sql = "DELETE\n" +
                "FROM quanlybanhang.products\n" +
                "WHERE product_id =?";
        PreparedStatement pre;
        try{
            pre = connection.prepareStatement(sql);
            pre.setInt(1, Integer.parseInt(id));
            pre.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Vector<Products> searchNameProduct(String name){
        String sql ="SELECT *\n" +
                "FROM quanlybanhang.products\n" +
                "WHERE product_name LIKE '%"+ name+ "%'" +
                "LIMIT 10;";
//        PreparedStatement pre;
        Statement statement;
        ResultSet resultSet;
        Vector<Products> pro  = new Vector<>();
        try{
//            pre = connection.prepareStatement(sql);
//            pre.setString(1,name);
//            resultSet= pre.executeQuery();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int product_id = resultSet.getInt(1);
                String product_name = resultSet.getString(2);
                String image = resultSet.getString(3);
                int model_year = resultSet.getInt(4);
                double list_price = resultSet.getDouble(5);
                String brand_name = resultSet.getString(6);
                String category_name = resultSet.getString(7);
                Products products = new Products(product_id,product_name,image,model_year,list_price,brand_name,category_name);
                pro.add(products);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pro;
    }
    public Products getProID(String products){
        String sql = "select * from products where product_id=?";
        //String sql = "select * from products where product_id=" + products; //cach statement
        PreparedStatement pre;
        ResultSet resultSet;
        Products products1 = new Products();
        try{
            pre = connection.prepareStatement(sql);

            pre.setInt(1, Integer.parseInt(products));


            resultSet = pre.executeQuery();
            //products1 = (Products) resultSet.getObject(0);
            if(resultSet.next()){
                int product_id = resultSet.getInt(1);
                String product_name = resultSet.getString(2);
                String image = resultSet.getString(3);
                int model_year = resultSet.getInt(4);
                double list_price = resultSet.getDouble(5);
                String brand_name = resultSet.getString(6);
                String category_name = resultSet.getString(7);

                products1 = new Products(product_id,product_name,image,model_year,list_price,brand_name,category_name);

            }

            // ** cach statment
//            Statement statement = connection.createStatement();
//            resultSet = statement.executeQuery(sql);
//            if(resultSet.next()){
//                int product_id = resultSet.getInt(1);
//                String product_name = resultSet.getString(2);
//                String image = resultSet.getString(3);
//                int model_year = resultSet.getInt(4);
//                double list_price = resultSet.getDouble(5);
//                String brand_name = resultSet.getString(6);
//                String category_name = resultSet.getString(7);
//
//                products1 = new Products(product_id,product_name,image,model_year,list_price,brand_name,category_name);
//
//            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products1;
    }
    public int getMaxIdPro(){
        String query = "select Max(product_id) from products";
        Statement statement;
        int product_id = 0;
        try{
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                product_id = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product_id;
    }

}
