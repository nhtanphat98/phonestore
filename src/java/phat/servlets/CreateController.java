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
import phat.daos.UserDAO;
import phat.dtos.UserDTO;
import phat.dtos.UserErrDTO;

/**
 *
 * @author Admin
 */
public class CreateController extends HttpServlet {

    private static final String ERROR = "createUser.jsp";
    private static final String SUCCESS = "index.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        UserErrDTO err = new UserErrDTO();
        try {
            String userID = request.getParameter("userID");
            String fullName = request.getParameter("fullName");
            String password = request.getParameter("password");
            String confirm = request.getParameter("confirm");
            boolean flag = true;
            if (userID.length() < 3) {
                flag = false;
                err.setUserIDErr("userID must be greater then 3");
            }
            if (fullName.length() < 5) {
                flag = false;
                err.setFullNameErr("Full Name must be greater then 5");
            }
            if (!password.equals(confirm)) {
                flag = false;
                err.setConfirmErr("Not same");
            }
            if (flag) {
                UserDAO dao = new UserDAO();
                boolean check = dao.checkDuplicate(userID);
                if (check) {
                    err.setUserIDErr("Trùng ID kìa!");
                    request.setAttribute("err", err);
                } else {
                    UserDTO user = new UserDTO(userID, fullName, "user", password);
                    if (dao.insertUser(user)) {
                        url = SUCCESS;
                    }
                }

            } else {
                request.setAttribute("err", err);
            }
        } catch (Exception e) {
            log("Error at CreateController: " + e.toString());

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
