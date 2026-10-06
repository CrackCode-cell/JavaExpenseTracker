/**
 * Represents one source of income.
 *
 * Each Income stores an amount, source, and description.
 */
public class Income {

    private double amount;
    private String source;
    private String description;

    /**
     * Creates a new Income object.
     *
     * @param amount the amount of money received
     * @param source where the income came from
     * @param description additional information about the income
     */
    public Income(double amount, String source, String description) {
        this.amount = amount;
        this.source = source;
        this.description = description;
    }

    /**
     * Returns the income amount.
     *
     * @return the amount received
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Returns the income source.
     *
     * @return the income source
     */
    public String getSource() {
        return source;
    }

    /**
     * Returns the income description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns a readable representation of the income.
     *
     * @return formatted income information
     */
    @Override
    public String toString() {
        return String.format(
                "$%.2f | %s | %s",
                amount,
                source,
                description
        );
    }
}
