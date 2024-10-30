import java.util.Scanner;

public class Stack {
    private static final int MAX = 5;
    private int[] stack;
    private int top;

    // Constructor to initialize the stack
    public Stack() {
        stack = new int[MAX];
        top = -1; // Initialize top of the stack
    }

    // Method to push an element onto the stack
    public void push(int x) {
        if (top == MAX - 1) {
            System.out.println("Stack is Full. Can't Push.");
        } else {
            top++;
            stack[top] = x;
            System.out.println(x + " pushed to stack.");
        }
    }

    // Method to pop an element from the stack
    public void pop() {
        if (top == -1) {
            System.out.println("The Stack is Empty. Can't pop.");
        } else {
            System.out.println("The popped element is " + stack[top]);
            top--;
        }
    }

    // Method to display the elements in the stack
    public void show() {
        if (top == -1) {
            System.out.println("Empty Stack. Nothing to display.");
        } else {
            System.out.print("The elements of the Stack are: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }

    // Method to display the menu
    public void menu() {
        System.out.println("\n\t\t\t PROGRAM ON Stack");
        System.out.println("\t\t\t   1. PUSH");
        System.out.println("\t\t\t   2. POP");
        System.out.println("\t\t\t   3. DISPLAY");
        System.out.println("\t\t\t   4. EXIT");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        Scanner scanner = new Scanner(System.in);
        int choice, value;

        while (true) {
            s.menu();
            choice = scanner.nextInt(); // Accept choice

            switch (choice) {
                case 1:
                    System.out.print("Enter the number to push: ");
                    value = scanner.nextInt(); // Read the value to push
                    s.push(value);
                    break;

                case 2:
                    s.pop();
                    break;

                case 3:
                    s.show();
                    break;

                case 4:
                    System.exit(0); // Exit from the program

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}