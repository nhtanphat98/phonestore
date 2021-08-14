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
import phat.commons.GooglePojo;
import phat.commons.GoogleUtils;
import phat.daos.UserDAO;
import phat.dtos.UserDTO;

/**
 *
 * @author Admin
 */
public class LoginGmailServlet extends HttpServlet {

    private final static String ERROR = "index.jsp";
    private final static String SUCCESS = "success.jsp";
    private final static String ADMIN = "userManagement.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String code = request.getParameter("code");
        String url = ERROR;
        String result = "SignOut";
        try {
            String accessToken = GoogleUtils.getToken(code);
            GooglePojo googlePojo = GoogleUtils.getUserInfo(accessToken);
            if (googlePojo != null) {

                HttpSession session = request.getSession();
                UserDTO dto = null;
                UserDAO dao = new UserDAO();
                if("AD".equals(dao.findRoleUser(googlePojo.getId()))){
                        dto = new UserDTO(googlePojo.getId(), googlePojo.getName(), "AD", "***");
                        url = ADMIN;
                    } else if(dao.findRoleUser(googlePojo.getId()) == null){
                        dto = new UserDTO(googlePojo.getId(), googlePojo.getName(), "user", "***");
                        dao.insertUser(dto);
                        url = SUCCESS;
                    } else {
                        dto = new UserDTO(googlePojo.getId(), googlePojo.getName(), "user", "***");
                        url = SUCCESS;
                    }
                    session.setAttribute("LOGIN_USER", dto);
                    session.setAttribute("result", result);
            }

        } catch (Exception e) {

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
