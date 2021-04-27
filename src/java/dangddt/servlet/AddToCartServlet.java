/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dangddt.servlet;

import dangddt.car.CarDTO;
import dangddt.cart.CartObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
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
 * @author tamda
 */
@WebServlet(name = "AddToCartServlet", urlPatterns = {"/AddToCartServlet"})
public class AddToCartServlet extends HttpServlet {

    private final String ERROR_PAGE = "error";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //B1. Tạo view cho chức năng AddToCart trong shopping.jsp
    //B2. Map label của form với tên resource:AddToCartServlet trong file indexPage.txt
    //B3. Tạo Servlet chức năng.
    //B4. Response HTML String về để hiển thị cho Client.
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = ERROR_PAGE;
        try {
            //1. Đi đến chỗ để giỏ
            HttpSession session = request.getSession();
            if (session != null) {
                //2.Lấy cái giỏ
                CartObject cart = (CartObject) session.getAttribute("CART");
                if (cart == null) {
                    cart = new CartObject();
                }
                //3. Lấy món hàng cần thêm vào giỏ ở chỗ để món hàng
                String typeFilter = request.getParameter("typeFilter");
                String licensePlate = request.getParameter("carLicensePlate");
                String name = request.getParameter("carName");
                String color = request.getParameter("carColor");
                String image = request.getParameter("carImage");
                String category = request.getParameter("carCategory");
                int year = Integer.parseInt(request.getParameter("carYear").trim());
                Float price = Float.parseFloat(request.getParameter("carPrice"));

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
                String rental_dateString = request.getParameter("rental_date");
                String rental_timeString = request.getParameter("rental_time") + ":00.000";
                Date parsedDate = dateFormat.parse(rental_dateString + " " + rental_timeString);
                Timestamp rental_date = new java.sql.Timestamp(parsedDate.getTime());

                String return_dateString = request.getParameter("return_date");
                String return_timeString = request.getParameter("return_time") + ":00.000";
                parsedDate = dateFormat.parse(return_dateString + " " + return_timeString);
                Timestamp return_date = new java.sql.Timestamp(parsedDate.getTime());
                
                int daysRented = Math.round((return_date.getTime() - rental_date.getTime())/(24*60*60*1000)*100/100);
                if (daysRented==0){
                    daysRented = 1;
                }
                float totalPrice = price * daysRented;
                CarDTO dto = new CarDTO(licensePlate, name, image, color, year, category, price, rental_date, return_date, daysRented, totalPrice);
                //4.Thêm món hàng vào giỏ
                cart.addItemToCart(dto);
                cart.setTotalPrice(cart.getTotalPrice()+dto.getTotalPrice());
                System.out.println(cart.getTotalPrice());
                session.setAttribute("CART", cart);
                if (typeFilter.equals("byName")) {
                    int amount = Integer.parseInt(request.getParameter("amount"));
                    String txtSearch = request.getParameter("searchValue");
                    url = "filter?txtSearch="+txtSearch+"&rental_date="+rental_dateString+"&rental_time="+rental_timeString+"&return_date="+return_dateString+"&return_time="+return_timeString+"&amount="+amount+"&typeFilter=byName";
                }else if(typeFilter.equals("byCategory")){
                    int amount = Integer.parseInt(request.getParameter("amount"));
                    String carCategory = request.getParameter("searchValue");
                    url = "filter?carCategory="+carCategory+"&rental_date="+rental_dateString+"&rental_time="+rental_timeString+"&return_date="+return_dateString+"&return_time="+return_timeString+"&amount="+amount+"&typeFilter=byCategory";
                }
                System.out.println(cart.getItems().size());
            }
        } catch (ParseException ex) {
            Logger.getLogger(AddToCartServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            response.sendRedirect(url);
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
