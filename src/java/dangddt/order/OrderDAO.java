package dangddt.order;

import dangddt.order_detail.Order_DetailDAO;
import dangddt.order_detail.Order_DetailDTO;
import dangddt.utils.DBHelper;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.naming.NamingException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tam Dang
 */
public class OrderDAO implements Serializable {

    public static void closeConnection(Connection con, PreparedStatement stm, ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (stm != null) {
            stm.close();
        }
        if (con != null) {
            con.close();
        }
    }

    public static String getNewOrderID() throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        String newID = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT CONCAT('O',SUBSTRING('000000',1,6-LEN(CAST(SUBSTRING(MAX(OrderID),2,6) AS INT)+1)),CAST(SUBSTRING(MAX(orderID),2,6) AS INT)+1)\n"
                        + "FROM [dbo].[Order]";
                stm = con.prepareStatement(sql);
                if (stm != null) {
                    rs = stm.executeQuery();
                    if (rs != null) {
                        if (rs.next()) {
                            newID = rs.getString(1);
                        }
                    }
                }
            }
        } finally {
            closeConnection(con, stm, rs);
        }
        return newID;
    }

    public static void createOrder(String email, String customer_name, String customer_phone, String customer_address, float totalPrice, Vector<Order_DetailDTO> order_details) throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int count = 0;
        String newID = getNewOrderID();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "INSERT [dbo].[Order] VALUES (?,?,NULL,NULL,?,GETDATE(),0,?,?,?,NULL)";
                stm = con.prepareStatement(sql);
                if (null != stm) {
                    stm.setString(1, email);
                    stm.setFloat(2, totalPrice);
                    stm.setString(3, newID);
                    stm.setString(4, customer_name);
                    stm.setString(5, customer_phone);
                    stm.setString(6, customer_address);
                    int row = stm.executeUpdate();
                    if (row > 0) {
                        for (Order_DetailDTO order_detail : order_details) {
                            Order_DetailDAO.createOrderDetail(newID, order_detail.getCarLicensePlate(), order_detail.getRental_date(), order_detail.getReturn_date(), order_detail.getDaysRented(), order_detail.getTotalPrice());
                        }
                    }
                }
            }
        } finally {
            closeConnection(con, stm, rs);
        }
    }
}
