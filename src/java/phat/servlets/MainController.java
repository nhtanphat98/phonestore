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

/**
 *
 * @author Admin
 */
public class MainController extends HttpServlet {
    private final static String ERROR = "error.jsp";
    private final static String LOGIN = "Login";
    private final static String SIGNIN = "index.jsp";
    private final static String SIGNOUT = "SignOutController";
    private final static String SEARCH = "SearchController";
    private final static String VIEWCART = "shoppingCart.jsp";
    private final static String MENU = "MenuController";
    private final static String ADD = "AddController";
    private final static String SEARCHPRODUCT = "SearchProductController";
    private final static String DELETE = "DeleteController";
    private final static String UPDATE = "update.jsp";
    private final static String CONFIRM_UPDATE = "UpdateController";
    private final static String CREATE = "CreateController";
    private final static String DELETE_CART = "DeleteCartController";
    private final static String UPDATE_CART = "UpdateCartController";
    private final static String ORDER =  "OrderController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        String url = ERROR;
        try{
        if("Login".equals(action)){
            url = LOGIN;
        } else if("Search".equals(action)){
            url = SEARCH;
        }else if(action == null){
            url = MENU;
        } else if("ViewCart".equals(action)){
            url = VIEWCART;
        } else if("Add".equals(action)){
            url = ADD;
        } else if("SignOut".equals(action)){
            url = SIGNOUT;
        } else if("SignIn".equals(action)){
            url = SIGNIN;
        } else if("SearchProduct".equals(action)){
            url = SEARCHPRODUCT;
        } else if("Delete".equals(action)){
            url = DELETE;
        } else if("Update".equals(action)){
            url = UPDATE;
        } else if("Confirm Update".equals(action)){
            url = CONFIRM_UPDATE;
        } else if("Create".equals(action)){
            url = CREATE;
        } else if("Delete_Cart".equals(action)){
            url = DELETE_CART;
        } else if("Update_Cart".equals(action)){
            url = UPDATE_CART;
        } else if("Order".equals(action)){
            url = ORDER;
        }
        }catch (Exception e){
            log("ERROR at MainController" + e.toString());
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
