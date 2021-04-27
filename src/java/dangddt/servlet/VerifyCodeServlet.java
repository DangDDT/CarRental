package dangddt.servlet;

import dangddt.account.AccountDAO;
import dangddt.account.AccountDTO;
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

@WebServlet(name = "VerifyCodeServlet", urlPatterns = {"/VerifyCodeServlet"})
public class VerifyCodeServlet extends HttpServlet {

    private final static String VERIFY_SUCCESS = "login_page";
    private final static String VERIFY_FAILED = "verify_page";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Map<String, String> page_constant = (Map<String, String>) request.getServletContext().getAttribute("PAGE_CONSTANT");
        String url = page_constant.get(VERIFY_FAILED);
        try {

            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("authcode");

            String code = request.getParameter("authcode");

            if (code.equals(user.getCode())) {
                AccountDTO new_account = new AccountDTO(user.getEmail(), user.getPassword(), user.getName(), user.getPhone(), user.getAddress(), null, true);
                AccountDAO.createAccount(new_account.getEmail(), new_account.getPassword(), new_account.getFullname(), new_account.getPhone(), new_account.getAddress());
                url = page_constant.get(VERIFY_SUCCESS);
            } else {
                request.setAttribute("ERROR_STRING", "Verify code invalid, please again");
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VerifyCodeServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VerifyCodeServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(VerifyCodeServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
