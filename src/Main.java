import java.util.Scanner;

/**
 * Entry point for the Personal Finance Tracker application.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);

        ExpenseTracker tracker =
                new ExpenseTracker();

        // Load previously saved data.
        FileStorage.loadData(tracker);

        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println(
                    "================================="
            );
            System.out.println(
                    "     PERSONAL FINANCE TRACKER"
            );
            System.out.println(
                    "================================="
            );

            System.out.println();
            System.out.println("--- Dashboard ---");
            System.out.println(
                    "9. View Financial Dashboard"
            );

            System.out.println();
            System.out.println("--- Expenses ---");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. View Total");
            System.out.println("4. Find Largest Expense");
            System.out.println("5. View Category Total");
            System.out.println("6. Delete Expense");

            System.out.println();
            System.out.println("--- Budget ---");
            System.out.println("7. Set Monthly Budget");
            System.out.println("8. View Budget Summary");

            System.out.println();
            System.out.println("--- Income ---");
            System.out.println("10. Add Income");
            System.out.println("11. View Income");
            System.out.println(
                    "12. View Income/Expense Summary"
            );

            System.out.println();
            System.out.println("--- Savings ---");
            System.out.println("14. Add Savings Goal");
            System.out.println("15. View Savings Goals");
            System.out.println(
                    "16. Add Money to Savings Goal"
            );

            System.out.println();
            System.out.println(
                    "--- Recurring Expenses ---"
            );
            System.out.println(
                    "18. Add Recurring Expense"
            );
            System.out.println(
                    "19. View Recurring Expenses"
            );
            System.out.println(
                    "20. View Monthly Recurring Total"
            );
            System.out.println(
                    "21. Delete Recurring Expense"
            );

            System.out.println();
            System.out.println("17. Exit");

            System.out.println();
            System.out.print(
                    "Choose an option: "
            );

            int choice = scnr.nextInt();
            scnr.nextLine();

            switch (choice) {

                case 1:

                    System.out.print(
                            "Enter expense amount: $"
                    );

                    double amount =
                            scnr.nextDouble();

                    scnr.nextLine();

                    System.out.print(
                            "Enter category: "
                    );

                    String category =
                            scnr.nextLine();

                    System.out.print(
                            "Enter description: "
                    );

                    String description =
                            scnr.nextLine();

                    tracker.addExpense(
                            new Expense(
                                    amount,
                                    category,
                                    description
                            )
                    );

                    System.out.println(
                            "Expense added!"
                    );

                    break;

                case 2:

                    tracker.viewExpenses();

                    break;

                case 3:

                    System.out.printf(
                            "Total Spending: $%.2f%n",
                            tracker.calculateTotal()
                    );

                    break;

                case 4:

                    Expense largest =
                            tracker.findLargestExpense();

                    if (largest == null) {

                        System.out.println(
                                "No expenses have been added yet."
                        );

                    } else {

                        System.out.println(
                                "Largest Expense:"
                        );

                        System.out.println(
                                largest
                        );
                    }

                    break;

                case 5:

                    System.out.print(
                            "Enter category: "
                    );

                    String searchCategory =
                            scnr.nextLine();

                    System.out.printf(
                            "%s Total: $%.2f%n",
                            searchCategory,
                            tracker.calculateCategoryTotal(
                                    searchCategory
                            )
                    );

                    break;

                case 6:

                    tracker.viewExpenses();

                    System.out.print(
                            "Enter expense number to delete: "
                    );

                    int expenseNumber =
                            scnr.nextInt();

                    scnr.nextLine();

                    if (tracker.deleteExpense(
                            expenseNumber - 1)) {

                        System.out.println(
                                "Expense deleted!"
                        );

                    } else {

                        System.out.println(
                                "Invalid expense number."
                        );
                    }

                    break;

                case 7:

                    System.out.print(
                            "Enter your monthly budget: $"
                    );

                    double budget =
                            scnr.nextDouble();

                    scnr.nextLine();

                    tracker.setMonthlyBudget(
                            budget
                    );

                    System.out.printf(
                            "Monthly budget set to: $%.2f%n",
                            budget
                    );

                    break;

                case 8:

                    System.out.println(
                            "=== Budget Summary ==="
                    );

                    System.out.printf(
                            "Monthly Budget: $%.2f%n",
                            tracker.getMonthlyBudget()
                    );

                    System.out.printf(
                            "Total Spent:    $%.2f%n",
                            tracker.calculateTotal()
                    );

                    System.out.printf(
                            "Remaining:      $%.2f%n",
                            tracker.calculateRemainingBudget()
                    );

                    break;

                case 9:

                    FinancialSummary summary =
                            tracker.generateFinancialSummary();

                    System.out.println();
                    System.out.println(
                            "=== FINANCIAL DASHBOARD ==="
                    );

                    System.out.println(
                            summary
                    );

                    break;

                case 10:

                    System.out.print(
                            "Enter income amount: $"
                    );

                    double incomeAmount =
                            scnr.nextDouble();

                    scnr.nextLine();

                    System.out.print(
                            "Enter income source: "
                    );

                    String source =
                            scnr.nextLine();

                    System.out.print(
                            "Enter description: "
                    );

                    String incomeDescription =
                            scnr.nextLine();

                    tracker.addIncome(
                            new Income(
                                    incomeAmount,
                                    source,
                                    incomeDescription
                            )
                    );

                    System.out.println(
                            "Income added!"
                    );

                    break;

                case 11:

                    tracker.viewIncome();

                    break;

                case 12:

                    System.out.println(
                            "=== Income / Expense Summary ==="
                    );

                    System.out.printf(
                            "Total Income:   $%.2f%n",
                            tracker.calculateTotalIncome()
                    );

                    System.out.printf(
                            "Total Expenses: $%.2f%n",
                            tracker.calculateTotal()
                    );

                    System.out.printf(
                            "Net Balance:    $%.2f%n",
                            tracker.calculateNetBalance()
                    );

                    break;

                case 14:

                    System.out.print(
                            "Enter savings goal name: "
                    );

                    String goalName =
                            scnr.nextLine();

                    System.out.print(
                            "Enter target amount: $"
                    );

                    double targetAmount =
                            scnr.nextDouble();

                    System.out.print(
                            "Enter current saved amount: $"
                    );

                    double currentAmount =
                            scnr.nextDouble();

                    scnr.nextLine();

                    tracker.addSavingsGoal(
                            new SavingsGoal(
                                    goalName,
                                    targetAmount,
                                    currentAmount
                            )
                    );

                    System.out.println(
                            "Savings goal added!"
                    );

                    break;

                case 15:

                    tracker.viewSavingsGoals();

                    break;

                case 16:

                    tracker.viewSavingsGoals();

                    System.out.print(
                            "Enter savings goal number: "
                    );

                    int goalNumber =
                            scnr.nextInt();

                    System.out.print(
                            "Enter amount to add: $"
                    );

                    double savingsAmount =
                            scnr.nextDouble();

                    scnr.nextLine();

                    if (tracker.addSavingsToGoal(
                            goalNumber - 1,
                            savingsAmount)) {

                        System.out.println(
                                "Savings added to goal!"
                        );

                    } else {

                        System.out.println(
                                "Invalid savings goal number."
                        );
                    }

                    break;

                case 18:

                    System.out.print(
                            "Enter recurring expense name: "
                    );

                    String recurringName =
                            scnr.nextLine();

                    System.out.print(
                            "Enter category: "
                    );

                    String recurringCategory =
                            scnr.nextLine();

                    System.out.print(
                            "Enter monthly amount: $"
                    );

                    double recurringAmount =
                            scnr.nextDouble();

                    scnr.nextLine();

                    System.out.print(
                            "Enter frequency: "
                    );

                    String frequency =
                            scnr.nextLine();

                    tracker.addRecurringExpense(
                            new RecurringExpense(
                                    recurringName,
                                    recurringCategory,
                                    recurringAmount,
                                    frequency
                            )
                    );

                    System.out.println(
                            "Recurring expense added!"
                    );

                    break;

                case 19:

                    tracker.viewRecurringExpenses();

                    break;

                case 20:

                    System.out.printf(
                            "Monthly Recurring Expenses: $%.2f%n",
                            tracker.calculateMonthlyRecurringExpenses()
                    );

                    break;

                case 21:

                    tracker.viewRecurringExpenses();

                    System.out.print(
                            "Enter recurring expense number to delete: "
                    );

                    int recurringNumber =
                            scnr.nextInt();

                    scnr.nextLine();

                    if (tracker.deleteRecurringExpense(
                            recurringNumber - 1)) {

                        System.out.println(
                                "Recurring expense deleted!"
                        );

                    } else {

                        System.out.println(
                                "Invalid recurring expense number."
                        );
                    }

                    break;

                case 17:

                    // Save all data before exiting.
                    FileStorage.saveData(tracker);

                    running = false;

                    System.out.println(
                            "Goodbye!"
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid option. Please try again."
                    );
            }
        }

        scnr.close();
    }
}
