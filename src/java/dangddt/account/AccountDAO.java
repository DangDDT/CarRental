/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dangddt.account;

import dangddt.utils.DBHelper;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author Tam Dang
 */
public class AccountDAO implements Serializable {

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

    public static AccountDTO checkLogin(String email, String password) throws SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT email, password, fullname, phone, address, createDate, status \n"
                        + "FROM Account \n"
                        + "WHERE email = ? COLLATE SQL_Latin1_General_CP1_CS_AS \n"
                        + "AND password = ? COLLATE SQL_Latin1_General_CP1_CS_AS";
                stm = con.prepareStatement(sql);
                if (stm != null) {
                    stm.setString(1, email);
                    stm.setString(2, password);
                    rs = stm.executeQuery();
                    if (rs.next()) {
                        return new AccountDTO(rs.getString("email"), rs.getString("password"), rs.getString("fullname"), rs.getString("phone"), rs.getString("address"), rs.getDate("createDate"), (rs.getInt("status") == 1));
                    }
                }
            }
        } finally {
            closeConnection(con, stm, rs);
        }
        return null;
    }

    public static boolean createAccount(String email, String password, String fullname, String phone, String address) throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "INSERT Account VALUES(?,?,?,?,?,GETDATE(),1)";
                stm = con.prepareStatement(sql);
                if (stm != null) {
                    stm.setString(1, email);
                    stm.setString(2, password);
                    stm.setString(3, fullname);
                    stm.setString(4, phone);
                    stm.setString(5, address);
                    int rows = stm.executeUpdate();
                    if (rows > 0) {
                        return true;
                    }
                }
            }
        } finally {
            closeConnection(con, stm, rs);
        }
        return false;
    }
    public static boolean isDuplicate(String email) throws SQLException, ClassNotFoundException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT email\n"
                        + "FROM Account \n"
                        + "WHERE email = ?";
                stm = con.prepareStatement(sql);
                if (stm != null) {
                    stm.setString(1, email);
                    rs = stm.executeQuery();
                    if (rs.next()) {
                        return true;
                    }
                }
            }
        } finally {
            closeConnection(con, stm, rs);
        }
        return false;
    }
}
