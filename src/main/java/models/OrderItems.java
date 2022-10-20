package models;

public class OrderItems {
  private int orderId;
  private int itemId;
  private int productId;
  private int quanlity;
  private float listPrice;
  private float discount;

  public OrderItems () {}

  public OrderItems(int orderId, int productId, int quanlity, float listPrice, float discount) {
    this.orderId = orderId;
    this.productId = productId;
    this.quanlity = quanlity;
    this.listPrice = listPrice;
    this.discount = discount;
  }

  public OrderItems(int orderId, int itemId, int productId, int quanlity, float listPrice, float discount) {
    this.orderId = orderId;
    this.itemId = itemId;
    this.productId = productId;
    this.quanlity = quanlity;
    this.listPrice = listPrice;
    this.discount = discount;
  }

  public int getItemId() {
    return itemId;
  }

  public void setItemId(int itemId) {
    this.itemId = itemId;
  }

  public int getOrderId() {
    return orderId;
  }

  public void setOrderId(int orderId) {
    this.orderId = orderId;
  }

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public int getQuanlity() {
    return quanlity;
  }

  public void setQuanlity(int quanlity) {
    this.quanlity = quanlity;
  }

  public float getDiscount() {
    return discount;
  }

  public void setDiscount(float discount) {
    this.discount = discount;
  }

  public float getListPrice() {
    return listPrice;
  }

  public void setListPrice(float listPrice) {
    this.listPrice = listPrice;
  }

}
