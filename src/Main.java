import java.util.Scanner;

/**
 * Entry point for the Expense Tracker application.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        ExpenseTracker tracker = new ExpenseTracker();

        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println("=== Expense Tracker ===");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. View Total");
            System.out.println("4. Find Largest Expense");
            System.out.println("5. View Category Total");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scnr.nextInt();
            scnr.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter expense amount: ");
                    double amount = scnr.nextDouble();
                    scnr.nextLine();

                    System.out.print("Enter category: ");
                    String category = scnr.nextLine();

                    System.out.print("Enter description: ");
                    String description = scnr.nextLine();

                    Expense expense = new Expense(
                            amount,
                            category,
                            description
                    );

                    tracker.addExpense(expense);

                    System.out.println("Expense added!");
                    break;

                case 2:
                    System.out.println();
                    System.out.println("Your Expenses:");
                    tracker.viewExpenses();
                    break;

                case 3:
                    double total = tracker.calculateTotal();

                    System.out.println();
                    System.out.printf("Total Spending: $%.2f%n", total);
                    break;

                case 4:
                    Expense largest = tracker.findLargestExpense();

                    if (largest == null) {
                        System.out.println("No expenses have been added yet.");
                    } else {
                        System.out.println();
                        System.out.println("Largest Expense:");
                        System.out.println(largest);
                    }
                    break;

                case 5:
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
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scnr.close();
    }
}
