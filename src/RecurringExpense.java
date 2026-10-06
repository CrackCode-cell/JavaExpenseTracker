/**
 * Represents an expense that occurs repeatedly.
 *
 * Examples include subscriptions, phone bills,
 * transportation passes, and other recurring costs.
 */
public class RecurringExpense {

    private String name;
    private String category;
    private double amount;
    private String frequency;

    /**
     * Creates a new recurring expense.
     *
     * @param name the name of the recurring expense
     * @param category the expense category
     * @param amount the amount charged each period
     * @param frequency how often the expense occurs
     */
    public RecurringExpense(
            String name,
            String category,
            double amount,
            String frequency) {

        this.name = name;
        this.category = category;
        this.amount = amount;
        this.frequency = frequency;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public String getFrequency() {
        return frequency;
    }

    /**
     * Returns a readable representation of the recurring expense.
     *
     * @return formatted recurring expense information
     */
    @Override
    public String toString() {

        return String.format(
                "%s | $%.2f | %s | %s",
                name,
                amount,
                category,
                frequency
        );
    }
}
