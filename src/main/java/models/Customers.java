package models;

public class Customers {
    int customer_id;
    String first_name;
    String last_name;
    String phone;
    String email;
    String street;
    String city;
    String username;
    String password;
    public Customers(){}

    public Customers(int customer_id, String first_name, String last_name, String phone, String email, String street, String city) {
        this.customer_id = customer_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
        this.email = email;
        this.street = street;
        this.city = city;
    }

    public Customers(String first_name, String last_name, String phone, String email, String street, String city, String username, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
        this.email = email;
        this.street = street;
        this.city = city;
        this.username = username;
        this.password = password;
    }

    public Customers(int customer_id, String first_name, String last_name, String phone, String email, String street, String city, String username, String password) {
        this.customer_id = customer_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
        this.email = email;
        this.street = street;
        this.city = city;
        this.username = username;
        this.password = password;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
