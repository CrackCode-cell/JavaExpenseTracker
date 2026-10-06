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
     *
     * @param expense the expense to add
     */
    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    /**
     * Displays every expense currently stored.
     */
    public void viewExpenses() {

        if (expenses.isEmpty()) {
            System.out.println("No expenses have been added yet.");
            return;
        }

        // Display each expense in the ArrayList.
        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }

    /**
     * Calculates the total amount spent.
     *
     * @return the total amount of all expenses
     *
     * Time complexity: O(n)
     */
    public double calculateTotal() {

        double total = 0;

        // Visit every expense and add its amount.
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }

        return total;
    }

    /**
     * Finds the expense with the largest amount.
     *
     * @return the largest Expense, or null if the list is empty
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

    /**
     * Calculates the total amount spent in a specific category.
     *
     * Category comparison is case-insensitive.
     *
     * @param category the category to search for
     * @return the total amount spent in that category
     *
     * Time complexity: O(n)
     */
    public double calculateCategoryTotal(String category) {

        double total = 0;

        // Check every expense for a matching category.
        for (Expense expense : expenses) {

            if (expense.getCategory().equalsIgnoreCase(category)) {
                total += expense.getAmount();
            }
        }

        return total;
    }

    /**
     * Deletes an expense at a specific index.
     *
     * @param index the index of the expense to delete
     * @return true if the expense was deleted, false if the index was invalid
     *
     * Time complexity: O(n) in the worst case because ArrayList may
     * need to shift elements after the removed item.
     */
    public boolean deleteExpense(int index) {

        // Make sure the index exists before attempting to remove it.
        if (index < 0 || index >= expenses.size()) {
            return false;
        }

        // Remove the expense at the requested index.
        expenses.remove(index);

        return true;
    }
}
