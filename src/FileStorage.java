import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Handles saving and loading financial data from a file.
 *
 * This is a simple persistence layer for the CLI application.
 */
public class FileStorage {

    private static final String FILE_NAME =
            "finance-data.txt";

    /**
     * Saves the current tracker data to a file.
     *
     * @param tracker the financial tracker to save
     */
    public static void saveData(ExpenseTracker tracker) {

        try (PrintWriter writer =
                     new PrintWriter(
                             new FileWriter(FILE_NAME))) {

            writer.println(
                    "BUDGET|" +
                    tracker.getMonthlyBudget()
            );

            for (Expense expense :
                    tracker.getExpenses()) {

                writer.println(
                        "EXPENSE|" +
                        expense.getAmount() + "|" +
                        expense.getCategory() + "|" +
                        expense.getDescription()
                );
            }

            for (Income income :
                    tracker.getIncomes()) {

                writer.println(
                        "INCOME|" +
                        income.getAmount() + "|" +
                        income.getSource() + "|" +
                        income.getDescription()
                );
            }

            for (SavingsGoal goal :
                    tracker.getSavingsGoals()) {

                writer.println(
                        "SAVINGS|" +
                        goal.getName() + "|" +
                        goal.getTargetAmount() + "|" +
                        goal.getCurrentAmount()
                );
            }

            for (RecurringExpense recurringExpense :
                    tracker.getRecurringExpenses()) {

                writer.println(
                        "RECURRING|" +
                        recurringExpense.getName() + "|" +
                        recurringExpense.getCategory() + "|" +
                        recurringExpense.getAmount() + "|" +
                        recurringExpense.getFrequency()
                );
            }

            System.out.println(
                    "Financial data saved successfully."
            );

        } catch (IOException e) {

            System.out.println(
                    "Error saving financial data: " +
                    e.getMessage()
            );
        }
    }

    /**
     * Loads saved financial data from the file.
     *
     * @param tracker the tracker that will receive the data
     */
    public static void loadData(ExpenseTracker tracker) {

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split("\\|");

                if (parts.length == 0) {
                    continue;
                }

                switch (parts[0]) {

                    case "BUDGET":

                        tracker.setMonthlyBudget(
                                Double.parseDouble(parts[1])
                        );

                        break;

                    case "EXPENSE":

                        Expense expense =
                                new Expense(
                                        Double.parseDouble(parts[1]),
                                        parts[2],
                                        parts[3]
                                );

                        tracker.addExpense(expense);

                        break;

                    case "INCOME":

                        Income income =
                                new Income(
                                        Double.parseDouble(parts[1]),
                                        parts[2],
                                        parts[3]
                                );

                        tracker.addIncome(income);

                        break;

                    case "SAVINGS":

                        SavingsGoal goal =
                                new SavingsGoal(
                                        parts[1],
                                        Double.parseDouble(parts[2]),
                                        Double.parseDouble(parts[3])
                                );

                        tracker.addSavingsGoal(goal);

                        break;

                    case "RECURRING":

                        RecurringExpense recurringExpense =
                                new RecurringExpense(
                                        parts[1],
                                        parts[2],
                                        Double.parseDouble(parts[3]),
                                        parts[4]
                                );

                        tracker.addRecurringExpense(
                                recurringExpense
                        );

                        break;

                    default:

                        System.out.println(
                                "Unknown data type: " +
                                parts[0]
                        );
                }
            }

            System.out.println(
                    "Financial data loaded successfully."
            );

        } catch (IOException e) {

            System.out.println(
                    "No saved financial data found. " +
                    "Starting with an empty tracker."
            );
        }
    }
}
