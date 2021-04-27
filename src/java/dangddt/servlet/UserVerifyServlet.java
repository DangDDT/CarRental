package dangddt.servlet;

import dangddt.account.AccountDAO;
import dangddt.tool.SendEmail;
import dangddt.tool.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "UserVerifyServlet", urlPatterns = {"/UserVerifyServlet"})
public class UserVerifyServlet extends HttpServlet {
    private final static String VERIFY_SUCCESS = "verify.jsp";
    private final static String VERIFY_FAILED = "signup_page";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Map<String, String> page_constant = (Map<String, String>) request.getServletContext().getAttribute("PAGE_CONSTANT");
        String url = page_constant.get(VERIFY_FAILED);
         try (PrintWriter out = response.getWriter()) {
            //feth form value
            String name = request.getParameter("txtFullname").trim();
            String email = request.getParameter("txtEmail").trim();
            String password = request.getParameter("txtPassword").trim();
            String phone = request.getParameter("txtPhone").trim();
            String address = request.getParameter("txtAddress").trim();
            //create instance object of the SendEmail Class
            if (AccountDAO.isDuplicate(email)) {
                request.setAttribute("ERROR_STRING", "Your email is existed");
                request.getRequestDispatcher(url).forward(request, response);
                return;
            } else {
                SendEmail sm = new SendEmail();
                //get the 6-digit code
                String code = sm.getRandom();

                //craete new user using all information
                User user = new User(name, email, password, code, phone, address);

                //call the send email method
                boolean test = sm.sendEmail(user);

                //check if the email send successfully
                if (test) {
                    HttpSession session = request.getSession();
                    session.setAttribute("authcode", user);
                    response.sendRedirect(VERIFY_SUCCESS);
                } else {
                    response.sendRedirect("error.jsp");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserVerifyServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserVerifyServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(UserVerifyServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
