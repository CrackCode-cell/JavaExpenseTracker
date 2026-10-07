package com.finance.api.savings;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for savings goal operations.
 */
@RestController
@RequestMapping("/api/savings-goals")
public class SavingsGoalController {

    private final SavingsGoalService savingsGoalService;

    public SavingsGoalController(
            SavingsGoalService savingsGoalService) {

        this.savingsGoalService =
                savingsGoalService;
    }

    @GetMapping
    public List<SavingsGoal> getAllGoals() {

        return savingsGoalService.getAllGoals();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SavingsGoal> getGoalById(
            @PathVariable Long id) {

        SavingsGoal goal =
                savingsGoalService.getGoalById(id);

        if (goal == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(goal);
    }

    @PostMapping
    public SavingsGoal createGoal(
            @RequestBody SavingsGoal goal) {

        return savingsGoalService.createGoal(goal);
    }

    @PostMapping("/{id}/contributions")
    public ResponseEntity<SavingsGoal> addContribution(
            @PathVariable Long id,
            @RequestParam double amount) {

        if (amount <= 0) {
            return ResponseEntity.badRequest().build();
        }

        SavingsGoal updatedGoal =
                savingsGoalService
                        .addContribution(id, amount);

        if (updatedGoal == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedGoal);
    }

    @GetMapping("/{id}/remaining")
    public ResponseEntity<Double> getRemainingAmount(
            @PathVariable Long id) {

        SavingsGoal goal =
                savingsGoalService.getGoalById(id);

        if (goal == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(
                savingsGoalService
                        .getRemainingAmount(id)
        );
    }

    @GetMapping("/{id}/complete")
    public ResponseEntity<Boolean> isComplete(
            @PathVariable Long id) {

        SavingsGoal goal =
                savingsGoalService.getGoalById(id);

        if (goal == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(
                savingsGoalService.isComplete(id)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGoal(
            @PathVariable Long id) {

        boolean deleted =
                savingsGoalService.deleteGoal(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
