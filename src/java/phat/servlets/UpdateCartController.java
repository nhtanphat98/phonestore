/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phat.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import phat.dtos.CartDTO;
import phat.dtos.ProductDTO;

/**
 *
 * @author Admin
 */
public class UpdateCartController extends HttpServlet {

    private final static String ERROR = "shoppingCart.jsp";
    private final static String SUCCESS = "shoppingCart.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try{
            String productID = request.getParameter("productID");
            String quantity = request.getParameter("quantity");
            HttpSession session = request.getSession();
            CartDTO cart = (CartDTO) session.getAttribute("CART");
            ProductDTO product = null;
            for (ProductDTO dto : cart.getCart().values()) {
                if(dto.getProductID().equals(productID)){
                    product = new ProductDTO();
                    product.setProductID(productID);
                    product.setName(dto.getName());
                    product.setPrice(dto.getPrice());
                    product.setImage(dto.getImage());
                    product.setQuantity(Integer.parseInt(quantity));
                    if(product.getQuantity() > 5){
                        product.setQuantity(5);
                        request.setAttribute("mess", "you can only order maximum of 5 products of the same type.");
                    }
                    break;
                }
            }
            cart.update(productID, product);
            session.setAttribute("CART", cart);
            url = SUCCESS;
        }catch(Exception e){
            log("ERROR at UpdateCartController " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
