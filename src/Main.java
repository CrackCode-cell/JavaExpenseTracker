/**
 * Entry point for the Expense Tracker application.
 *
 * Demonstrates creating expenses, storing them,
 * displaying them, calculating a total, and
 * finding the largest expense.
 */
public class Main {

    public static void main(String[] args) {

        // Create the ExpenseTracker.
        ExpenseTracker tracker = new ExpenseTracker();

        // Create several Expense objects.
        Expense food = new Expense(
                12.50,
                "Food",
                "Lunch"
        );

        Expense transportation = new Expense(
                25.00,
                "Transportation",
                "Bus"
        );

        Expense entertainment = new Expense(
                40.00,
                "Entertainment",
                "Movie"
        );

        // Add the expenses to the ArrayList.
        tracker.addExpense(food);
        tracker.addExpense(transportation);
        tracker.addExpense(entertainment);

        System.out.println("My Expenses");
        System.out.println("----------------");

        // Display all expenses.
        tracker.viewExpenses();

        // Calculate and display total spending.
        System.out.println();
        System.out.println("Total: $" + tracker.calculateTotal());

        // Find and display the largest expense.
        Expense largest = tracker.findLargestExpense();

        if (largest != null) {
            System.out.println("Largest Expense: " + largest);
        }
    }
}
