package com.finance.api.recurring;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Handles business logic for recurring expenses.
 */
@Service
public class RecurringExpenseService {

    private final RecurringExpenseRepository repository;

    public RecurringExpenseService(
            RecurringExpenseRepository repository) {

        this.repository = repository;
    }

    public List<RecurringExpense> getAllRecurringExpenses() {

        return repository.findAll();
    }

    public RecurringExpense getRecurringExpenseById(Long id) {

        return repository
                .findById(id)
                .orElse(null);
    }

    public RecurringExpense createRecurringExpense(
            RecurringExpense expense) {

        return repository.save(expense);
    }

    public double calculateMonthlyTotal() {

        double total = 0;

        for (RecurringExpense expense :
                repository.findAll()) {

            if (expense.getFrequency()
                    .equalsIgnoreCase("monthly")) {

                total += expense.getAmount();
            }
        }

        return total;
    }

    public boolean deleteRecurringExpense(Long id) {

        if (!repository.existsById(id)) {
            return false;
        }

        repository.deleteById(id);

        return true;
    }
}
