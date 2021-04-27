/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dangddt.servlet;

import dangddt.account.AccountDTO;
import dangddt.car.CarDTO;
import dangddt.cart.CartObject;
import dangddt.order.OrderDAO;
import dangddt.order_detail.Order_DetailDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Tam Dang
 */
@WebServlet(name = "CheckOutServlet", urlPatterns = {"/CheckOutServlet"})
public class CheckOutServlet extends HttpServlet {

    static final private String CHECK_OUT_SUCCESS = "loadcar";
    static final private String CHECK_OUT_FAILED = "error";

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Map<String, String> page_constant = (Map<String, String>) request.getServletContext().getAttribute("PAGE_CONSTANT");
        String url = page_constant.get(CHECK_OUT_FAILED);
        HttpSession session = null;
        try {
            String customer_name = request.getParameter("customer_name");
            String customer_phone = request.getParameter("customer_phone");
            String customer_address = request.getParameter("customer_address");
            session = request.getSession(false);
            if (session != null) {
                Vector<Order_DetailDTO> list_car = null;
                CartObject cart = (CartObject) session.getAttribute("CART");
                if (cart != null) {
                    list_car = new Vector<>();
                    for (CarDTO carDto : cart.getItems().values()) {
                        list_car.add(new Order_DetailDTO(carDto.getLicensePlate(), carDto.getRental_date(), carDto.getReturn_date(), carDto.getDaysRented(), carDto.getTotalPrice()));
                    }
                    OrderDAO.createOrder(((AccountDTO) session.getAttribute("ACCOUNT")).getEmail(), customer_name, customer_phone, customer_address, cart.getTotalPrice(), list_car);
                }
                url = page_constant.get(CHECK_OUT_SUCCESS);
                session.removeAttribute("CART");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CheckOutServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CheckOutServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(CheckOutServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
            out.close();
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
