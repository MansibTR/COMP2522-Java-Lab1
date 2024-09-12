package ca.bcit.comp2522.bank;

/**
 * The BankClient class represents a client of a bank who is a
 * person with a unique client ID and a signup date. It extends the
 * Person class and adds the ability to track when the client
 * joined the bank.
 *
 * <p>
 * A BankClient can either be alive or dead, and the class
 * provides a method to retrieve a formatted string of the client's
 * details, including their name, status (alive or dead),
 * and the date they joined the bank.
 * </p>
 *
 * <p>
 * The client ID is a string that should be either {@value ID_MIN_LENGTH} or {@value ID_MAX_LENGTH} digits long.
 * </p>
 *
 * @author Mansib Talukder
 * @version 2024
 */
public class BankClient extends Person {

    private static final int ID_MIN_LENGTH = 6;
    private static final int ID_MAX_LENGTH = 7;
    
    private final Date   signupDate;
    private final String clientID;
    
    /**
     * Constructor method for BankClient class.
     *
     * @param name       Name of the person
     * @param birthDate  Birthdate of the person
     * @param deathDate  Death date of the person (can be null if still alive)
     * @param signupDate Signup date for the bank client
     * @param clientID   Client ID (must be {@value ID_MIN_LENGTH} or {@value ID_MAX_LENGTH} digits)
     */
    public BankClient(final Name name, final Date birthDate, final Date deathDate, final Date signupDate, final String clientID) {
        super(name, birthDate, deathDate);
        validateClientID(clientID);
        this.signupDate = signupDate;
        this.clientID   = clientID;
    }

    /**
     * Overloaded constructor method for living BankClients.
     *
     * @param name       Name of the person
     * @param birthDate  Birthdate of the person
     * @param signupDate Signup date for the bank client
     * @param clientID   Client ID (must be {@value ID_MIN_LENGTH} or {@value ID_MAX_LENGTH} digits)
     */
    public BankClient(final Name name, final Date birthDate, final Date signupDate, final String clientID) {
        this(name, birthDate, null, signupDate,clientID);
    }
    
    
    /**
     * Getter method for Signup Date
     * @return Signup Date
     */
    public Date getSignupDate() {
        return this.signupDate;
    }
    
    /**
     * Getter method for ClientID
     * @return ClientID
     */
    public String getClientID() {
        return this.clientID;
    }

    /**
     * This method validates the client ID to ensure
     * it is {@value ID_MIN_LENGTH} or {@value ID_MAX_LENGTH} digits.
     *
     * @param clientID The client ID to validate.
     */
    private static void validateClientID(final String clientID) {
        if (clientID == null ||
            clientID.isBlank() ||
            clientID.length() < ID_MIN_LENGTH ||
            clientID.length() > ID_MAX_LENGTH) {
            throw new IllegalArgumentException("Client ID must be" + ID_MIN_LENGTH +
                                                       "or" + ID_MAX_LENGTH + "digits: " + clientID);
        }
    }

    /**
     * Overrides getDetails method to return bank client details.
     *
     * @return Details of the bank client
     */
    @Override
    public String getDetails() {
        final StringBuilder sb;
        final String        details;
        
        sb = new StringBuilder();

        sb.append(this.getName().getFullName());
        sb.append(" client #");
        sb.append(this.getClientID());
        sb.append(" ");

        if (isAlive()) {
            sb.append("(alive) ");
        } else {
            sb.append("(died ");
            sb.append(getDeathDate().getDayOfTheWeek());
            sb.append(", ");
            sb.append(getDeathDate().toString());
            sb.append(") ");
        }

        sb.append("joined the bank on ");
        sb.append(getSignupDate().getDayOfTheWeek());
        sb.append(", ");
        sb.append(getSignupDate());
        sb.append(".");

        details = sb.toString();
        
        return details;
    }
}

