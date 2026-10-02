import java.util.ArrayList;

/**
 * Manages a collection of expenses.
 *
 * Uses an ArrayList to store multiple Expense objects.
 */
public class ExpenseTracker {

    private ArrayList<Expense> expenses;

    /**
     * Creates an empty expense tracker.
     */
    public ExpenseTracker() {
        expenses = new ArrayList<>();
    }

    /**
     * Adds an expense to the ArrayList.
     */
    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    /**
     * Displays every expense currently stored.
     */
    public void viewExpenses() {

        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }

    /**
     * Calculates the total amount spent.
     *
     * Time complexity: O(n)
     * because every expense must be visited.
     */
    public double calculateTotal() {

        double total = 0;

        for (Expense expense : expenses) {
            total += expense.getAmount();
        }

        return total;
    }

    /**
     * Finds the expense with the largest amount.
     *
     * Returns null if there are no expenses.
     *
     * Time complexity: O(n)
     */
    public Expense findLargestExpense() {

        if (expenses.isEmpty()) {
            return null;
        }

        // Start by assuming the first expense is the largest.
        Expense largest = expenses.get(0);

        // Compare every expense against the current largest.
        for (Expense expense : expenses) {

            if (expense.getAmount() > largest.getAmount()) {
                largest = expense;
            }
        }

        return largest;
    }
}
