
package service;

import java.util.*;

/**
 *
 * @author Drew
 */
public class Transaction {
    private String id;
    private List<ItemStrategy> itemsInTransaction;

    public Transaction(String id, List<ItemStrategy> itemsInTransaction) {
        this.id = id;
        this.itemsInTransaction = itemsInTransaction;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ItemStrategy> getItemsInTransaction() {
        return itemsInTransaction;
    }

    public void setItemsInTransaction(List<ItemStrategy> itemsInTransaction) {
        this.itemsInTransaction = itemsInTransaction;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Transaction other = (Transaction) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Transaction{" + "id=" + id + ", itemsInTransaction=" + itemsInTransaction + '}';
    }
    
    
    
    
}
