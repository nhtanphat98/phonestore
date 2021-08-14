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
import java.util.List;
import phat.dtos.UserDTO;
import phat.utils.DBUtils;
/**
 *
 * @author Admin
 */
public class UserDAO implements Serializable{
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    void closeConnection()throws SQLException{
        if(rs != null)
            rs.close();
        if(ps != null)
            ps.close();
        if(con != null)
            con.close();
    }
    
    public UserDTO checkLogin(String userID, String password) throws SQLException {
        UserDTO user = null;

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Select FullName, Role From Registration Where Username = ? and Password = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, userID);
                ps.setString(2, password);
                rs = ps.executeQuery();
                if (rs.next()) {
                    String fullName = rs.getString("FullName");
                    String roleID = rs.getString("Role");
                    user = new UserDTO(userID, fullName, roleID, "***");
                }
            }
        } catch (Exception e) {
            
        } finally {
            closeConnection();
        }
        return user;
    } 
    
    public List<UserDTO> getListUser(String search) throws SQLException{
        List<UserDTO> list = new ArrayList<>();
        try{
            con = DBUtils.getConnection();
            if(con != null){
                String sql = "Select Username, Fullname, Role From Registration Where FullName like ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, "%" + search + "%");
                rs = ps.executeQuery();
                while(rs.next()){
                    String userID = rs.getString("Username");
                    String fullname = rs.getString("FullName");
                    String password = "***";
                    String role = rs.getString("Role");
                    list.add(new UserDTO(userID, fullname, role, password));
                } 
            }
        }catch(Exception e){
            
        }finally{
            closeConnection();
        }
        return list;
    }
    
    public boolean deleteUser(String userID) throws SQLException{
        boolean check = false;
        try {
            con = DBUtils.getConnection();
            if(con != null){
                String sql = "Delete Registration\n"+
                            "Where Username = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, userID);
                check = ps.executeUpdate() > 0 ? true:check;
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean updateUser(UserDTO user) throws SQLException{
        boolean check = false;
        try {
            con = DBUtils.getConnection();
            if(con != null){
                String sql = "Update Registration\n"+
                            "SET FullName = ?, Role = ?\n"+
                            "WHERE Username = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, user.getFullName());
                ps.setString(2, user.getRoleID());
                ps.setString(3, user.getUserID());
                check = ps.executeUpdate() > 0 ? true:check;
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean insertUser(UserDTO user) throws SQLException{
        boolean check = false;
        
        try {
            con = DBUtils.getConnection();
            if(con != null){
                String sql = "INSERT INTO Registration(Username, FullName, Password, Role)\n"+
                            "VALUES(?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setString(1, user.getUserID());
                ps.setString(2, user.getFullName());
                ps.setString(3, user.getPassword());
                ps.setString(4, "user");
                check = ps.executeUpdate() > 0 ? true:check;
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public String findRoleUser(String userID) throws  SQLException{
        try {
            con = DBUtils.getConnection();
            if(con != null){
                String sql = "Select Role\n"+
                            "From Registration\n"+
                            "WHERE Username = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, userID);
                
                rs = ps.executeQuery();
                if(rs.next()){
                    String role = rs.getString("Role");
                    return role;
                }
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return null;
    }
    
    public boolean checkDuplicate(String userID) throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            con = DBUtils.getConnection();
            if(con != null){
                String sql = "Select Username\n"+
                            "From Registration\n"+
                            "WHERE Username = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, userID);
                
                rs = ps.executeQuery();
                if(rs.next()){
                    check = true;
                }
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return check;
    }
    
}
