package com.finance.api;

import com.finance.api.model.Expense;
import com.finance.api.repository.ExpenseRepository;
import com.finance.api.service.ExpenseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Tests business logic in ExpenseService.
 */
@ExtendWith(MockitoExtension.class)
public class ExpenseServiceTest {

    @Mock
    private ExpenseRepository expenseRepository;

    @InjectMocks
    private ExpenseService expenseService;

    @Test
    void calculateTotalShouldReturnSumOfExpenses() {

        Expense first =
                new Expense(
                        25.00,
                        "Food",
                        "Lunch"
                );

        Expense second =
                new Expense(
                        40.00,
                        "Transportation",
                        "Bus"
                );

        when(expenseRepository.findAll())
                .thenReturn(List.of(first, second));

        double total =
                expenseService.calculateTotal();

        assertEquals(65.00, total);
    }
}
