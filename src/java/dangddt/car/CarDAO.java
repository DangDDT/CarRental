/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dangddt.car;

import static dangddt.account.AccountDAO.closeConnection;
import dangddt.account.AccountDTO;
import dangddt.utils.DBHelper;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.naming.NamingException;

/**
 *
 * @author Tam Dang
 */
public class CarDAO implements Serializable {

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

    public static Vector<CarDTO> filterByName(String keyword, Timestamp rental_date, Timestamp return_date, int amount) throws SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Vector<CarDTO> result = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT carLicensePlate, carName, carImage, carCategory, carPrice, carColor, carYear\n"
                        + "FROM Car\n"
                        + "WHERE Car.carLicensePlate NOT IN (SELECT OD.carLicensePlate\n"
                        + "                                  FROM  Order_Detail OD JOIN Car C ON OD.carLicensePlate = C.carLicensePlate\n"
                        + "                                  WHERE C.carName LIKE ? AND (? BETWEEN OD.rental_date AND OD.return_date) OR (? BETWEEN OD.rental_date AND OD.return_date) ) \n"
                        + "AND Car.carName LIKE ?\n"
                        + "ORDER BY carYear ASC\n"
                        + "OFFSET 0 ROWS FETCH NEXT ? ROWS ONLY";
                stm = con.prepareStatement(sql);
                if (stm != null) {
                    stm.setString(1, "%" + keyword + "%");
                    stm.setTimestamp(2, rental_date);
                    stm.setTimestamp(3, return_date);
                    stm.setString(4, "%" + keyword + "%");
                    stm.setInt(5, amount);
                    rs = stm.executeQuery();
                    result = new Vector();
                    while (rs.next()) {
                        result.add(new CarDTO(rs.getString("carLicensePlate"), rs.getString("carName"), rs.getString("carImage"), rs.getString("carColor"),
                                rs.getInt("carYear"), rs.getString("carCategory"), rs.getFloat("carPrice")));
                    }
                }
            }
        } finally {
            closeConnection(con, stm, rs);
        }
        return result;
    }

    public static Vector<CarDTO> filterByCategory(String category, Timestamp rental_date, Timestamp return_date, int amount) throws SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Vector<CarDTO> result = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT carLicensePlate, carName, carImage, carCategory, carPrice, carColor, carYear\n"
                        + "FROM Car\n"
                        + "WHERE Car.carLicensePlate NOT IN (SELECT OD.carLicensePlate\n"
                        + "                                  FROM  Order_Detail OD JOIN Car C ON OD.carLicensePlate = C.carLicensePlate\n"
                        + "                                  WHERE C.carCategory LIKE ? AND (? BETWEEN OD.rental_date AND OD.return_date) OR (? BETWEEN OD.rental_date AND OD.return_date) ) \n"
                        + "AND Car.carCategory LIKE ?\n"
                        + "ORDER BY carYear ASC\n"
                        + "OFFSET 0 ROWS FETCH NEXT ? ROWS ONLY";
                stm = con.prepareStatement(sql);
                if (stm != null) {
                    stm.setString(1, "%" + category + "%");
                    stm.setTimestamp(2, rental_date);
                    stm.setTimestamp(3, return_date);
                    stm.setString(4, "%" + category + "%");
                    stm.setInt(5, amount);
                    rs = stm.executeQuery();
                    result = new Vector();
                    while (rs.next()) {
                        result.add(new CarDTO(rs.getString("carLicensePlate"), rs.getString("carName"), rs.getString("carImage"), rs.getString("carColor"),
                                rs.getInt("carYear"), rs.getString("carCategory"), rs.getFloat("carPrice")));
                    }
                }
            }
        } finally {
            closeConnection(con, stm, rs);
        }
        return result;
    }

    public static int countPro() throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int count = 0;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT COUNT(M.carName)\n"
                        + "FROM (SELECT DISTINCT carName, carCategory, carYear, Count(carName) AS 'carQuantity'\n"
                        + "FROM Car\n"
                        + "GROUP BY carName, carCategory, carYear) M";
                stm = con.prepareStatement(sql);
                if (null != stm) {
                    rs = stm.executeQuery();
                    if (rs != null) {
                        if (rs.next()) {
                            count = rs.getInt(1);
                        }
                    }
                }
            }
        } finally {
            closeConnection(con, stm, rs);
        }
        return count;
    }

    public static Vector<String> getCarColors(String carName) throws SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Vector<String> result = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT DISTINCT carColor\n"
                        + "FROM Car\n"
                        + "WHERE carName = ?";
                stm = con.prepareStatement(sql);
                if (null != stm) {
                    stm.setString(1, carName.trim());
                    rs = stm.executeQuery();
                    if (rs != null) {
                        result = new Vector<>();
                        while (rs.next()) {
                            result.add(rs.getString("carColor"));
                        }
                    }
                }
            }
        } finally {
            closeConnection(con, stm, rs);
        }
        return result;
    }

    public static Vector<String> getCarImage(String carName) throws SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Vector<String> result = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT DISTINCT carImage\n"
                        + "FROM Car\n"
                        + "WHERE carName = ?";
                stm = con.prepareStatement(sql);
                if (null != stm) {
                    stm.setString(1, carName.trim());
                    rs = stm.executeQuery();
                    if (rs != null) {
                        result = new Vector<>();
                        while (rs.next()) {
                            result.add(rs.getString("carImage"));
                        }
                    }
                }
            }
        } finally {
            closeConnection(con, stm, rs);
        }
        return result;
    }

    public static Vector<CarDTO> loadProduct(int pageIndex, int max_row) throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Vector<CarDTO> result;
        result = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT DISTINCT carName, carCategory, carYear, Count(carName) AS 'carQuantity'\n"
                        + "FROM Car\n"
                        + "GROUP BY carName, carCategory, carYear\n"
                        + "ORDER BY carQuantity DESC \n"
                        + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
                stm = con.prepareStatement(sql);
                if (null != stm) {
                    stm.setInt(1, (pageIndex - 1) * max_row);
                    stm.setInt(2, max_row);
                    rs = stm.executeQuery();
                    if (rs != null) {
                        result = new Vector<>();
                        while (rs.next()) {
                            result.add(new CarDTO(rs.getString("carName"), rs.getInt("carYear"), rs.getString("carCategory"), rs.getInt("carQuantity")));
                        }
                    }
                }
            }
        } finally {
            closeConnection(con, stm, rs);
        }
        return result;
    }
}
