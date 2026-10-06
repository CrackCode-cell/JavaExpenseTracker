import java.util.Scanner;

/**
 * Entry point for the Expense Tracker application.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        ExpenseTracker tracker = new ExpenseTracker();

        boolean running = true;

        // Continue displaying the menu until the user chooses Exit.
        while (running) {

            System.out.println();
            System.out.println("=== Expense Tracker ===");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. View Total");
            System.out.println("4. Find Largest Expense");
            System.out.println("5. View Category Total");
            System.out.println("6. Delete Expense");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scnr.nextInt();
            scnr.nextLine();

            switch (choice) {

                case 1:
                    // Ask the user for information about the new expense.
                    System.out.print("Enter expense amount: ");
                    double amount = scnr.nextDouble();
                    scnr.nextLine();

                    System.out.print("Enter category: ");
                    String category = scnr.nextLine();

                    System.out.print("Enter description: ");
                    String description = scnr.nextLine();

                    // Create an Expense object using the user's information.
                    Expense expense = new Expense(
                            amount,
                            category,
                            description
                    );

                    // Add the new Expense object to the tracker.
                    tracker.addExpense(expense);

                    System.out.println("Expense added!");
                    break;

                case 2:
                    // Display all currently stored expenses.
                    System.out.println();
                    System.out.println("Your Expenses:");
                    tracker.viewExpenses();
                    break;

                case 3:
                    // Calculate and display total spending.
                    double total = tracker.calculateTotal();

                    System.out.println();
                    System.out.printf(
                            "Total Spending: $%.2f%n",
                            total
                    );
                    break;

                case 4:
                    // Find the largest expense.
                    Expense largest = tracker.findLargestExpense();

                    if (largest == null) {
                        System.out.println(
                                "No expenses have been added yet."
                        );
                    } else {
                        System.out.println();
                        System.out.println("Largest Expense:");
                        System.out.println(largest);
                    }
                    break;

                case 5:
                    // Ask which category the user wants to analyze.
                    System.out.print("Enter category: ");
                    String searchCategory = scnr.nextLine();

                    double categoryTotal =
                            tracker.calculateCategoryTotal(searchCategory);

                    System.out.printf(
                            "%s Total: $%.2f%n",
                            searchCategory,
                            categoryTotal
                    );
                    break;

                case 6:
                    // Display expenses first so the user knows which
                    // expense number they want to delete.
                    System.out.println();
                    System.out.println("Your Expenses:");
                    tracker.viewExpenses();

                    System.out.print(
                            "Enter expense number to delete: "
                    );

                    int expenseNumber = scnr.nextInt();
                    scnr.nextLine();

                    // Users count from 1, but ArrayList indexes start at 0.
                    int index = expenseNumber - 1;

                    // Attempt to delete the selected expense.
                    boolean deleted = tracker.deleteExpense(index);

                    if (deleted) {
                        System.out.println("Expense deleted!");
                    } else {
                        System.out.println(
                                "Invalid expense number."
                        );
                    }
                    break;

                case 7:
                    // Stop the menu loop and end the program.
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    // Handle menu choices that do not exist.
                    System.out.println(
                            "Invalid option. Please try again."
                    );
            }
        }

        // Close the Scanner when the program finishes.
        scnr.close();
    }
}
