package com.finance.api;

import com.finance.api.savings.SavingsGoal;
import com.finance.api.savings.SavingsGoalRepository;
import com.finance.api.savings.SavingsGoalService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Tests savings goal calculations.
 */
@ExtendWith(MockitoExtension.class)
public class SavingsGoalServiceTest {

    @Mock
    private SavingsGoalRepository savingsGoalRepository;

    @InjectMocks
    private SavingsGoalService savingsGoalService;

    @Test
    void remainingAmountShouldBeCalculatedCorrectly() {

        SavingsGoal goal =
                new SavingsGoal(
                        "Laptop",
                        1500,
                        600
                );

        when(savingsGoalRepository.findById(1L))
                .thenReturn(
                        java.util.Optional.of(goal)
                );

        double remaining =
                savingsGoalService
                        .getRemainingAmount(1L);

        assertEquals(900.00, remaining);
    }

    @Test
    void goalShouldBeCompleteWhenTargetIsReached() {

        SavingsGoal goal =
                new SavingsGoal(
                        "Laptop",
                        1500,
                        1500
                );

        when(savingsGoalRepository.findById(1L))
                .thenReturn(
                        java.util.Optional.of(goal)
                );

        boolean complete =
                savingsGoalService.isComplete(1L);

        assertEquals(true, complete);
    }
}
