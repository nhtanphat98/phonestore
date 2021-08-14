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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import phat.dtos.ProductDTO;
import phat.utils.DBUtils;

/**
 *
 * @author Admin
 */
public class ProductDAO implements Serializable{
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    void closeConnection() throws SQLException{
        if(rs != null)
            rs.close();
        if(ps != null)
            ps.close();
        if(con != null)
            con.close();
    }
    public List<ProductDTO> getAllProductByName(String search) throws SQLException{
        List<ProductDTO> list = null;
        ProductDTO dto = null;
        String productID, name, description;
        int quantity;
        float price; String img;
        String sql = "Select ProductID, Name, Description, CateID, Quantity, Price, Image From tbl_Product Where Name Like ?";
        try{
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + search + "%");
            rs = ps.executeQuery();
            list = new ArrayList<>();
            while(rs.next()){
                productID = rs.getString("ProductID");
                name = rs.getString("Name");
                quantity = rs.getInt("Quantity");
                price = rs.getFloat("Price");
                description = rs.getString("Description");
                String cateID = rs.getString("CateID");
                img = rs.getString("Image");
                dto = new ProductDTO(productID, name, quantity, description, cateID, price, img);
                list.add(dto);
            }
        } catch(Exception e){
        }finally{
            closeConnection();
        }
        return list;
    }
    public List<ProductDTO> getAllProductByCateID(String cateID) throws Exception{
        List<ProductDTO> result = null;
        ProductDTO dto = null;
        String productID, name, description;
        int quantity;
        float price; String img;
        String sql = "Select ProductID, Name, Description, Quantity, Price, Image From tbl_Product Where CateID = ?";
        try{
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cateID);
            rs = ps.executeQuery();
            result = new ArrayList<>();
            while(rs.next()){
                productID = rs.getString("ProductID");
                name = rs.getString("Name");
                quantity = rs.getInt("Quantity");
                price = rs.getFloat("Price");
                description = rs.getString("Description");
                img = rs.getString("Image");
                dto = new ProductDTO(productID, name, quantity, description, cateID, price, img);
                result.add(dto);
            }
        }finally{
            closeConnection();
        }
        return result;
    }
    
    public List<ProductDTO> getAllProduct() throws SQLException{
        List<ProductDTO> list = new ArrayList<>();
        String sql = "Select ProductID, Name, Quantity, Description, CateID, Price, DateOfCreate, Image From tbl_Product";
        try {
            con = DBUtils.getConnection();
            if(con != null){
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next()){
                    String productID = rs.getString("ProductID");
                    String name = rs.getString("Name");
                    int quantity = rs.getInt("Quantity");
                    String description = rs.getString("Description");
                    String cateID = rs.getString("CateID");
                    float price = rs.getFloat("Price");
                    Date date = rs.getDate("DateOfCreate");
                    String image = rs.getString("Image");
                    list.add(new ProductDTO(productID, name, quantity, description, cateID, price, date, image));
                }
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public List<ProductDTO> getListProduct(String search) throws SQLException{
        List<ProductDTO> list = new ArrayList<>();
        try {
            con = DBUtils.getConnection();
            if(con != null){
                String sql = "Select ProductID, Name, Description, Price, Image From tbl_Product Where Name Like ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, "%" + search + "%");
                rs = ps.executeQuery();
                while(rs.next()){
                    String productID = rs.getString("ProductID");
                    String name = rs.getString("Name");
                    String description = rs.getString("Description");
                    float price = rs.getFloat("Price");
                    String image = rs.getString("Image");
                    list.add(new ProductDTO(productID, name, description ,price, image));
                }
            }
        } catch (Exception e) {
        }finally{
            closeConnection();
        }
        return list;
    }
    
    public ProductDTO findProduct(String productID) throws SQLException{
        ProductDTO dto = null;
        try{
            con = DBUtils.getConnection();
            if(con != null){
                String sql = "Select Name, Description, Price, Image From tbl_Product Where ProductID = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, productID);
                rs = ps.executeQuery();
                if(rs.next()){
                    String name = rs.getString("Name");
                    String description = rs.getString("Description");
                    float price = rs.getFloat("Price");
                    String image = rs.getString("Image");
                    dto = new ProductDTO(productID, name, description, price, image);
                }
            }
        }catch(Exception e) {
            
        } finally {
            closeConnection();
        }
        return dto;
    }
}
