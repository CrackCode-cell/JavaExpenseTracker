package com.finance.api.income;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Handles business logic for income.
 */
@Service
public class IncomeService {

    private final IncomeRepository incomeRepository;

    public IncomeService(
            IncomeRepository incomeRepository) {

        this.incomeRepository = incomeRepository;
    }

    public List<Income> getAllIncome() {

        return incomeRepository.findAll();
    }

    public Income getIncomeById(Long id) {

        return incomeRepository
                .findById(id)
                .orElse(null);
    }

    public Income createIncome(Income income) {

        return incomeRepository.save(income);
    }

    public double calculateTotalIncome() {

        double total = 0;

        for (Income income : incomeRepository.findAll()) {
            total += income.getAmount();
        }

        return total;
    }

    public boolean deleteIncome(Long id) {

        if (!incomeRepository.existsById(id)) {
            return false;
        }

        incomeRepository.deleteById(id);

        return true;
    }
}
