import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Title: Balance Transactions
 *
 * This program reads data from a transactions file and verifies whether the actual
 * cash at the end of the day matches the expected cash. The program checks for valid input
 * and handles errors such as file not found and invalid transactions.
 */
public class BalanceTransactions {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String ledgerFileName;
        double startingCash;
        double endingCash;
        double expectedCash = 0.0;

        // Input starting and ending cash amounts
        System.out.print("Enter the starting cash amount: ");
        startingCash = keyboard.nextDouble();
        System.out.print("Enter the ending cash amount: ");
        endingCash = keyboard.nextDouble();

        // Prompt user for the transactions file until a valid file is found
        while (true) {
            System.out.print("Enter the ledger file name: ");
            ledgerFileName = keyboard.next();
            File ledgerFile = new File(ledgerFileName);

            // Try to read the file and process transactions
            try (Scanner fileScanner = new Scanner(ledgerFile)) {
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    processTransaction(line, expectedCash);
                }
                break; // Exit the loop when file is processed successfully
            } catch (FileNotFoundException e) {
                System.out.println("File not found. Please enter a valid file name.");
            } catch (Exception e) {
                System.out.println("Error reading transactions. The file is not valid.");
                return; // Exit the program on file reading error
            }
        }

        // Calculate expected cash after all transactions
        expectedCash += startingCash;

        // Compare expected and actual cash at the end of the day
        if (Math.abs(expectedCash - endingCash) < 0.01) {
            System.out.println("The cash at the end of the day matches the expected amount.");
        } else {
            System.out.println("The cash at the end of the day does not match the expected amount.");
            System.out.printf("Expected: %.2f, but found: %.2f%n", expectedCash, endingCash);
        }
    }

    /**
     * Processes a single transaction line from the transactions file.
     *
     * @param transaction A line from the transactions file containing the transaction details.
     * @return The adjusted cash based on the transaction.
     */
    public static void processTransaction(String transaction, double expectedCash) {
        Scanner lineScanner = new Scanner(transaction);
        int invoiceNumber = lineScanner.nextInt();
        double amount = lineScanner.nextDouble();
        String type = lineScanner.next();

        if (type.equals("P")) {
            expectedCash -= amount; // Payment reduces cash
        } else if (type.equals("R")) {
            expectedCash += amount; // Receipt increases cash
        }
    }
}
