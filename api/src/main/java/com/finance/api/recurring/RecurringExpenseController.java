package com.finance.api.recurring;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for recurring expense operations.
 */
@RestController
@RequestMapping("/api/recurring-expenses")
public class RecurringExpenseController {

    private final RecurringExpenseService service;

    public RecurringExpenseController(
            RecurringExpenseService service) {

        this.service = service;
    }

    @GetMapping
    public List<RecurringExpense>
    getAllRecurringExpenses() {

        return service.getAllRecurringExpenses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecurringExpense>
    getRecurringExpenseById(
            @PathVariable Long id) {

        RecurringExpense expense =
                service.getRecurringExpenseById(id);

        if (expense == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(expense);
    }

    @PostMapping
    public RecurringExpense createRecurringExpense(
            @RequestBody RecurringExpense expense) {

        return service.createRecurringExpense(expense);
    }

    @GetMapping("/monthly-total")
    public double getMonthlyTotal() {

        return service.calculateMonthlyTotal();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecurringExpense(
            @PathVariable Long id) {

        boolean deleted =
                service.deleteRecurringExpense(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
