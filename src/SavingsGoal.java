/**
 * Represents a personal savings goal.
 *
 * Each SavingsGoal stores a name, target amount,
 * and the amount currently saved.
 */
public class SavingsGoal {

    private String name;
    private double targetAmount;
    private double currentAmount;

    /**
     * Creates a new savings goal.
     *
     * @param name the name of the savings goal
     * @param targetAmount the amount needed to reach the goal
     * @param currentAmount the amount currently saved
     */
    public SavingsGoal(
            String name,
            double targetAmount,
            double currentAmount) {

        this.name = name;
        this.targetAmount = targetAmount;
        this.currentAmount = currentAmount;
    }

    /**
     * Returns the goal name.
     *
     * @return the goal name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the target amount.
     *
     * @return the target amount
     */
    public double getTargetAmount() {
        return targetAmount;
    }

    /**
     * Returns the current saved amount.
     *
     * @return the current amount
     */
    public double getCurrentAmount() {
        return currentAmount;
    }

    /**
     * Adds money toward the savings goal.
     *
     * @param amount the amount to add
     */
    public void addSavings(double amount) {
        currentAmount += amount;
    }

    /**
     * Calculates how much remains to reach the goal.
     *
     * @return the remaining amount
     */
    public double getRemainingAmount() {
        return targetAmount - currentAmount;
    }

    /**
     * Determines whether the savings goal has been reached.
     *
     * @return true if the goal has been reached
     */
    public boolean isComplete() {
        return currentAmount >= targetAmount;
    }

    /**
     * Returns a readable representation of the savings goal.
     *
     * @return formatted savings goal information
     */
    @Override
    public String toString() {

        return String.format(
                "%s | Saved: $%.2f / $%.2f | Remaining: $%.2f",
                name,
                currentAmount,
                targetAmount,
                getRemainingAmount()
        );
    }
}
