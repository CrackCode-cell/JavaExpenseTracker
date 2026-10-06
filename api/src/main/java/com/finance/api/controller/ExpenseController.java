package com.finance.api.controller;

import com.finance.api.model.Expense;
import com.finance.api.service.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for expense operations.
 */
@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(
            ExpenseService expenseService) {

        this.expenseService = expenseService;
    }

    /**
     * GET /api/expenses
     *
     * Returns every expense.
     */
    @GetMapping
    public List<Expense> getAllExpenses() {

        return expenseService.getAllExpenses();
    }

    /**
     * GET /api/expenses/{id}
     *
     * Returns one expense.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(
            @PathVariable Long id) {

        Expense expense =
                expenseService.getExpenseById(id);

        if (expense == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(expense);
    }

    /**
     * POST /api/expenses
     *
     * Creates a new expense.
     */
    @PostMapping
    public Expense createExpense(
            @RequestBody Expense expense) {

        return expenseService.createExpense(expense);
    }

    /**
     * GET /api/expenses/total
     *
     * Returns total spending.
     */
    @GetMapping("/total")
    public double getTotal() {

        return expenseService.calculateTotal();
    }

    /**
     * DELETE /api/expenses/{id}
     *
     * Deletes an expense.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(
            @PathVariable Long id) {

        boolean deleted =
                expenseService.deleteExpense(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
