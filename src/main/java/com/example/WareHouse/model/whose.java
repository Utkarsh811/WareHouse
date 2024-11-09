package com.example.WareHouse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity //because we want create a table in  the database
public class whose {

  @Id
  private int id;

  private String name;
  private String description;
  private String vendor;
  private int price;
  private int stock;
  private String currency;
  private String img_url;
  private String sku;

  // Getter and Setter for id
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  // Getter and Setter for name
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  // Getter and Setter for description
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  // Getter and Setter for vendor
  public String getVendor() {
    return vendor;
  }

  public void setVendor(String vendor) {
    this.vendor = vendor;
  }

  // Getter and Setter for price
  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  // Getter and Setter for stock
  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  // Getter and Setter for currency
  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  // Getter and Setter for img_url
  public String getImg_url() {
    return img_url;
  }

  public void setImg_url(String img_url) {
    this.img_url = img_url;
  }

  // Getter and Setter for sku
  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }
}
