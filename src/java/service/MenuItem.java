package service;

/**
 * This code is a duplicate of Jim Lombardo's menu item class. I like the way
 * his code uses lists to store information about the menu items, and I'm
 * seeking to replicate that with my code. This is a plain old java object, so I
 * hope he doesn't object too much to me using this :)
 *
 * I did change the Id to a string. So it wasn't quite so cut and dry!
 *
 * @author jlombardo
 */
public class MenuItem implements ItemStrategy {

    private String id;
    private String itemName;
    private double itemPrice;
    private String description;
    private int itemQuantity;

    public MenuItem(String id, String itemName, double itemPrice,
            String description, int itemQuantity) {
        this.setId(id);
        this.setItemName(itemName);
        this.setItemPrice(itemPrice);
        this.setDescription(description);
        this.setItemQuantity(itemQuantity);
    }

    @Override
    public final int getItemQuantity() {
        return itemQuantity;
    }

    @Override
    public final void setItemQuantity(int itemQuantity) {
        if (itemPrice <0) {
            throw new InvalidInputException("itemQuantity may not be negative");
        }
        this.itemQuantity = itemQuantity;
    }

    @Override
    public final String getId() {
        return id;
    }

    @Override
    public final void setId(String id) {
        if (id == null || id.isEmpty()) {
            throw new InvalidInputException("id may not be null");
        }
        this.id = id;
    }

    @Override
    public final String getItemName() {
        return itemName;
    }

    @Override
    public final void setItemName(String itemName) {
        if (itemName == null || itemName.isEmpty()) {
            throw new InvalidInputException("itemName may not be null");
        }
        this.itemName = itemName;
    }

    @Override
    public final double getItemPrice() {
        return itemPrice;
    }

    @Override
    public final void setItemPrice(double itemPrice) {
        if (itemPrice <0) {
            throw new InvalidInputException("itemPrice may not be negative");
        }
        this.itemPrice = itemPrice;
    }

    @Override
    public final String getDescription() {
        return description;
    }

    @Override
    public final void setDescription(String description) {
        if (description == null || description.isEmpty()) {
            throw new InvalidInputException("description may not be null");
        }
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

    @Override
    public String toString() {
        return "MenuItem{" + "id=" + id + ", itemName=" + itemName
                + ", itemPrice=" + itemPrice + ", description="
                + description + ", quantity="
                + itemQuantity + '}';
    }
}
