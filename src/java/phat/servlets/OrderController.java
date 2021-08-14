/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phat.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import phat.daos.OrderDAO;
import phat.daos.ProductDAO;
import phat.dtos.CartDTO;
import phat.dtos.OrderDTO;
import phat.dtos.ProductDTO;
import phat.dtos.UserDTO;

/**
 *
 * @author Admin
 */
public class OrderController extends HttpServlet {

    private final static String ERROR = "shoppingCart.jsp";
    private final static String SUCCESS = "notify.jsp";
    private final static String LOGIN = "index.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        String mess = "Nothing in your cart. Pls add first!!!";
        try {
            HttpSession session = request.getSession();
            UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
            String mes = "";
            if (user != null) {
                CartDTO cart = (CartDTO) session.getAttribute("CART");
                if (!cart.getCart().isEmpty()) {
                    OrderDAO orderDAO = new OrderDAO();
                    String lastID = orderDAO.getLastOrderIDByUser(user.getUserID());
                    String orderID = "";
                    if (lastID != null) {
                        String[] tmp = lastID.split("-");
                        orderID = "OD" + "-" + user.getUserID() + "-" + (Integer.parseInt(tmp[2] + 1));
                    } else {
                        orderID = "OD-" + user.getUserID() + "-1";
                    }
                    ProductDAO dao = new ProductDAO();
                    List<ProductDTO> list = dao.getAllProduct();
                    List<ProductDTO> listCheckQuantity = new ArrayList<>();
                    for (ProductDTO p : cart.getCart().values()) {
                        for (ProductDTO productDTO : list) {
                            if (productDTO.getProductID().equals(p.getProductID())) {
                                productDTO.setQuantity(productDTO.getQuantity() - p.getQuantity());
                                listCheckQuantity.add(productDTO);
                            }
                        }
                    }
                    for (ProductDTO productDTO : listCheckQuantity) {
                        if (productDTO.getQuantity() < 0) {
                            mes = "Quantity of the item " + productDTO.getName() + " which you order is not enough";
                            break;
                        }
                    }
                    if (mes.equals("")) {
                        OrderDTO orderDTO = new OrderDTO();
                        orderDTO.setOrderID(orderID);
                        orderDTO.setUserID(user.getUserID());
                        orderDTO.setTotal(cart.getTotal());
                        orderDTO.setStatus("waiting");
                        orderDTO.setDateOfCreate(new Date());
                        
                        boolean checkCreateOrder = orderDAO.createOrder(orderDTO);
                        if (checkCreateOrder) {
                            int count = 0;
                            for (ProductDTO dto : cart.getCart().values()) {
                                count++;
                                String orderDetailID = orderID + "-" + count;
                                orderDAO.createOrderDetail(orderDetailID, orderID, dto.getProductID(), dto.getQuantity(), dto.getPrice());
                            }
                            orderDAO.setQuantityProduct(listCheckQuantity);
                        }
                        url = SUCCESS;
                        cart.getCart().clear();
                        session.setAttribute("CART", cart);
                    } else {
                        request.setAttribute("mess", mes);
                    }
                }

            } else {
                url = LOGIN;
            }
        } catch (Exception e) {
            log("ERROR at OrderController: " + e.getMessage());
            request.setAttribute("message", mess);
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
