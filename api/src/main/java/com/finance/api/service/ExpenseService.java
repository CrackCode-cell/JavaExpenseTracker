package com.finance.api.service;

import com.finance.api.model.Expense;
import com.finance.api.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Handles business logic for expenses.
 */
@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(
            ExpenseRepository expenseRepository) {

        this.expenseRepository = expenseRepository;
    }

    public List<Expense> getAllExpenses() {

        return expenseRepository.findAll();
    }

    public Expense getExpenseById(Long id) {

        return expenseRepository
                .findById(id)
                .orElse(null);
    }

    public Expense createExpense(Expense expense) {

        return expenseRepository.save(expense);
    }

    public double calculateTotal() {

        double total = 0;

        List<Expense> expenses =
                expenseRepository.findAll();

        for (Expense expense : expenses) {

            total += expense.getAmount();
        }

        return total;
    }

    public boolean deleteExpense(Long id) {

        if (!expenseRepository.existsById(id)) {
            return false;
        }

        expenseRepository.deleteById(id);

        return true;
    }
}
