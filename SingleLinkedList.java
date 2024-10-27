import java.util.Scanner;

class Node {
    int n;
    Node next;

    Node(int value) {
        this.n = value;
        this.next = null;
    }
}

public class SingleLinkedList {
    private Node head = null;
    private final Scanner scanner = new Scanner(System.in);

    // Create Function
    public void create() {
        char ch;
        do {
            System.out.print("Enter the Value: ");
            int x = scanner.nextInt();
            Node t = new Node(x);

            if (head == null) {
                head = t;
            } else {
                Node h = head;
                while (h.next != null) {
                    h = h.next;
                }
                h.next = t;
            }

            System.out.print("Do You Want to Continue? (Y/N): ");
            ch = scanner.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');
    }

    // Display Function
    public void display() {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }
        Node h = head;
        while (h != null) {
            System.out.print(h.n + " ");
            h = h.next;
        }
        System.out.println();
    }

    // Search Function
    public Node search(int x) {
        Node h = head;
        while (h != null) {
            if (h.n == x) {
                return h;
            }
            h = h.next;
        }
        return null;
    }

    // Count Function
    public int count() {
        int n = 0;
        Node h = head;
        while (h != null) {
            n++;
            h = h.next;
        }
        return n;
    }

    // Delete by Value
    public void deleteByValue(int x) {
        Node current = head, prev = null;
        while (current != null && current.n != x) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Value not found.");
            return;
        }

        if (prev == null) {
            head = current.next;
        } else {
            prev.next = current.next;
        }
        System.out.println("Deleted " + x);
    }

    // Delete by Position
    public void deleteByPosition(int pos) {
        if (pos < 1 || pos > count()) {
            System.out.println("Position out of range.");
            return;
        }
        if (pos == 1) {
            head = head.next;
            return;
        }

        Node prev = head;
        for (int i = 1; i < pos - 1; i++) {
            prev = prev.next;
        }
        prev.next = prev.next.next;
    }

    // Insert by Position
    public void insertByPosition(int value, int pos) {
        if (pos < 1 || pos > count() + 1) {
            System.out.println("Position out of range.");
            return;
        }

        Node newNode = new Node(value);
        if (pos == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node prev = head;
        for (int i = 1; i < pos - 1; i++) {
            prev = prev.next;
        }
        newNode.next = prev.next;
        prev.next = newNode;
    }

    // Add Before a Value
    public void addBefore(int target, int value) {
        Node newNode = new Node(value);
        if (head == null || head.n == target) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node prev = null, current = head;
        while (current != null && current.n != target) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Target value not found.");
            return;
        }
        prev.next = newNode;
        newNode.next = current;
    }

    // Add After a Value
    public void addAfter(int target, int value) {
        Node current = search(target);
        if (current == null) {
            System.out.println("Target value not found.");
            return;
        }

        Node newNode = new Node(value);
        newNode.next = current.next;
        current.next = newNode;
    }

    // Reverse the List
    public void reverse() {
        if (head == null || head.next == null) {
            System.out.println("No node or only one node.");
            return;
        }

        Node prev = null, current = head, next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    // Menu
    public void menu() {
        System.out.println("\n\t\t\t PROGRAM ON LINKED LIST:");
        System.out.println("\t\t\t   1. Create.");
        System.out.println("\t\t\t   2. Display.");
        System.out.println("\t\t\t   3. Search.");
        System.out.println("\t\t\t   4. Count.");
        System.out.println("\t\t\t   5. Delete by Value.");
        System.out.println("\t\t\t   6. Delete by Position.");
        System.out.println("\t\t\t   7. Insert by Position.");
        System.out.println("\t\t\t   8. Add Before.");
        System.out.println("\t\t\t   9. Add After.");
        System.out.println("\t\t\t   10. Reverse.");
        System.out.println("\t\t\t   11. Exit.");
        System.out.print("\t\t\t   Enter your Choice Please: ");
    }

    // Main Method
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        int choice, x, y;

        while (true) {
            list.menu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    list.create();
                    break;
                case 2:
                    list.display();
                    break;
                case 3:
                    System.out.print("Enter the Element to be Searched: ");
                    x = scanner.nextInt();
                    Node result = list.search(x);
                    if (result == null) {
                        System.out.println("NOT found");
                    } else {
                        System.out.println("FOUND at Node with value: " + result.n);
                    }
                    break;
                case 4:
                    System.out.println("The Node count is: " + list.count());
                    break;
                case 5:
                    System.out.print("Enter the value to be DELETED: ");
                    x = scanner.nextInt();
                    list.deleteByValue(x);
                    break;
                case 6:
                    System.out.print("Enter the position to be DELETED: ");
                    y = scanner.nextInt();
                    list.deleteByPosition(y);
                    break;
                case 7:
                    System.out.print("Enter the value to be INSERTED and POSITION: ");
                    x = scanner.nextInt();
                    y = scanner.nextInt();
                    list.insertByPosition(x, y);
                    break;
                case 8:
                    System.out.print("Enter the target value and new value to ADD BEFORE: ");
                    x = scanner.nextInt();
                    y = scanner.nextInt();
                    list.addBefore(x, y);
                    break;
                case 9:
                    System.out.print("Enter the target value and new value to ADD AFTER: ");
                    x = scanner.nextInt();
                    y = scanner.nextInt();
                    list.addAfter(x, y);
                    break;
                case 10:
                    list.reverse();
                    break;
                case 11:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
