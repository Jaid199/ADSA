// this class is for the customers who has items less thn 5 or maximum 5 items
public class minimalCheckOutQueue extends supermarket {

    private static final int max_minimal = 5;

    public minimalCheckOutQueue() {
        super();
    }

    @Override
    public void addCustomer(Customers customers) {
        if(customers.getItems_selected().size() <= max_minimal) {
            queue.add(customers);
        } else {
            System.out.println("Customer " + customers.getCustomer_id() + " has too many items for express checkout");
        }
    }

    @Override
    public Customers servCustomers() {
        if(!queue.isEmpty()) {
            Customers customers = queue.poll();
            long processingTime = calculateWaitTime(customers);
            customers.setCheckout_time(processingTime);
            return customers;
        }
        return null;
    }

    @Override
    public int getQueueSize() {
        return queue.size();
    }

    @Override
    public long calculateWaitTime(Customers customers) {
        return customers.getItems_selected().size() * randomNum();
    }

    public int randomNum() {
        int rand = (int) (Math.random() * 120); // random number between 0 to 120
        return rand;
    }
    
}
