/**
 * Represents one expense made by the user.
 *
 * Each Expense stores an amount, category, and description.
 */
public class Expense {

    private double amount;
    private String category;
    private String description;

    /**
     * Creates a new Expense object.
     */
    public Expense(double amount, String category, String description) {
        this.amount = amount;
        this.category = category;
        this.description = description;
    }

    // Getter methods allow other classes to access the private fields.
    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Provides a readable representation of an expense.
     */
    @Override
    public String toString() {
        return "$" + amount + " | " + category + " | " + description;
    }
}
