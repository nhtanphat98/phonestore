/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phat.dtos;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class ProductDTO implements Serializable{
    private String productID, name;
    private int quantity;
    private String description, cateID;
    private float price;
    private Date dateOfCreate;
    private String image;

    public ProductDTO(String productID, String name, String description, float price, String image) {
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public ProductDTO(String productID, String name, int quantity, String description, float price, String image) {
        this.productID = productID;
        this.name = name;
        this.quantity = quantity;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    
    
    public ProductDTO(String productID, String name, int quantity, String description, String cateID, float price, String image) {
        this.productID = productID;
        this.name = name;
        this.quantity = quantity;
        this.description = description;
        this.cateID = cateID;
        this.price = price;
        this.image = image;
    }
    
    

    public ProductDTO() {
    }

    public ProductDTO(String productID, String name, int quantity, String description, String cateID, float price, Date dateOfCreate, String image) {
        this.productID = productID;
        this.name = name;
        this.quantity = quantity;
        this.description = description;
        this.cateID = cateID;
        this.price = price;
        this.dateOfCreate = dateOfCreate;
        this.image = image;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCateID() {
        return cateID;
    }

    public void setCateID(String cateID) {
        this.cateID = cateID;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getDateOfCreate() {
        return dateOfCreate;
    }

    public void setDateOfCreate(Date dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ProductDTO{" + "productID=" + productID + ", name=" + name + ", quantity=" + quantity + ", description=" + description + ", cateID=" + cateID + ", price=" + price + ", dateOfCreate=" + dateOfCreate + ", image=" + image + '}';
    }  
}
