package ca.bcit.comp2522.bank;

/**
 * The Name class represents a person's name, encapsulating
 * the first and last name.
 *
 * <p>
 * This class provides validation for the names to ensure they
 * are not null, blank, exceed a certain length, or contain the
 * word "admin" in any letter case. It also offers methods to
 * retrieve the initials, full name, reversed name, and
 * formatted output of the name.
 * </p>
 *
 * @author Mansib Talukder
 * @version 2024
 */
public class Name {
    private final String first;
    private final String last;

    private static final int MAX_CHARS = 45;
    private static final int FIRST_CHAR = 0;
    private static final int SECOND_CHAR = 1;

    /**
     * Constructor method for Name class.
     * @param first First Name
     * @param last  Last Name
     */
    public Name(final String first, final String last) {
        validateName(first);
        validateName(last);

        this.first = first;
        this.last = last;
    }

    /**
     * This method validates a name.

     * Names cannot be null, blank, more than 45 characters long,
     * or contain the word "admin" (in any letter case).

     * @param name The Name to validate.
     * @throws IllegalArgumentException if not valid.
     */
    private static void validateName(final String name) {
        if (name == null ||
                name.isBlank() ||
                name.length() > MAX_CHARS ||
                containsAdmin(name)) {
            throw new IllegalArgumentException("Not a valid name" + name);
        }
    }

    /**
     * A helper method which returns true
     * if a name contains the word "admin" in any letter case.
     * @param name Given Name
     * @return true or false
     */
    private static boolean containsAdmin(final String name) {
        return name.toLowerCase().contains("admin");
    }

    /**
     * Getter method for first name.
     * @return First Name
     */
    public String getFirst() {
        return this.first;
    }

    /**
     * Getter method for last name.
     * @return Last Name
     */
    public String getLast() {
        return this.last;
    }

    /**
     * Returns the initials of a given name.
     * @return Initials of First and Last name
     */
    public String getInitials() {
        return first.toUpperCase().charAt(FIRST_CHAR) + "." + last.toUpperCase().charAt(FIRST_CHAR) + ".";
    }

    /**
     * Returns the full name of a given name in correct name case.
     * @return Full Name
     */
    public String getFullName() {
        return first.toUpperCase().charAt(FIRST_CHAR) +
                first.substring(SECOND_CHAR).toLowerCase() +
                " " +
                last.toUpperCase().charAt(FIRST_CHAR) +
                last.substring(SECOND_CHAR).toLowerCase();
    }

    /**
     * Returns the name reversed.
     * Eg. tigER wooDS returns SDoow REgit.
     * @return Reversed Full Name
     */
    public String getReverseName() {
        StringBuilder str = new StringBuilder();

        str.append(first);
        str.append(" ");
        str.append(last);
        str.reverse();

        return str.toString();
    }

    /**
     * toString() method override for Name class
     * @return a Name
     */
    @Override
    public String toString(){
        return this.first + " " + this.last;
    }

}

