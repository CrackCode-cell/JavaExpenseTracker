/**
 * Represents a summary of the user's financial information.
 *
 * This class stores calculated financial values so they can
 * be displayed together as one summary.
 */
public class FinancialSummary {

    private double totalIncome;
    private double totalExpenses;
    private double netBalance;
    private double monthlyBudget;
    private double budgetRemaining;
    private double monthlyRecurringExpenses;

    /**
     * Creates a financial summary.
     *
     * @param totalIncome total income
     * @param totalExpenses total expenses
     * @param netBalance income minus expenses
     * @param monthlyBudget monthly spending budget
     * @param budgetRemaining amount remaining in budget
     * @param monthlyRecurringExpenses recurring monthly expenses
     */
    public FinancialSummary(
            double totalIncome,
            double totalExpenses,
            double netBalance,
            double monthlyBudget,
            double budgetRemaining,
            double monthlyRecurringExpenses) {

        this.totalIncome = totalIncome;
        this.totalExpenses = totalExpenses;
        this.netBalance = netBalance;
        this.monthlyBudget = monthlyBudget;
        this.budgetRemaining = budgetRemaining;
        this.monthlyRecurringExpenses =
                monthlyRecurringExpenses;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

    public double getNetBalance() {
        return netBalance;
    }

    public double getMonthlyBudget() {
        return monthlyBudget;
    }

    public double getBudgetRemaining() {
        return budgetRemaining;
    }

    public double getMonthlyRecurringExpenses() {
        return monthlyRecurringExpenses;
    }

    /**
     * Returns a readable financial summary.
     *
     * @return formatted financial summary
     */
    @Override
    public String toString() {

        return String.format(
                "Total Income:              $%.2f%n" +
                "Total Expenses:            $%.2f%n" +
                "Net Balance:               $%.2f%n" +
                "Monthly Budget:            $%.2f%n" +
                "Budget Remaining:          $%.2f%n" +
                "Monthly Recurring:         $%.2f",
                totalIncome,
                totalExpenses,
                netBalance,
                monthlyBudget,
                budgetRemaining,
                monthlyRecurringExpenses
        );
    }
}
