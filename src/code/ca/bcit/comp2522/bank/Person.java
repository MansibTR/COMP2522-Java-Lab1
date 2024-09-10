package ca.bcit.comp2522.bank;

/**
 * The Person class represents an individual with a name,
 * birthdate, and optional death date. This class encapsulates
 * the essential information about a person and provides methods
 * to retrieve their details in a formatted string.
 *
 * <p>
 * A person must have a name and a birth date, and may optionally
 * have a death date. The class provides validation to ensure that
 * these fields are correctly populated. The details can be formatted
 * into a human-readable string, indicating whether the person is
 * alive or deceased.
 * </p>
 *
 * @author Mansib Talukder
 * @version 2024
 */
public class Person {
    private final Name name;
    private final Date birthDate;
    private final Date deathDate;

    /**
     * Constructor method for Person class.
     *
     * @param name      Name
     * @param birthDate Birth Date
     * @param deathDate Death Date
     */
    public Person(final Name name, final Date birthDate, final Date deathDate) {
        validatePerson(name, birthDate);
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
    }

    /**
     * Overloaded constructor method for living Person.
     *
     * @param name      Name
     * @param birthDate Birth Date
     */
    public Person(final Name name, final Date birthDate) {
        this(name, birthDate, null);
    }

    /**
     * This method validates the details of a person.
     * A person must have a name and a birthdate.
     * A person may or may not have a death date.
     * @param name      Name
     * @param birthDate Birth Date
     */
    private static void validatePerson(final Name name, final Date birthDate) {
        // Validate name
        if (name == null) {
            throw new IllegalArgumentException("Person must have a name.");
        }

        // Validate birthdate
        if (birthDate == null) {
            throw new IllegalArgumentException("Person must have a birthdate.");
        }
    }

    /**
     * Getter method for Name
     * @return Name
     */
    public Name getName() {
        return name;
    }

    /**
     * Getter method for Birth Date
     * @return Birth Date
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * Getter method for Death Date
     * @return Death Date
     */
    public Date getDeathDate() {
        return deathDate;
    }

    /**
     * This method returns the details of a person in the exact format of
     * "Tiger Woods (alive) was born on tuesday, December 30, 1975!"
     * or
     * “Albert Einstein (died monday, April 18, 1955) was born on friday, March 14, 1879!”.
     *
     * @return Details
     */
    public String getDetails() {
        StringBuilder sb = new StringBuilder();

        sb.append(name.getFullName());
        sb.append(" ");

        if (deathDate == null) {
            sb.append("(alive) ");
        } else {
            sb.append("(died ");
            sb.append(deathDate.getDayOfTheWeek());
            sb.append(", ");
            sb.append(deathDate);
            sb.append(") ");
        }

        sb.append("was born on ");
        sb.append(birthDate.getDayOfTheWeek());
        sb.append(", ");
        sb.append(birthDate);
        sb.append("!");

        return sb.toString();
    }
}
