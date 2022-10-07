package models;

public class Stores {
  int store_id;
  String store_name;
  String phone;
  String email;
  String street;
  String city;

  public Stores() {
  }

  public Stores(String store_name, String phone, String email, String street, String city) {
    this.store_name = store_name;
    this.phone = phone;
    this.email = email;
    this.street = street;
    this.city = city;
  }

  public Stores(int store_id, String store_name, String phone, String email, String street, String city) {
    this.store_id = store_id;
    this.store_name = store_name;
    this.phone = phone;
    this.email = email;
    this.street = street;
    this.city = city;
  }

  public int getStore_id() {
    return store_id;
  }

  public void setStore_id(int store_id) {
    this.store_id = store_id;
  }

  public String getStore_name() {
    return store_name;
  }

  public void setStore_name(String store_name) {
    this.store_name = store_name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }
}
