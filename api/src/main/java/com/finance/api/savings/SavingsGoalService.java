package com.finance.api.savings;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Handles business logic for savings goals.
 */
@Service
public class SavingsGoalService {

    private final SavingsGoalRepository savingsGoalRepository;

    public SavingsGoalService(
            SavingsGoalRepository savingsGoalRepository) {

        this.savingsGoalRepository =
                savingsGoalRepository;
    }

    public List<SavingsGoal> getAllGoals() {

        return savingsGoalRepository.findAll();
    }

    public SavingsGoal getGoalById(Long id) {

        return savingsGoalRepository
                .findById(id)
                .orElse(null);
    }

    public SavingsGoal createGoal(
            SavingsGoal goal) {

        return savingsGoalRepository.save(goal);
    }

    public SavingsGoal addContribution(
            Long id,
            double amount) {

        SavingsGoal goal =
                getGoalById(id);

        if (goal == null) {
            return null;
        }

        goal.setCurrentAmount(
                goal.getCurrentAmount() + amount
        );

        return savingsGoalRepository.save(goal);
    }

    public double getRemainingAmount(Long id) {

        SavingsGoal goal =
                getGoalById(id);

        if (goal == null) {
            return -1;
        }

        return Math.max(
                0,
                goal.getTargetAmount()
                        - goal.getCurrentAmount()
        );
    }

    public boolean isComplete(Long id) {

        SavingsGoal goal =
                getGoalById(id);

        if (goal == null) {
            return false;
        }

        return goal.getCurrentAmount()
                >= goal.getTargetAmount();
    }

    public boolean deleteGoal(Long id) {

        if (!savingsGoalRepository.existsById(id)) {
            return false;
        }

        savingsGoalRepository.deleteById(id);

        return true;
    }
}
