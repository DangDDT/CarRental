/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dangddt.order;

import dangddt.order_detail.Order_DetailDTO;
import java.sql.Timestamp;
import java.util.Map;
import java.util.Vector;

/**
 *
 * @author Tam Dang
 */
public class OrderDTO {

    private String orderID;
    private String email;
    private String customer_name;
    private String customer_phone;
    private String customer_address;
    private String feedback;
    private int star;
    private float totalPrice;
    private Timestamp createdDate;
    private boolean isDelete;
    Map<String, Vector<Order_DetailDTO>> orderDetail;

    public OrderDTO(String orderID, String email, String customer_name, String customer_phone, String customer_address, String feedback, int star, float totalPrice, Timestamp createdDate, boolean isDelete, Map<String, Vector<Order_DetailDTO>> orderDetail) {
        this.orderID = orderID;
        this.email = email;
        this.customer_name = customer_name;
        this.customer_phone = customer_phone;
        this.customer_address = customer_address;
        this.feedback = feedback;
        this.star = star;
        this.totalPrice = totalPrice;
        this.createdDate = createdDate;
        this.isDelete = isDelete;
        this.orderDetail = orderDetail;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    

    public Map<String, Vector<Order_DetailDTO>> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(Map<String, Vector<Order_DetailDTO>> orderDetail) {
        this.orderDetail = orderDetail;
    }

    public OrderDTO() {
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

}
