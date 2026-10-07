package com.finance.api.budget;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for monthly budget operations.
 */
@RestController
@RequestMapping("/api/budget")
public class BudgetController {

    private final BudgetService budgetService;

    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    /**
     * Gets the current monthly budget.
     */
    @GetMapping
    public ResponseEntity<Budget> getBudget() {

        return ResponseEntity.ok(
                budgetService.getBudget()
        );
    }

    /**
     * Creates or updates the monthly budget.
     */
    @PutMapping
    public Budget setBudget(
            @RequestBody Budget budget) {

        return budgetService.setBudget(budget);
    }

    /**
     * Gets the amount remaining in the budget.
     */
    @GetMapping("/remaining")
    public double getRemainingBudget() {

        return budgetService.getRemainingBudget();
    }

    /**
     * Determines whether the user is over budget.
     */
    @GetMapping("/over-budget")
    public boolean isOverBudget() {

        return budgetService.isOverBudget();
    }
}
