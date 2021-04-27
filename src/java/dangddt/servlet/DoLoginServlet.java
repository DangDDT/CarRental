/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dangddt.servlet;

import dangddt.account.AccountDAO;
import dangddt.account.AccountDTO;
import dangddt.recapcha.VerifyUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tam Dang
 */
@WebServlet(name = "DoLoginServlet", urlPatterns = {"/DoLoginServlet"})
public class DoLoginServlet extends HttpServlet {

    private static final String LOGIN_SUCCESS = "loadcar";
    private static final String LOGIN_FAILED = "login_page";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String, String> page_constant = (Map<String, String>) request.getServletContext().getAttribute("PAGE_CONSTANT");
        String url = page_constant.get(LOGIN_FAILED);
        boolean valid = true;
        String errorString = null;
        try {
            String email = request.getParameter("txtEmail").trim();
            String password = request.getParameter("txtPassword").trim();
            // Check userName & password
            AccountDTO result = AccountDAO.checkLogin(email, password);
            if (result == null) {
                valid = false;
                errorString = "Email or password invalid!";
            }
            if (valid) {
                String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
                System.out.println("gRecaptchaResponse=" + gRecaptchaResponse);
                // Verify CAPTCHA.
                valid = VerifyUtils.verify(gRecaptchaResponse);
                if (!valid) {
                    errorString = "Captcha invalid!";
                }
            }
            if (!valid) {
                request.setAttribute("errorString", errorString);
                request.getRequestDispatcher(url).forward(request, response);
            } else {
                url = page_constant.get(LOGIN_SUCCESS);
                request.getSession().setAttribute("ACCOUNT", result);
                request.getRequestDispatcher(url).forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DoLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(DoLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

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
