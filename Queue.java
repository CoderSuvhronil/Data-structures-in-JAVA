import java.util.Scanner;

public class Queue {
    private static final int MAX_SIZE = 5;
    private int[] queue;
    private int front;
    private int rear;

    // Constructor to initialize the queue
    public Queue() {
        queue = new int[MAX_SIZE];
        front = -1;
        rear = -1;
    }

    // Method to add an element to the queue
    public void add(int x) {
        if (rear == MAX_SIZE - 1) {
            System.out.println("Queue is full. Cannot add " + x);
        } else {
            if (front == -1) {
                front = 0; // Set front to 0 if the queue was empty
            }
            rear++;
            queue[rear] = x;
            System.out.println("Added " + x + " to the queue.");
        }
    }

    // Method to delete an element from the queue
    public void del() {
        if (front == -1) {
            System.out.println("Queue is empty. Cannot delete.");
        } else {
            System.out.println("Deleted Element = " + queue[front]);
            if (front == rear) {
                front = -1; // Reset the queue
                rear = -1;
            } else {
                front++;
            }
        }
    }

    // Method to display the elements in the queue
    public void display() {
        if (front == -1) {
            System.out.println("Queue is empty.");
        } else {
            System.out.print("Queue elements: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }

    // Method to display the menu
    public void menu() {
        System.out.println("\t\t Program on Queue");
        System.out.println("\t\t  1. Addition");
        System.out.println("\t\t  2. Deletion");
        System.out.println("\t\t  3. Display");
        System.out.println("\t\t  4. Exit");
        System.out.print("Enter Your Choice: ");
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        Scanner scanner = new Scanner(System.in);
        int choice, value;

        while (true) {
            q.menu();
            choice = scanner.nextInt(); // Accept choice

            switch (choice) {
                case 1:
                    System.out.print("Enter Number to add: ");
                    value = scanner.nextInt();
                    q.add(value);
                    break;

                case 2:
                    q.del();
                    break;

                case 3:
                    q.display();
                    break;

                case 4:
                    System.exit(0); // Exit from the program

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}