package ca.bcit.comp2522.bank;

/**
 * The BankAccount class represents a bank account associated with a BankClient.
 * It includes functionalities to manage the account balance, track account
 * details, and perform withdrawals.
 *
 * <p>
 * Each bank account has a unique account number, an opening date, and an optional
 * closing date. The account can be accessed through a BankClient, allowing
 * withdrawals to be made using either just the amount or a PIN for security.
 * </p>
 *
 * <p>
 * The class provides methods to retrieve account details, including the balance,
 * account number, and dates related to the account's status.
 * </p>
 *
 */
public class BankAccount {
    private final String accountNumber;
    private final Date accountOpened;
    private final Date accountClosed;
    private final Person client;
    private double balanceUSD;

    private static final int ACC_MIN_NUMBER = 6;
    private static final int ACC_MAX_NUMBER = 7;

    /**
     * Constructor method for BankAccount class.
     *
     * @param accountNumber Account number (6 or 7 characters).
     * @param accountOpened The date when the account was opened.
     * @param accountClosed The date when the account was closed (if any).
     * @param client Client who owns the account.
     * @param balanceUSD Balance amount in USD.
     */
    public BankAccount(final String accountNumber, final Date accountOpened,
                       final Date accountClosed, final Person client, final double balanceUSD) {

        validateAccountNumber(accountNumber);

        this.accountNumber = accountNumber;
        this.accountOpened = accountOpened;
        this.accountClosed = accountClosed;
        this.client = client;
        this.balanceUSD = balanceUSD;
    }

    /**
     * Overloaded Constructor for accounts which are not closed.
     * @param accountNumber Account number (6 or 7 characters).
     * @param accountOpened The date when the account was opened.
     * @param client Client who owns the account.
     * @param balanceUSD Balance amount in USD.
     */
    public BankAccount(final String accountNumber, final Date accountOpened,
                       final Person client, final double balanceUSD) {
        this(accountNumber, accountOpened, null, client, balanceUSD);
    }

    /**
     * Checks if the account number is valid (6 or 7 characters).
     *
     * @param accountNumber The account number to validate.
     * @throws IllegalArgumentException if null, less than 6 or more than 7 characters.
     */
    private static void validateAccountNumber(final String accountNumber) {
        if (accountNumber == null ||
                accountNumber.length() < ACC_MIN_NUMBER ||
                accountNumber.length() > ACC_MAX_NUMBER) {
            throw new IllegalArgumentException("Account number must be 6 or 7 characters.");
        }
    }

    /**
     * Withdraws a specified amount from the account.
     *
     * @param amountUSD The amount to withdraw in USD.
     * @throws IllegalArgumentException if amount is greater than the balance.
     */
    public void withdraw(final double amountUSD) {
        if (amountUSD > balanceUSD) {
            throw new IllegalArgumentException("Insufficient funds for withdrawal.");
        }
        balanceUSD -= amountUSD;
    }

    /**
     * Withdraws a specified amount from the account if the provided PIN matches.
     *
     * @param amountUsd The amount to withdraw in USD.
     * @param pinToMatch The PIN to verify the withdrawal.
     * @throws IllegalArgumentException if amount is greater than the balance or the PIN is incorrect.
     */
    public void withdraw(final double amountUsd, final int pinToMatch) {

        if (!verifyPin(pinToMatch)) {
            throw new IllegalArgumentException("Invalid PIN.");
        }

        withdraw(amountUsd);
    }

    /**
     * Placeholder method for PIN verification.
     *
     * @param pinToMatch The PIN to verify.
     * @return true if the PIN matches; false otherwise.
     */
    private boolean verifyPin(final int pinToMatch) {

        // Placeholder, always returns true for demonstration
        return true;
    }

    /**
     * Gets the details of the bank account.
     *
     * @return A string containing the details of the account.
     */
    public String getDetails() {
        StringBuilder sb = new StringBuilder();

        sb.append(client.getName().getFullName());
        sb.append(" had $");
        sb.append(balanceUSD);
        sb.append(" USD in account #");
        sb.append(accountNumber);
        sb.append(" which he opened on ");
        sb.append(accountOpened.getDayOfTheWeek());
        sb.append(" ");
        sb.append(accountOpened);

        if (accountClosed != null) {
            sb.append(" and closed ");
            sb.append(accountClosed.getDayOfTheWeek());
            sb.append(" ");
            sb.append(accountClosed);
            sb.append(".");
        } else {
            sb.append(" and is still open.");
        }

        return sb.toString();
    }

}
