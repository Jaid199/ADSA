import java.util.LinkedList;
import java.util.Queue;

abstract class supermarket {
    protected Queue<Customers> queue;

    public supermarket() {
        this.queue = new LinkedList<>();
    }

    public abstract void addCustomer(Customers customers);
    public abstract Customers servCustomers();
    public abstract int getQueueSize();
    public abstract long calculateWaitTime(Customers customers);
}
