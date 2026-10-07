package com.finance.api.budget;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Provides database operations for the budget.
 */
public interface BudgetRepository
        extends JpaRepository<Budget, Long> {
}
