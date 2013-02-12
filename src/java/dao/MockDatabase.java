package dao;

import java.util.*;
import service.ItemStrategy;
import service.MenuItem;

/**
 *
 * @author Drew
 */
public class MockDatabase implements IOrderDAO {

    private Map<Integer, List<ItemStrategy>> transactions;
    private int currentId;
    private final int BEGINNING_ID;

    public MockDatabase() {
        transactions = new TreeMap<Integer, List<ItemStrategy>>();
        BEGINNING_ID = 10000;
        currentId = BEGINNING_ID;
    }

    @Override
    public List<ItemStrategy> getCurrentMenuChoices() throws RuntimeException {
        List menuItemList = new ArrayList<ItemStrategy>();

        menuItemList.add(new MenuItem("00001", "Steak", 19.95,
                "Juicy Tender Steak", 0));
        menuItemList.add(new MenuItem("00002", "Lobster", 23.95,
                "Juicy Tender Lobster", 0));
        menuItemList.add(new MenuItem("00003", "Salad", 3.95,
                "Crisp Cool Salad", 0));
        menuItemList.add(new MenuItem("00004", "Beer", 5.95,
                "Crisp Cool Beer", 0));
        menuItemList.add(new MenuItem("00005", "Lasagna", 13.95,
                "Cheesy delicious goodness", 0));
        menuItemList.add(new MenuItem("00006", "Pasta Primavera",
                12.95, "Vegetables over pasta with a white sauce", 0));
        menuItemList.add(new MenuItem("00007", "Dessert", 5.95,
                "Brownie Sundae with Ice Cream and Chocolate Sauce and Walnuts"
                + " and whipped cream", 0));

        return menuItemList;
    }

    @Override
    public void saveOrder(List<ItemStrategy> orderList) throws RuntimeException {

        currentId++;

        transactions.put(currentId, orderList);
    }

    @Override
    public final List<ItemStrategy> getCurrentTransaction() {
        return transactions.get(currentId);
    }

    @Override
    public final List<ItemStrategy> getTransactionById(int id) {
        return transactions.get(id);
    }

    @Override
    public final int getCurrentId() {
        return currentId;
    }

    public static void main(String[] args) {


        MockDatabase mockDB = new MockDatabase();

        List<ItemStrategy> menuList = mockDB.getCurrentMenuChoices();

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

        MenuItem item = (MenuItem) menuList.get(1);

        System.out.println(item.getItemName());

        //print out list
        System.out.println("Transaction List:");
        int currentId = mockDB.getCurrentId();
        System.out.println(currentId);

        List<ItemStrategy> transaction1 = mockDB.getTransactionById(currentId - 1);
        List<ItemStrategy> transaction2 = mockDB.getTransactionById(currentId);

        System.out.println(transaction1);
        System.out.println(transaction2);
    }
}
