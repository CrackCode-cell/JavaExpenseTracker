package com.finance.api.budget;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.PositiveOrZero;

/**
 * Represents the user's monthly budget.
 */
@Entity
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @PositiveOrZero(message = "Monthly budget cannot be negative")
    private double monthlyAmount;

    public Budget() {
    }

    public Budget(double monthlyAmount) {
        this.monthlyAmount = monthlyAmount;
    }

    public Long getId() {
        return id;
    }

    public double getMonthlyAmount() {
        return monthlyAmount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMonthlyAmount(double monthlyAmount) {
        this.monthlyAmount = monthlyAmount;
    }
}
