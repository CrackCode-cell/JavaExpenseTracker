import java.util.ArrayList;

/**
 * Manages expenses, income, savings goals,
 * recurring expenses, and budget information.
 */
public class ExpenseTracker {

    private ArrayList<Expense> expenses;
    private ArrayList<Income> incomes;
    private ArrayList<SavingsGoal> savingsGoals;
    private ArrayList<RecurringExpense> recurringExpenses;

    private double monthlyBudget;

    public ExpenseTracker() {

        expenses = new ArrayList<>();
        incomes = new ArrayList<>();
        savingsGoals = new ArrayList<>();
        recurringExpenses = new ArrayList<>();

        monthlyBudget = 0;
    }

    // =========================
    // EXPENSE METHODS
    // =========================

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public void viewExpenses() {

        if (expenses.isEmpty()) {
            System.out.println(
                    "No expenses have been added yet."
            );
            return;
        }

        for (int i = 0; i < expenses.size(); i++) {

            System.out.println(
                    (i + 1) + ". " + expenses.get(i)
            );
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

            if (expense.getAmount() >
                    largest.getAmount()) {

                largest = expense;
            }
        }

        return largest;
    }

    public double calculateCategoryTotal(
            String category) {

        double total = 0;

        for (Expense expense : expenses) {

            if (expense.getCategory()
                    .equalsIgnoreCase(category)) {

                total += expense.getAmount();
            }
        }

        return total;
    }

    public boolean deleteExpense(int index) {

        if (index < 0 ||
                index >= expenses.size()) {

            return false;
        }

        expenses.remove(index);

        return true;
    }

    // =========================
    // BUDGET METHODS
    // =========================

    public void setMonthlyBudget(double budget) {
        monthlyBudget = budget;
    }

    public double getMonthlyBudget() {
        return monthlyBudget;
    }

    public double calculateRemainingBudget() {
        return monthlyBudget - calculateTotal();
    }

    public boolean isOverBudget() {
        return calculateTotal() > monthlyBudget;
    }

    // =========================
    // INCOME METHODS
    // =========================

    public void addIncome(Income income) {
        incomes.add(income);
    }

    public void viewIncome() {

        if (incomes.isEmpty()) {
            System.out.println(
                    "No income has been added yet."
            );
            return;
        }

        for (int i = 0; i < incomes.size(); i++) {

            System.out.println(
                    (i + 1) + ". " + incomes.get(i)
            );
        }
    }

    public double calculateTotalIncome() {

        double total = 0;

        for (Income income : incomes) {
            total += income.getAmount();
        }

        return total;
    }

    public double calculateNetBalance() {
        return calculateTotalIncome()
                - calculateTotal();
    }

    // =========================
    // SAVINGS GOAL METHODS
    // =========================

    public void addSavingsGoal(
            SavingsGoal goal) {

        savingsGoals.add(goal);
    }

    public void viewSavingsGoals() {

        if (savingsGoals.isEmpty()) {

            System.out.println(
                    "No savings goals have been added yet."
            );

            return;
        }

        for (int i = 0;
                i < savingsGoals.size();
                i++) {

            System.out.println(
                    (i + 1) + ". " +
                    savingsGoals.get(i)
            );
        }
    }

    public boolean addSavingsToGoal(
            int index,
            double amount) {

        if (index < 0 ||
                index >= savingsGoals.size()) {

            return false;
        }

        savingsGoals.get(index)
                .addSavings(amount);

        return true;
    }

    public SavingsGoal getSavingsGoal(
            int index) {

        if (index < 0 ||
                index >= savingsGoals.size()) {

            return null;
        }

        return savingsGoals.get(index);
    }

    // =========================
    // RECURRING EXPENSE METHODS
    // =========================

    public void addRecurringExpense(
            RecurringExpense recurringExpense) {

        recurringExpenses.add(recurringExpense);
    }

    public void viewRecurringExpenses() {

        if (recurringExpenses.isEmpty()) {

            System.out.println(
                    "No recurring expenses have been added yet."
            );

            return;
        }

        for (int i = 0;
                i < recurringExpenses.size();
                i++) {

            System.out.println(
                    (i + 1) + ". " +
                    recurringExpenses.get(i)
            );
        }
    }

    public double calculateMonthlyRecurringExpenses() {

        double total = 0;

        for (RecurringExpense recurringExpense :
                recurringExpenses) {

            total += recurringExpense.getAmount();
        }

        return total;
    }

    public boolean deleteRecurringExpense(
            int index) {

        if (index < 0 ||
                index >= recurringExpenses.size()) {

            return false;
        }

        recurringExpenses.remove(index);

        return true;
    }

    // =========================
    // FINANCIAL SUMMARY
    // =========================

    public FinancialSummary generateFinancialSummary() {

        double totalIncome =
                calculateTotalIncome();

        double totalExpenses =
                calculateTotal();

        double netBalance =
                calculateNetBalance();

        double budgetRemaining =
                calculateRemainingBudget();

        double monthlyRecurringExpenses =
                calculateMonthlyRecurringExpenses();

        return new FinancialSummary(
                totalIncome,
                totalExpenses,
                netBalance,
                monthlyBudget,
                budgetRemaining,
                monthlyRecurringExpenses
        );
    }

    // =========================
    // PERSISTENCE GETTERS
    // =========================

    public ArrayList<Expense> getExpenses() {
        return expenses;
    }

    public ArrayList<Income> getIncomes() {
        return incomes;
    }

    public ArrayList<SavingsGoal> getSavingsGoals() {
        return savingsGoals;
    }

    public ArrayList<RecurringExpense>
            getRecurringExpenses() {

        return recurringExpenses;
    }
}
