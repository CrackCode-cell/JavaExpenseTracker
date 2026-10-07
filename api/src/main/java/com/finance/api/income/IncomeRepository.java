package com.finance.api.income;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Provides database operations for income records.
 */
public interface IncomeRepository
        extends JpaRepository<Income, Long> {
}
