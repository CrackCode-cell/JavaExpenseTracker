package com.finance.api.dashboard;

import com.finance.api.budget.Budget;
import com.finance.api.budget.BudgetService;
import com.finance.api.income.IncomeRepository;
import com.finance.api.recurring.RecurringExpenseService;
import com.finance.api.repository.ExpenseRepository;
import com.finance.api.savings.SavingsGoal;
import com.finance.api.savings.SavingsGoalRepository;
import org.springframework.stereotype.Service;

/**
 * Builds the user's financial dashboard from existing data.
 */
@Service
public class DashboardService {

    private final IncomeRepository incomeRepository;
    private final ExpenseRepository expenseRepository;
    private final BudgetService budgetService;
    private final RecurringExpenseService recurringExpenseService;
    private final SavingsGoalRepository savingsGoalRepository;

    public DashboardService(
            IncomeRepository incomeRepository,
            ExpenseRepository expenseRepository,
            BudgetService budgetService,
            RecurringExpenseService recurringExpenseService,
            SavingsGoalRepository savingsGoalRepository) {

        this.incomeRepository = incomeRepository;
        this.expenseRepository = expenseRepository;
        this.budgetService = budgetService;
        this.recurringExpenseService =
                recurringExpenseService;
        this.savingsGoalRepository =
                savingsGoalRepository;
    }

    /**
     * Calculates all dashboard values.
     */
    public FinancialDashboard getDashboard() {

        double totalIncome =
                incomeRepository.findAll()
                        .stream()
                        .mapToDouble(income -> income.getAmount())
                        .sum();

        double totalExpenses =
                expenseRepository.findAll()
                        .stream()
                        .mapToDouble(expense -> expense.getAmount())
                        .sum();

        double netBalance =
                totalIncome - totalExpenses;

        double monthlyBudget = 0;
        double budgetRemaining = 0;
        boolean overBudget = false;

        try {

            Budget budget = budgetService.getBudget();

            monthlyBudget =
                    budget.getMonthlyAmount();

            budgetRemaining =
                    budgetService.getRemainingBudget();

            overBudget =
                    budgetService.isOverBudget();

        } catch (Exception e) {

            // A dashboard can still be generated
            // before the user creates a budget.
        }

        double monthlyRecurringExpenses =
                recurringExpenseService
                        .calculateMonthlyTotal();

        double totalSaved = 0;
        double totalSavingsTarget = 0;

        for (SavingsGoal goal :
                savingsGoalRepository.findAll()) {

            totalSaved += goal.getCurrentAmount();
            totalSavingsTarget += goal.getTargetAmount();
        }

        return new FinancialDashboard(
                totalIncome,
                totalExpenses,
                netBalance,
                monthlyBudget,
                budgetRemaining,
                overBudget,
                monthlyRecurringExpenses,
                totalSaved,
                totalSavingsTarget
        );
    }
}
