
package service;

/**
 * One improvement I can make on Jim's code is to have the menu item be based
 * on an interface.  This will add more flexibility if a different type of 
 * item ever needed to be used.  I renamed this ItemStrategy as other items
 * could also make use of this interface. * 
 *
 * @author Drew
 */
public interface ItemStrategy {

    String getDescription();

    String getId();

    String getItemName();

    double getItemPrice();

    void setDescription(String description);

    void setId(String id);

    void setItemName(String itemName);

    void setItemPrice(double itemPrice);
    
    public int getItemQuantity();

    public void setItemQuantity(int itemQuantity);

}
