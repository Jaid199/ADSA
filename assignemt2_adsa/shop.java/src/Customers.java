import java.util.ArrayList;
import java.util.Random;

public class Customers {
    private int customer_id;
    private static ArrayList<Item> items_selected;
    private long arrival_time;
    private long checkout_time;
        
    
    public Customers(int customer_id, long arrival_time) {
        this.customer_id = customer_id;
        this.items_selected = new ArrayList<>();
        this.arrival_time = arrival_time;
        this.checkout_time = 0;
    }

    public void selectItems(ArrayList<Item> inventory) {
        Random random = new Random();
        int numberOfItems = random.nextInt(5) + 1; // Number of items the customer will select (1-5)
    
        for (int i = 0; i < numberOfItems; i++) {
            if (inventory.isEmpty()) {
                System.out.println("Inventory is empty. No items to select.");
                break;
            }
    
            // Pick a random item from the inventory
            Item item = inventory.get(random.nextInt(inventory.size()));
    
            if (item.getStock_quantity() > 0) {
                int maxQuantity = (int) Math.min(3, item.getStock_quantity());
                int quantity = random.nextInt(maxQuantity) + 1;
                item.reduceQty(quantity); // Reduce stock in inventory
    
                // Add to customer's selected items
                items_selected.add(new Item(item.getItem_id(), item.getItem_name(), item.getPrice(), quantity));
            }
        }
    }

     // helper fungtion to generate random numbers for number of items
     public int itemsRand() {
        int randomNum = (int)(Math.random() * 100);
        return randomNum;
    }

    // helper fungtion
    public int getTotalItemsSelected() {
        int total = 0;
        for (Item item : items_selected) {
            total += item.getStock_quantity();
        }
        return total;
    }

    // getters and setters for privates
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public ArrayList<Item> getItems_selected() {
        return items_selected;
    }

    public void setArrival_time(long arrival_time) {
        this.arrival_time = arrival_time;
    }

    public long getArrival_time() {
        return arrival_time;
    }

    public void setCheckout_time(long checkout_time) {
        this.checkout_time = checkout_time;
    }

    public long getCheckout_time() {
        return checkout_time;
    }
}
