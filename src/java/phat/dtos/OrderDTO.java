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
public class OrderDTO implements Serializable{
    private String orderID, userID, status;
    private float total;
    private Date dateOfCreate;

    public OrderDTO() {
    }

    public OrderDTO(String orderID, String userID, String status, float total, Date dateOfCreate) {
        this.orderID = orderID;
        this.userID = userID;
        this.status = status;
        this.total = total;
        this.dateOfCreate = dateOfCreate;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getDateOfCreate() {
        return dateOfCreate;
    }

    public void setDateOfCreate(Date dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
    }
    
}
