/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dangddt.order_detail;

import static dangddt.order.OrderDAO.closeConnection;
import dangddt.utils.DBHelper;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Vector;
import javax.naming.NamingException;

/**
 *
 * @author Tam Dang
 */
public class Order_DetailDAO implements Serializable {

    public static void createOrderDetail(String orderID, String carLicensePlate, Timestamp rental_date, Timestamp return_date, int daysRented, float totalPrice) throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int count = 0;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "INSERT Order_Detail VALUES (?,?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                if (null != stm) {
                    stm.setString(1, orderID);
                    stm.setString(2, carLicensePlate);
                    stm.setTimestamp(3, rental_date);
                    stm.setTimestamp(4, return_date);
                    stm.setInt(5, daysRented);
                    stm.setFloat(6, totalPrice);
                    int row = stm.executeUpdate();
                }
            }
        } finally {
            closeConnection(con, stm, rs);
        }
    }
}
