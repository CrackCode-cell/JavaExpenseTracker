package com.finance.api.income;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for income operations.
 */
@RestController
@RequestMapping("/api/income")
public class IncomeController {

    private final IncomeService incomeService;

    public IncomeController(
            IncomeService incomeService) {

        this.incomeService = incomeService;
    }

    @GetMapping
    public List<Income> getAllIncome() {

        return incomeService.getAllIncome();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Income> getIncomeById(
            @PathVariable Long id) {

        Income income =
                incomeService.getIncomeById(id);

        if (income == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(income);
    }

    @PostMapping
    public Income createIncome(
            @RequestBody Income income) {

        return incomeService.createIncome(income);
    }

    @GetMapping("/total")
    public double getTotalIncome() {

        return incomeService.calculateTotalIncome();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIncome(
            @PathVariable Long id) {

        boolean deleted =
                incomeService.deleteIncome(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
