package com.finance.api.recurring;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Provides database operations for recurring expenses.
 */
public interface RecurringExpenseRepository
        extends JpaRepository<RecurringExpense, Long> {
}
