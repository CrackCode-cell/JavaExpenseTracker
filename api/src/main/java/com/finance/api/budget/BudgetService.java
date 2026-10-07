package com.finance.api.budget;

import com.finance.api.exception.ResourceNotFoundException;
import com.finance.api.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

/**
 * Handles business logic for the user's monthly budget.
 */
@Service
public class BudgetService {

    private final BudgetRepository budgetRepository;
    private final ExpenseRepository expenseRepository;

    public BudgetService(
            BudgetRepository budgetRepository,
            ExpenseRepository expenseRepository) {

        this.budgetRepository = budgetRepository;
        this.expenseRepository = expenseRepository;
    }

    /**
     * Returns the current budget.
     *
     * This application is designed around one active monthly budget.
     */
    public Budget getBudget() {

        return budgetRepository.findAll()
                .stream()
                .findFirst()
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "No monthly budget has been created yet."
                        )
                );
    }

    /**
     * Creates the budget if one does not exist.
     * Otherwise, updates the existing budget.
     */
    public Budget setBudget(Budget updatedBudget) {

        Budget budget = budgetRepository.findAll()
                .stream()
                .findFirst()
                .orElse(null);

        if (budget == null) {
            return budgetRepository.save(updatedBudget);
        }

        budget.setMonthlyAmount(
                updatedBudget.getMonthlyAmount()
        );

        return budgetRepository.save(budget);
    }

    /**
     * Calculates how much of the monthly budget remains.
     */
    public double getRemainingBudget() {

        Budget budget = getBudget();

        double totalExpenses =
                expenseRepository.findAll()
                        .stream()
                        .mapToDouble(expense -> expense.getAmount())
                        .sum();

        return budget.getMonthlyAmount() - totalExpenses;
    }

    /**
     * Determines whether the user has exceeded the budget.
     */
    public boolean isOverBudget() {

        return getRemainingBudget() < 0;
    }
}
