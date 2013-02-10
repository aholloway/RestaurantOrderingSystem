package dao;

import java.util.*;
import service.ItemStrategy;
import service.MenuItem;

/**
 *
 * @author Drew
 */
public class MockDatabase implements IOrderDAO {

    private Map<Integer, List<MenuItem>> transactions;
    private int currentId;

    public MockDatabase() {
        transactions = new TreeMap<Integer, List<MenuItem>>();
        currentId = 10000;
    }

    @Override
    public List<MenuItem> getCurrentMenuChoices() throws RuntimeException {
        List menuItemList = new ArrayList<MenuItem>();

        menuItemList.add(new MenuItem("00001", "Steak", 19.95, "Juicy Tender Steak", 0));
        menuItemList.add(new MenuItem("00002", "Lobster", 23.95, "Juicy Tender Lobster", 0));
        menuItemList.add(new MenuItem("00003", "Salad", 3.95, "Juicy Tender Salad", 0));
        menuItemList.add(new MenuItem("00004", "Beer", 5.95, "Juicy Tender Beer", 0));

        return menuItemList;
    }

    @Override
    public void saveOrder(List<MenuItem> orderList) throws RuntimeException {
        
        currentId++;

        transactions.put(currentId, orderList);
    }

    public final List<MenuItem> getTransactionById(int id) {
        return transactions.get(id);
    }
    
    public final int getCurrentId() {
        return currentId;
    }
    
    public static void main(String[] args) {
        
        
         MockDatabase mockDB = new MockDatabase();

        List<MenuItem> menuList = mockDB.getCurrentMenuChoices();

        for (ItemStrategy menuItem : menuList) {
            System.out.println(menuItem);
        }

        //add a transaction
        ItemStrategy steak = menuList.get(0);
        steak.setItemQuantity(3);

        mockDB.saveOrder(menuList);
        
        menuList = mockDB.getCurrentMenuChoices();
        menuList.get(0).setItemQuantity(2);

        mockDB.saveOrder(menuList);

        //print out list
        System.out.println("Transaction List:");
        int currentId= mockDB.getCurrentId();
        System.out.println(currentId);

        List<MenuItem> transaction1 = mockDB.getTransactionById(currentId-1);
        List<MenuItem> transaction2 = mockDB.getTransactionById(currentId);

        System.out.println(transaction1);
        System.out.println(transaction2);
    }
}
