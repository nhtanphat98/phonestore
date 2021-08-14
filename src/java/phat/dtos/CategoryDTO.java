/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phat.dtos;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CategoryDTO implements Serializable{
    private String cateID, name, description;
    private List<ProductDTO> listProduct;

    public List<ProductDTO> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<ProductDTO> listProduct) {
        this.listProduct = listProduct;
    }

    
    
    
    public CategoryDTO() {
    }

    public CategoryDTO(String cateID, String name) {
        this.cateID = cateID;
        this.name = name;
    }

    public CategoryDTO(String cateID, String name, String description) {
        this.cateID = cateID;
        this.name = name;
        this.description = description;
    }
    
    
    
    public String getCateID() {
        return cateID;
    }

    public void setCateID(String cateID) {
        this.cateID = cateID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
