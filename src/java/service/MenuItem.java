package service;

/**
 * This code is a duplicate of Jim Lombardo's menu item class.  I like the 
 * way his code uses lists to store information about the menu items, and I'm
 * seeking to replicate that with my code.  This is a plain old java object,
 * so I hope he doesn't object too much to me using this :)
 * 
 * I did change the Id to a string.  So it wasn't quite so cut and dry!
 * 
 * @author jlombardo
 */
public class MenuItem implements ItemStrategy {
    private String id;
    private String itemName;
    private double itemPrice;
    private String description;
    private int itemQuantity;

    public MenuItem() {
    }

    public MenuItem(String id, String itemName, double itemPrice, 
            String description, int itemQuantity) {
        this.id = id;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.description = description;
        this.itemQuantity = itemQuantity;
    }

    @Override
    public int getItemQuantity() {
        return itemQuantity;
    }

    @Override
    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getItemName() {
        return itemName;
    }

    @Override
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public double getItemPrice() {
        return itemPrice;
    }

    @Override
    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MenuItem other = (MenuItem) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }

    

    public String toString() {
        return "MenuItem{" + "id=" + id + ", itemName=" + itemName 
                + ", itemPrice=" + itemPrice + ", description=" 
                + description + ", quantity=" 
                + itemQuantity + '}';
    }
    
    
}
