import java.util.ArrayList;

public class counter {
    public static void main(String[] args) {
        // Initialize inventory for the supermarket
        ArrayList<Item> inventory = new ArrayList<>();
        for (int i = 1; i <= 10; i++) { // Create 10 items for simplicity
            inventory.add(new Item(i, "Item " + i, 10.0f, 100)); // ID, name, price, stock | Item 1, Item 2, ...
        }
    
        // Initialize queues for normal queue and minimal queue
        // normal queue for qty more thn 5
        // minimal queue is for qty less thn 5
        CheckoutQueue normalQueue = new CheckoutQueue();
        minimalCheckOutQueue expressQueue = new minimalCheckOutQueue();
    
        // Create and simulate customers
        ArrayList<Customers> customersList = new ArrayList<>();
        for (int i = 1; i <= 20; i++) { // 20 customers for simulation
            Customers customer = new Customers(i, System.currentTimeMillis()); // Customer ID and arrival time
            customer.selectItems(inventory); // Customer selects items
            customersList.add(customer);
    
            // Assign customer to appropriate queue 
            // set which customer need to be in which queue acccording to the qty
            if (customer.getTotalItemsSelected() <= 5) {
                expressQueue.addCustomer(customer);
            } else {
                normalQueue.addCustomer(customer);
            }
        }
    
        // Process customers in queues
        long totalWaitTime = 0;
        for (Customers customer : customersList) {
            Customers servedCustomer;
    
            // Serve customers from appropriate queue
            if (customer.getTotalItemsSelected() <= 5) {
                servedCustomer = expressQueue.servCustomers();
            } else {
                servedCustomer = normalQueue.servCustomers();
            }
    
            // Calculate and display checkout time
            if (servedCustomer != null) {
                long waitTime = servedCustomer.getTotalItemsSelected() * 2; // Example: 2 seconds per item
                totalWaitTime += waitTime;
                servedCustomer.setCheckout_time(waitTime);
                System.out.println("Customer " + servedCustomer.getCustomer_id() +
                                   " spent " + waitTime + " seconds in the supermarket.");
            }
        }
    
        // Calculation of average wait time
        int totalCustomers = customersList.size();
        double averageWaitTime = totalCustomers > 0 ? (double) totalWaitTime / totalCustomers : 0;
        System.out.println("\nAverage wait time per customer: " + averageWaitTime + " seconds");
    
        // Display remaining inventory 
        System.out.println("\nRemaining Inventory:");
        for (Item item : inventory) {
            System.out.println("Item: " + item.getItem_name() + ", Remaining Stock: " + item.getStock_quantity());
        }
    }
    
}
