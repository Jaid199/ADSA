import java.util.*;

class FriendNode {
    String name;
    FriendNode next;

    public FriendNode(String name) {
        this.name = name;
        this.next = null;
    }
}

class PersonNode {
    String name;
    FriendNode friends;
    List<String> hobbies;
    PersonNode next;

    public PersonNode(String name, List<String> hobbies) {
        this.name = name;
        this.hobbies = hobbies;
        this.friends = null;
        this.next = null;
    }
}

class SocialNetwork {
    PersonNode head;
    // Add a person to the linked list
    public void addPerson(String name, List<String> hobbies) {
        PersonNode newPerson = new PersonNode(name, hobbies);
        if (head == null) {
            head = newPerson;
        } else {
            PersonNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newPerson;
        }
    }

    // Add friends to a person
    public void addFriend(String personName, String friendName) {
        PersonNode person = findPerson(personName);
        if (person != null) {
            FriendNode newFriend = new FriendNode(friendName);
            if (person.friends == null) {
                person.friends = newFriend;
            } else {
                FriendNode temp = person.friends;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newFriend;
            }
        }
    }

    // Find a person in the linked list
    public PersonNode findPerson(String name) {
        PersonNode temp = head;
        while (temp != null) {
            if (temp.name.equals(name)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // 1. Print all people and their friends
    public void printAllPeopleAndFriends() {
        PersonNode temp = head;
        while (temp != null) {
            System.out.print(temp.name + " has friends: ");
            printFriends(temp.friends);
            temp = temp.next;
            System.out.println();
        }
    }

    // Helper function to print friends
    private void printFriends(FriendNode friend) {
        if (friend == null) {
            System.out.print("No friends");
        } else {
            while (friend != null) {
                System.out.print(friend.name + " ");
                friend = friend.next;
            }
        }
    }

    // 2. Print people who have a specific hobby
    public void printPeopleByHobby(String hobby) {
        PersonNode temp = head;
        System.out.println("People with hobby '" + hobby + "':");
        while (temp != null) {
            if (temp.hobbies.contains(hobby)) {
                System.out.println(temp.name);
            }
            temp = temp.next;
        }
    }

    // 3. Print people who are not friends
    public void printNonFriends() {
        PersonNode outer = head;
        while (outer != null) {
            PersonNode inner = head;
            while (inner != null) {
                if (!outer.name.equals(inner.name) && !areFriends(outer, inner)) {
                    System.out.println(outer.name + " and " + inner.name + " are not friends.");
                }
                inner = inner.next;
            }
            outer = outer.next;
        }
    }

    // Check if two people are friends
    private boolean areFriends(PersonNode person1, PersonNode person2) {
        FriendNode friend = person1.friends;
        while (friend != null) {
            if (friend.name.equals(person2.name)) {
                return true;
            }
            friend = friend.next;
        }
        return false;
    }

    // 4. Print the total number of friends for each person
    public void printNumberOfFriends() {
        PersonNode temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + countFriends(temp.friends) + " friends.");
            temp = temp.next;
        }
    }

    // Helper function to count friends
    private int countFriends(FriendNode friend) {
        int count = 0;
        while (friend != null) {
            count++;
            friend = friend.next;
        }
        return count;
    }

    // 5. Print the whole list including friends in alphabetical order
    public void printAllWithFriendsSorted() {
        PersonNode temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has friends (alphabetically): ");
            List<String> sortedFriends = getSortedFriends(temp.friends);
            for (String friend : sortedFriends) {
                System.out.print(friend + " ");
            }
            System.out.println();
            temp = temp.next;
        }
    }

    // Helper function to get sorted friends list
    private List<String> getSortedFriends(FriendNode friend) {
        List<String> friendsList = new ArrayList<>();
        while (friend != null) {
            friendsList.add(friend.name);
            friend = friend.next;
        }
        Collections.sort(friendsList);
        return friendsList;
    }
}

public class SocialNetworkApp {
    public static void main(String[] args) {
        SocialNetwork network = new SocialNetwork();
        Scanner sc = new Scanner(System.in);

        // Input for 10 people and their hobbies and friends
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter name of person " + (i + 1) + ": ");
            String name = sc.nextLine();
            System.out.println("Enter 3 hobbies for " + name + ": ");
            List<String> hobbies = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                hobbies.add(sc.nextLine());
            }
            network.addPerson(name, hobbies);

            System.out.println("Enter 10 friends for " + name + ": ");
            for (int j = 0; j < 10; j++) {
                String friendName = sc.nextLine();
                network.addFriend(name, friendName);
            }
        }

        // Output based on the requirements
        network.printAllPeopleAndFriends();
        System.out.println("\nSearch by hobby:");
        System.out.print("Enter hobby: ");
        String hobby = sc.nextLine();
        network.printPeopleByHobby(hobby);

        System.out.println("\nPeople who are not friends:");
        network.printNonFriends();

        System.out.println("\nNumber of friends for each person:");
        network.printNumberOfFriends();

        System.out.println("\nPeople with friends in alphabetical order:");
        network.printAllWithFriendsSorted();
    }
}


// Person and Friend Nodes: The PersonNode holds the person's name, hobbies, and a linked list of friends (through FriendNode).
// addPerson(): Adds a person to the linked list of persons.
// addFriend(): Adds a friend to a person's linked list of friends.
// printAllPeopleAndFriends(): Displays each person and their friends.
// printPeopleByHobby(): Searches people by hobbies.
// printNonFriends(): Displays people who aren't friends.
// printNumberOfFriends(): Prints the number of friends for each person.
// printAllWithFriendsSorted(): Displays people and their friends in alphabetical order.


// Ross p4
// Barnes p2
// Macias p3
// Moshe p1
// Marlowe p5
// Connor
// Jayleen
// Emerson
// April 
// Conway
// Briella