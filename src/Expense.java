/**
 * Represents one expense made by the user.
 *
 * Each Expense stores an amount, category, and description.
 */
public class Expense {

    private double amount;
    private String category;
    private String description;

    public Expense(double amount, String category, String description) {
        this.amount = amount;
        this.category = category;
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return String.format(
                "$%.2f | %s | %s",
                amount,
                category,
                description
        );
    }
}
