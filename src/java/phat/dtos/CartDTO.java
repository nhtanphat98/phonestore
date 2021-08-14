/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phat.dtos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class CartDTO implements Serializable {

    private Map<String, ProductDTO> cart;

    public CartDTO() {

    }

    public CartDTO(Map<String, ProductDTO> cart) {
        this.cart = cart;
    }

    public Map<String, ProductDTO> getCart() {
        return cart;
    }

    public void setCart(Map<String, ProductDTO> cart) {
        this.cart = cart;
    }

    public void add(ProductDTO dto) {
        if (cart == null) {
            cart = new HashMap<>();
        }
        if (this.cart.containsKey(dto.getProductID())) {
            int quantity = cart.get(dto.getProductID()).getQuantity() + 1;
            dto.setQuantity(quantity);
        } 
        cart.put(dto.getProductID(), dto);

    }

    public void delete(String id) {
        if (cart == null) {
            return;
        }
        if (cart.containsKey(id)) {
            cart.remove(id);
        }
    }

    public void update(String id, ProductDTO dto) {
        if (cart != null) {
            if (cart.containsKey(id)) {
                cart.replace(id, dto);
            }
        }
    }
    public float getTotal() throws Exception {
        float result = 0;
        for(ProductDTO dto: cart.values()){
            result += dto.getQuantity() * dto.getPrice();
        }
        return result;
    }
}
