import java.util.ArrayList;

/**
 * Manages a collection of expenses.
 *
 * Uses an ArrayList to store multiple Expense objects.
 */
public class ExpenseTracker {

    private ArrayList<Expense> expenses;

    public ExpenseTracker() {
        expenses = new ArrayList<>();
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public void viewExpenses() {

        if (expenses.isEmpty()) {
            System.out.println("No expenses have been added yet.");
            return;
        }

        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }

    public double calculateTotal() {

        double total = 0;

        for (Expense expense : expenses) {
            total += expense.getAmount();
        }

        return total;
    }

    public Expense findLargestExpense() {

        if (expenses.isEmpty()) {
            return null;
        }

        Expense largest = expenses.get(0);

        for (Expense expense : expenses) {

            if (expense.getAmount() > largest.getAmount()) {
                largest = expense;
            }
        }

        return largest;
    }

    public double calculateCategoryTotal(String category) {

        double total = 0;

        for (Expense expense : expenses) {

            if (expense.getCategory().equalsIgnoreCase(category)) {
                total += expense.getAmount();
            }
        }

        return total;
    }
}
