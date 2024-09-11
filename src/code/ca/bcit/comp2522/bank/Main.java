package ca.bcit.comp2522.bank;

public class Main {

    // Constants for Albert Einstein
    private static final Name NAME_1 = new Name ("Albert", "Einstein");
    private static final Date BIRTH_1 = new Date (14, 3, 1879);
    private static final Date DEATH_1 = new Date (18, 4, 1955);
    private static final String ID_1 = "abc123";
    private static final Date ACC_OPEN_1 = new Date(1, 1, 1900);
    private static final Date ACC_CLOSE_1 = new Date(14, 10, 1950);
    private static final int PIN_1 = 3141;
    private static final double BALANCE_1 = 1000;
    private static final double WITHDRAW_1 = 100;

    // Constants for Nelson Mandela
    private static final Name NAME_2 = new Name ("Nelson", "Mandela");
    private static final Date BIRTH_2 = new Date (18, 7, 1918);
    private static final Date DEATH_2 = new Date (5, 12, 2013);
    private static final String ID_2 = "654321";
    private static final Date ACC_OPEN_2 = new Date(10, 5, 1994);
    private static final int PIN_2 = 4664;
    private static final double BALANCE_2 = 2000;
    private static final double WITHDRAW_2 = 200;

    // Constants for Frida Kahlo
    private static final Name NAME_3 = new Name ("Frida", "Kahlo");
    private static final Date BIRTH_3 = new Date (6, 7, 1907);
    private static final Date DEATH_3 = new Date (6, 7, 1907);
    private static final String ID_3 = "frd123";
    private static final Date ACC_OPEN_3 = new Date(1, 1, 1940);
    private static final Date ACC_CLOSE_3 = new Date(13, 7, 1954);
    private static final int PIN_3 = 1907;
    private static final double BALANCE_3 = 500;
    private static final double WITHDRAW_3 = 50;

    // Constants for Jackie Chan
    private static final Name NAME_4 = new Name ("Jackie", "Chan");
    private static final Date BIRTH_4= new Date (7, 4, 1954);
    private static final String ID_4 = "chan789";
    private static final Date ACC_OPEN_4 = new Date(1, 10, 1980);
    private static final int PIN_4 = 1954;
    private static final double BALANCE_4 = 3000;
    private static final double WITHDRAW_4 = 500;


    public static void main(final String[] args){

        // Details of Albert Einstein
        Person person1 = new Person(NAME_1, BIRTH_1, DEATH_1);

        System.out.println("Person 1's details: ");
        System.out.println("Initials: " + NAME_1.getInitials());
        System.out.println("Full Name: " + NAME_1.getFullName());
        System.out.println("Name Reversed: " + NAME_1.getReverseName());
        System.out.println("Details: " + person1.getDetails());

        BankClient client1 = new BankClient(person1, ACC_OPEN_1, ID_1);

        System.out.println("Bank Client details: " + client1.getDetails());

        BankAccount bank1 = new BankAccount(ID_1, ACC_OPEN_1, ACC_CLOSE_1, person1, BALANCE_1, PIN_1);
        bank1.withdraw(WITHDRAW_1, PIN_1);

        System.out.println("His bank status: " + bank1.getDetails());
        System.out.println();

        // Details of Nelson Mandela
        Person person2 = new Person(NAME_2, BIRTH_2, DEATH_2);

        System.out.println("Person 2's details: ");
        System.out.println("Initials: " + NAME_2.getInitials());
        System.out.println("Full Name: " + NAME_2.getFullName());
        System.out.println("Name Reversed: " + NAME_2.getReverseName());
        System.out.println("Details: " + person2.getDetails());

        BankClient client2 = new BankClient(person2, ACC_OPEN_2, ID_2);

        System.out.println("Bank Client details: " + client2.getDetails());

        BankAccount bank2 = new BankAccount(ID_2, ACC_OPEN_2, person2, BALANCE_2, PIN_2);
        bank2.withdraw(WITHDRAW_2, PIN_2);

        System.out.println("His bank status: " + bank2.getDetails());
        System.out.println();


        // Details of Frida Kahlo
        Person person3 = new Person(NAME_3, BIRTH_3, DEATH_3);

        System.out.println("Person 3's details: ");
        System.out.println("Initials: " + NAME_3.getInitials());
        System.out.println("Full Name: " + NAME_3.getFullName());
        System.out.println("Name Reversed: " + NAME_3.getReverseName());
        System.out.println("Details: " + person3.getDetails());

        BankClient client3 = new BankClient(person3, ACC_OPEN_3, ID_3);

        System.out.println("Bank Client details: " + client3.getDetails());

        BankAccount bank3 = new BankAccount(ID_3, ACC_OPEN_3, ACC_CLOSE_3, person3, BALANCE_3, PIN_3);
        bank3.withdraw(WITHDRAW_3, PIN_3);

        System.out.println("His bank status: " + bank3.getDetails());
        System.out.println();


        // Details of Jackie Chan
        Person person4 = new Person(NAME_4, BIRTH_4);

        System.out.println("Person 4's details: ");
        System.out.println("Initials: " + NAME_4.getInitials());
        System.out.println("Full Name: " + NAME_4.getFullName());
        System.out.println("Name Reversed: " + NAME_4.getReverseName());
        System.out.println("Details: " + person4.getDetails());

        BankClient client4 = new BankClient(person4, ACC_OPEN_4, ID_4);

        System.out.println("Bank Client details: " + client4.getDetails());

        BankAccount bank4 = new BankAccount(ID_4, ACC_OPEN_4, person4, BALANCE_4, PIN_4);
        bank4.withdraw(WITHDRAW_4, PIN_4);

        System.out.println("His bank status: " + bank4.getDetails());
        System.out.println();
    }
}
