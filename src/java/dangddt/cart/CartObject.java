package dangddt.cart;

import dangddt.car.CarDTO;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tamda
 */
public class CartObject implements Serializable {

    private Map<String, CarDTO> items;
    private float totalPrice;
    
    
    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
    public CartObject() {

    }
    public Map<String, CarDTO> getItems() {
        return items;
    }

    public void addItemToCart(CarDTO dto) {
        if (null == this.items) {
            this.items = new HashMap<>();
        }
        this.items.put(dto.getLicensePlate(), dto);
    }

    public void removeItemFromCart(String id) {
        if (this.items == null) {
            return;
        }
        if (this.items.containsKey(id)) {
            this.items.remove(id);
            if (this.items.isEmpty()) {
                this.items = null;
            }
        }
    }
}
