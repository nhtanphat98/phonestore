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
import phat.daos.UserDAO;
import phat.dtos.UserDTO;
import phat.dtos.UserErrDTO;

/**
 *
 * @author Admin
 */
public class LoginServlet extends HttpServlet {

    private final static String ERROR = "index.jsp";
    private final static String USER = "success.jsp";
    private final static String ADMIN = "userManagement.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String url = ERROR;
        UserErrDTO err = new UserErrDTO();
        try {
            boolean checkErr = true;
            if (username.isEmpty()) {
                err.setUserIDErr("Username cannot empty!");
                checkErr = false;
            } else if (!username.matches("\\w+")) {

                err.setUserIDErr("Username do not have special characters");
                checkErr = false;

            }
            if (password.isEmpty()) {
                err.setPasswordErr("Password cannot empty!");
                checkErr = false;
            }

            if (checkErr) {
                UserDAO dao = new UserDAO();
                UserDTO user = dao.checkLogin(username, password);
                if (user != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("LOGIN_USER", user);
                    if ("AD".equals(user.getRoleID())) {
                        url = ADMIN;
                        
                    } else {
                        session.setAttribute("result", "SignOut");
                        session.setAttribute("avatar", "avatar.png");
                        url = USER;
                    }
                } else {
                    request.setAttribute("msg", "Username or Password is not correct");
                    request.getRequestDispatcher(url).forward(request, response);
                }
            } else {
                request.setAttribute("err", err);
                request.getRequestDispatcher(url).forward(request, response);
            }
        } catch (Exception e) {
            log("Error at LoginServlet: " + e.toString());
        } finally {
            response.sendRedirect(url);
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
