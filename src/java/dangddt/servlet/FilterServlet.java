/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dangddt.servlet;

import dangddt.car.CarDAO;
import dangddt.car.CarDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

/**
 *
 * @author Tam Dang
 */
@WebServlet(name = "FilterServlet", urlPatterns = {"/FilterServlet"})
public class FilterServlet extends HttpServlet {

    private final static String FILTER_SUCCESS = "index_page";
    private final static String FILTER_FAILED = "error";

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
        Map<String, String> page_constant = (Map<String, String>) request.getServletContext().getAttribute("PAGE_CONSTANT");
        String url = page_constant.get(FILTER_FAILED);
        try {
            String typeFilter = request.getParameter("typeFilter").trim();
            if (typeFilter.equals("byName")) {
                String keyword = request.getParameter("txtSearch").trim();

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
                String rental_dateString = request.getParameter("rental_date");
                String rental_timeString = request.getParameter("rental_time") + ":00.000";
                Date parsedDate = dateFormat.parse(rental_dateString + " " + rental_timeString);
                Timestamp rental_date = new java.sql.Timestamp(parsedDate.getTime());

                String return_dateString = request.getParameter("return_date");
                String return_timeString = request.getParameter("return_time") + ":00.000";
                parsedDate = dateFormat.parse(return_dateString + " " + return_timeString);
                Timestamp return_date = new java.sql.Timestamp(parsedDate.getTime());

                int amount = Integer.parseInt(request.getParameter("amount"));

                Vector<CarDTO> list_car_result = CarDAO.filterByName(keyword, rental_date, return_date, amount);

                request.setAttribute("LIST_CAR", list_car_result);
                url = page_constant.get(FILTER_SUCCESS);
            } else if (typeFilter.equals("byCategory")) {
                String category = request.getParameter("carCategory").trim();

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
                String rental_dateString = request.getParameter("rental_date");
                String rental_timeString = request.getParameter("rental_time") + ":00.000";
                Date parsedDate = dateFormat.parse(rental_dateString + " " + rental_timeString);
                Timestamp rental_date = new java.sql.Timestamp(parsedDate.getTime());

                String return_dateString = request.getParameter("return_date");
                String return_timeString = request.getParameter("return_time") + ":00.000";
                parsedDate = dateFormat.parse(return_dateString + " " + return_timeString);
                Timestamp return_date = new java.sql.Timestamp(parsedDate.getTime());

                int amount = Integer.parseInt(request.getParameter("amount"));

                Vector<CarDTO> list_car_result = CarDAO.filterByCategory(category, rental_date, return_date, amount);

                request.setAttribute("LIST_CAR", list_car_result);
                url = page_constant.get(FILTER_SUCCESS);

            }
        } catch (ParseException ex) {
            Logger.getLogger(FilterServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FilterServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FilterServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(FilterServlet.class.getName()).log(Level.SEVERE, null, ex);
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
