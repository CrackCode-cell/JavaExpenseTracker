package com.finance.api.dashboard;

/**
 * Represents a calculated overview of the user's finances.
 *
 * This is a DTO rather than a database entity because
 * the dashboard values are calculated from existing data.
 */
public class FinancialDashboard {

    private double totalIncome;
    private double totalExpenses;
    private double netBalance;

    private double monthlyBudget;
    private double budgetRemaining;
    private boolean overBudget;

    private double monthlyRecurringExpenses;

    private double totalSaved;
    private double totalSavingsTarget;

    public FinancialDashboard(
            double totalIncome,
            double totalExpenses,
            double netBalance,
            double monthlyBudget,
            double budgetRemaining,
            boolean overBudget,
            double monthlyRecurringExpenses,
            double totalSaved,
            double totalSavingsTarget) {

        this.totalIncome = totalIncome;
        this.totalExpenses = totalExpenses;
        this.netBalance = netBalance;
        this.monthlyBudget = monthlyBudget;
        this.budgetRemaining = budgetRemaining;
        this.overBudget = overBudget;
        this.monthlyRecurringExpenses =
                monthlyRecurringExpenses;
        this.totalSaved = totalSaved;
        this.totalSavingsTarget = totalSavingsTarget;
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

    public boolean isOverBudget() {
        return overBudget;
    }

    public double getMonthlyRecurringExpenses() {
        return monthlyRecurringExpenses;
    }

    public double getTotalSaved() {
        return totalSaved;
    }

    public double getTotalSavingsTarget() {
        return totalSavingsTarget;
    }
}
