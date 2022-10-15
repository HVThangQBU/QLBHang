package models;

public class Orders {
  private int  order_id;
  private int  staff_id;
  private int  store_id;
  public String  shipped_date;
  public String required_date;
  public String order_date;
  private int order_status;
  private int customer_id;

  public Orders(){};
  public Orders(int staff_id, int store_id, String shipped_date, String required_date, String order_date, int order_status, int customer_id) {
    this.staff_id = staff_id;
    this.store_id = store_id;
    this.shipped_date = shipped_date;
    this.required_date = required_date;
    this.order_date = order_date;
    this.order_status = order_status;
    this.customer_id = customer_id;
  }

  public Orders(int order_id, int staff_id, int store_id, String shipped_date, String required_date, String order_date, int order_status, int customer_id) {
    this.order_id = order_id;
    this.staff_id = staff_id;
    this.store_id = store_id;
    this.shipped_date = shipped_date;
    this.required_date = required_date;
    this.order_date = order_date;
    this.order_status = order_status;
    this.customer_id = customer_id;
  }


  public int getOrder_id() {
    return order_id;
  }

  public void setOrder_id(int order_id) {
    this.order_id = order_id;
  }

  public int getStaff_id() {
    return staff_id;
  }

  public void setStaff_id(int staff_id) {
    this.staff_id = staff_id;
  }

  public int getStore_id() {
    return store_id;
  }

  public void setStore_id(int store_id) {
    this.store_id = store_id;
  }

  public String getShipped_date() {
    return shipped_date;
  }

  public void setShipped_date(String shipped_date) {
    this.shipped_date = shipped_date;
  }

  public String getRequired_date() {
    return required_date;
  }

  public void setRequired_date(String required_date) {
    this.required_date = required_date;
  }

  public String getOrder_date() {
    return order_date;
  }

  public void setOrder_date(String order_date) {
    this.order_date = order_date;
  }

  public int getOrder_status() {
    return order_status;
  }

  public void setOrder_status(int order_status) {
    this.order_status = order_status;
  }

  public int getCustomer_id() {
    return customer_id;
  }

  public void setCustomer_id(int customer_id) {
    this.customer_id = customer_id;
  }
}
