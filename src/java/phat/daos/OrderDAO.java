/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phat.daos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import phat.dtos.OrderDTO;
import phat.dtos.ProductDTO;
import phat.utils.DBUtils;

/**
 *
 * @author Admin
 */
public class OrderDAO implements Serializable{
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    
    private void closeConnection() throws Exception {
        if(rs != null){
            rs.close();
        }
        if(ps != null){
            ps.close();
        }
        if(con != null){
            con.close();
        }
    }

    public OrderDAO() {
    }
    
    public void setQuantityProduct(List<ProductDTO> list) throws Exception {
        try{
            con = DBUtils.getConnection();
            if(con != null){
                for (ProductDTO dto : list) {
                    String sql = "Update tbl_Product set Quantity = ? Where ProductID = ?";
                    ps = con.prepareStatement(sql);
                    ps.setInt(1, dto.getQuantity());
                    ps.setString(2, dto.getProductID());
                    ps.executeUpdate();
                }
            }
        }finally{
            closeConnection();            
        }
    } 
    
    public String getLastOrderIDByUser(String username) throws Exception{
        String id = null;
        try{
            String sql = "Select OrderID From tbl_Orders Where DateOfCreate = (Select Max(DateOfCreate) From tbl_Orders Where Username = ?)";
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if(rs.next()){
                id = rs.getString("OrderID");
            }
        }finally{
            closeConnection();
        }
        return id;
    }
    
    public boolean createOrder(OrderDTO dto) throws Exception{
        boolean check = false;
        try{
            String sql = "Insert into tbl_Orders(OrderID, Username, Total, Status, DateOfCreate) values(?,?,?,?,?)";
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getOrderID());
            ps.setString(2, dto.getUserID());
            ps.setFloat(3, dto.getTotal());
            ps.setTimestamp(5, new java.sql.Timestamp(dto.getDateOfCreate().getTime()));
            ps.setString(4, dto.getStatus());
            check = ps.executeUpdate() > 0;
        }finally{
            closeConnection();
        }
        return check;
    }
    
    public boolean createOrderDetail(String orderDetailID, String orderID, String productID, int quantity, float price) throws Exception{
        boolean check = false;
        try {
            String sql = "Insert into tbl_OrderDetail(OrderDetailID, OrderID, ProductID, Quantity, Price) values(?,?,?,?,?)";
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, orderDetailID);
            ps.setString(2, orderID);
            ps.setString(3, productID);
            ps.setInt(4, quantity);
            ps.setFloat(5, price);
            check = ps.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
