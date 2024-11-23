// this class is for normal chekout queue
class CheckoutQueue extends supermarket{

    public CheckoutQueue() {
        super();
    }

    @Override
    public void addCustomer(Customers customers) {
        queue.add(customers);
    }

    @Override
    public Customers servCustomers() {
       if(!queue.isEmpty()) {
            //long processingTime = calculateWaitTime(customers);
            Customers customers = queue.poll();
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
        return customers.getItems_selected().size() * randomNum(); // any secound between 0 to 2 min
    }

    // helper fungtion for random numbers
    public int randomNum() {
        int rand = (int) (Math.random() * 120); // random number between 0 to 120
        return rand;
    }

}
