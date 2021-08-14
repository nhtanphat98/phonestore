/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phat.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import phat.dtos.CategoryDTO;
import phat.utils.DBUtils;

/**
 *
 * @author Admin
 */
public class CategoryDAO {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    public CategoryDAO() {
    }
    
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
    public List<CategoryDTO> getAllCategory() throws Exception{
        List<CategoryDTO> result = null;
        String name, cateID, des;
        CategoryDTO dto = null;
        String sql = "Select CateID, Name, Description From tbl_Category";
        try{
            con = DBUtils.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            result = new ArrayList<>();
            while(rs.next()){
                cateID = rs.getString("CateID");
                name = rs.getString("Name");
                des = rs.getString("Description");
                dto = new CategoryDTO(cateID, name, des);
                result.add(dto);
            }
        }finally{
            closeConnection();
        }
        return result;
    }
}
