package dao;

import java.util.*;
import service.*;

/**
 * this is the mock DB for the restaurant ordering system.
 * This is based on (and adapted from) the mock DB which I used initially
 * for my parking garage last semester.
 * 
 * Unfortunately it only persists the information as long as the items 
 * exist in memory.
 * 
 *
 * @Drew Holloway
 */
public class MockDatabase {
    
    private final List<MenuItem> menuItems;

    private Map<String,List<ItemStrategy>> transactions;
    
    private String currentId;

    public MockDatabase() {
        
        //create the list of menuItems
        menuItems = getMenuItems();
        
        
        transactions=new TreeMap<String,List<ItemStrategy>>();
        currentId = "10000";
    }

    public final List<MenuItem> getMenuItems(){
        
        List menuItemList = new ArrayList<ItemStrategy>();
        
        menuItemList.add(new MenuItem("00001","Steak",19.95,"Juicy Tender Steak",0));
        menuItemList.add(new MenuItem("00002","Lobster",23.95,"Juicy Tender Lobster",0));
        menuItemList.add(new MenuItem("00003","Salad",3.95,"Juicy Tender Salad",0));
        menuItemList.add(new MenuItem("00004","Beer",5.95,"Juicy Tender Beer",0));
        
        return menuItemList;
    }
    
    
    public final List<ItemStrategy> getTransactionById(String id) {
        return transactions.get(id);
    }

    
    public final void addTransaction(List<ItemStrategy> newMenuItems) {

        int intCurrentId=Integer.parseInt(currentId);
        
        intCurrentId++;
        currentId=String.valueOf(intCurrentId);

        transactions.put(currentId, newMenuItems);
    }

    
    public final String getCurrentId() {
        return currentId;
    }
    
    public final double getSubtotal() {
        double subtotal=0;
        ArrayList<ItemStrategy> itemList = getTransactionList();
        //loop over List
        for (ItemStrategy i : itemList) {
            subtotal+=i.getItemPrice()*i.getItemQuantity();
        }
        return subtotal;
    }
    
    public final void removeTransaction(String id){
        transactions.remove(id);
    }
    
    
    private ArrayList<ItemStrategy> getTransactionList(){
        
        //it wouldn't let me add the <ItemStrategy> tag
        return new ArrayList(transactions.values());
    }
    
    
    public static void main(String[] args) {
        //test it
        
        //get list of menu items
        List<MenuItem> menuList = new ArrayList<MenuItem>();
        
        MockDatabase mockDB = new MockDatabase();
        
        menuList=mockDB.getMenuItems();
        
        for (MenuItem menuItem:menuList){
            System.out.println(menuItem);
        }
        
        //add a transaction
        MenuItem steak = menuList.get(0);
        steak.setItemQuantity(3);
        menuList.get(0).setItemQuantity(2);
        
        
        
        //print out list
        
        // get itemList
        
        
        
        
        
    }
    
    
}
