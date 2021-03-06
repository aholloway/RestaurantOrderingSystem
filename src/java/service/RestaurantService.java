package service;

import dao.*;
import java.util.*;

/**
 * hides the complexity of the DAO and other objects
 *
 * @author Drew
 */
public class RestaurantService {

    private IOrderDAO mockDB;
    private double salesTax;
    private double suggestedTip;

    public RestaurantService() {
        mockDB = new MockDatabase();
        salesTax = .05;
        suggestedTip = .2;

    }

    public List<ItemStrategy> getCurrentMenuChoices() throws RuntimeException {
        return mockDB.getCurrentMenuChoices();
    }

    public void saveOrder(List<ItemStrategy> orderList) throws RuntimeException {
        mockDB.saveOrder(orderList);
    }

    public double getSubtotal() {
        double subtotal = 0.0;
        List<ItemStrategy> currentTransaction = mockDB.getCurrentTransaction();
        for (ItemStrategy m : currentTransaction) {
            subtotal += m.getItemPrice() * m.getItemQuantity();
        }
        return subtotal;
    }

    public double getTax() {
        return getSubtotal() * salesTax;
    }

    public double getTotal() {
        return getSubtotal() + getTax();
    }

    public double getSuggestedTip() {
        return suggestedTip * getTotal();
    }
}
