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
import java.util.HashMap;
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
@WebServlet(name = "LoadCarServlet", urlPatterns = {"/LoadCarServlet"})
public class LoadCarServlet extends HttpServlet {
    private final static int MAX_CAR = 5;
    private final static String LOAD_SUCCESS = "index_page";
    private final static String LOAD_FAILED = "error";

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
        PrintWriter out = response.getWriter();
        String url = page_constant.get(LOAD_FAILED);
        HashMap<String, Vector<String>> colorOfCar = null; 
        HashMap<String, Vector<String>> imageOfCar = null; 
        int pageIndexInt = 1;
        int max_product = 0;
        int page = 0;
        try {
            String pageIndexString = request.getParameter("pageIndex");
            if (pageIndexString != null) {
                pageIndexInt = Integer.parseInt(pageIndexString);
            }
            Vector<CarDTO> result = CarDAO.loadProduct(pageIndexInt, MAX_CAR);
            if (result!=null){
                colorOfCar = new HashMap<>();
                imageOfCar = new HashMap<>();
                for (CarDTO carDTO : result) {
                    colorOfCar.put(carDTO.getName().trim(), CarDAO.getCarColors(carDTO.getName()));
                    imageOfCar.put(carDTO.getName().trim(), CarDAO.getCarImage(carDTO.getName()));
                }
            }
            request.setAttribute("COLORS_CAR", colorOfCar);
            request.setAttribute("IMAGES_CAR", imageOfCar);
            max_product = CarDAO.countPro();
            page = (int) Math.ceil((double) max_product / MAX_CAR);
            request.setAttribute("RESULT_SEARCH", result);
            if (result.size() > 0) {
                if (page == 0) {
                    page = 1;
                }
            }
            request.setAttribute("PAGE_COUNT", page);
            url = page_constant.get(LOAD_SUCCESS);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoadCarServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoadCarServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(LoadCarServlet.class.getName()).log(Level.SEVERE, null, ex);
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
