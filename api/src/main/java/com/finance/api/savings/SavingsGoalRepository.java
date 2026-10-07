package com.finance.api.savings;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Provides database operations for savings goals.
 */
public interface SavingsGoalRepository
        extends JpaRepository<SavingsGoal, Long> {
}
