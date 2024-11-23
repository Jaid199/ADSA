class Node {
    String data;
    Node next;
    int access_count;

    public Node(String data) {
        this.data = data;
        this.next = null;
        this.access_count = 0;
    }
}

class SelfOrganizingLinkedList {
    private Node head;

    public SelfOrganizingLinkedList() {
        this.head = null;
    }

    // Method to search and move the node to the front
    public Node search(String data) {
        if (head == null) return null;
        if (head.data.equals(data)) {
            head.access_count++;
            return head;
        }

        Node prev = head;
        Node curr = head.next;

        while (curr != null) {
            if (curr.data.equals(data)) {
                prev.next = curr.next;
                curr.next = head;
                head = curr;
                curr.access_count++;
                return curr;
            }
            prev = curr;
            curr = curr.next;
        }
        return null;
    }

    // Method to transpose nodes after access
    public void transpose(String data) {
        if (head == null || head.next == null) return;

        if (head.data.equals(data)) {
            head.access_count++;
            return;
        }
        Node prev = head;
        Node curr = head.next;

        while (curr != null && !curr.data.equals(data)) {
            prev = curr;
            curr = curr.next;
        }
        if (curr != null && curr.next != null) {
            Node nextNode = curr.next;
            curr.next = nextNode.next;
            nextNode.next = curr;
            prev.next = nextNode;
            curr.access_count++;
        }
    }

    // Method to reorder the list based on frequency count
    public void frequencyCount(String data) {
        Node node = search(data);
        if (node == null) return;

        // Bubble sort to reorder based on access count
        Node curr = head;
        boolean swapped;
        do {
            swapped = false;
            while (curr.next != null) {
                if (curr.access_count < curr.next.access_count) {
                    // Swap nodes
                    String tempData = curr.data;
                    int tempCount = curr.access_count;
                    curr.data = curr.next.data;
                    curr.access_count = curr.next.access_count;
                    curr.next.data = tempData;
                    curr.next.access_count = tempCount;

                    swapped = true;
                }
                curr = curr.next;
            }
            curr = head;
        } while (swapped);
    }

    // Method to insert a new node
    public void insert(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    // Method to display the list
    public void display() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + "(" + curr.access_count + ") -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SelfOrganizingLinkedList sol = new SelfOrganizingLinkedList();
        sol.insert("A");
        sol.insert("B");
        sol.insert("C");
        sol.insert("D");

        sol.display();
        sol.search("C");
        sol.display();
        sol.transpose("B");
        sol.display();
        sol.frequencyCount("A");
        sol.display();

        
    }
}

 