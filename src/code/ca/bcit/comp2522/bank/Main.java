package ca.bcit.comp2522.bank;

public class Main {

    public static void main(final String[] args){

        // Details of Albert Einstein
        Name name1 = new Name ("Albert", "Einstein");
        Date birth1 = new Date (14, 3, 1879);
        Date death1 = new Date (18, 4, 1955);
        Person person1 = new Person(name1, birth1, death1);

        System.out.println("Person 1's details: ");
        System.out.println("Initials: " + name1.getInitials());
        System.out.println("Full Name: " + name1.getFullName());
        System.out.println("Name Reversed: " + name1.getReverseName());
        System.out.println("Details: " + person1.getDetails());

        String acc1 = "abc123";
        Date open1 = new Date(1, 1, 1900);
        Date close1 = new Date(14, 10, 1950);

        BankClient client1 = new BankClient(person1, open1, acc1);

        System.out.println("Bank Client details: " + client1.getDetails());

        int pin1 = 3141;
        double balance1 = 1000;
        double withdraw1 = 100;

        BankAccount bank1 = new BankAccount(acc1, open1, close1, person1, balance1);
        bank1.withdraw(withdraw1, pin1);

        System.out.println("His bank status: " + bank1.getDetails());
        System.out.println();


        // Details of Nelson Mandela
        Name name2 = new Name ("Nelson", "Mandela");
        Date birth2 = new Date (18, 7, 1918);
        Date death2 = new Date (5, 12, 2013);
        Person person2 = new Person(name2, birth2, death2);

        System.out.println("Person 2's details: ");
        System.out.println("Initials: " + name2.getInitials());
        System.out.println("Full Name: " + name2.getFullName());
        System.out.println("Name Reversed: " + name2.getReverseName());
        System.out.println("Details: " + person2.getDetails());

        String acc2 = "654321";
        Date open2 = new Date(10, 5, 1994);

        BankClient client2 = new BankClient(person2, open2, acc2);

        System.out.println("Bank Client details: " + client2.getDetails());

        int pin2 = 4664;
        double balance2 = 2000;
        double withdraw2 = 200;

        BankAccount bank2 = new BankAccount(acc2, open2, person2, balance2);
        bank2.withdraw(withdraw2, pin2);

        System.out.println("His bank status: " + bank2.getDetails());
        System.out.println();


        // Details of Frida Kahlo
        Name name3 = new Name ("Frida", "Kahlo");
        Date birth3 = new Date (6, 7, 1907);
        Date death3 = new Date (13, 7, 1954);
        Person person3 = new Person(name3, birth3, death3);

        System.out.println("Person 3's details: ");
        System.out.println("Initials: " + name3.getInitials());
        System.out.println("Full Name: " + name3.getFullName());
        System.out.println("Name Reversed: " + name3.getReverseName());
        System.out.println("Details: " + person3.getDetails());

        String acc3 = "frd123";
        Date open3 = new Date(1, 1, 1940);
        Date close3 = new Date(13, 7, 1954);
        BankClient client3 = new BankClient(person3, open3, acc3);

        System.out.println("Bank Client details: " + client3.getDetails());

        int pin3 = 1907;
        double balance3 = 500;
        double withdraw3 = 50;

        BankAccount bank3 = new BankAccount(acc3, open3, close3, person3, balance3);
        bank3.withdraw(withdraw3, pin3);

        System.out.println("His bank status: " + bank3.getDetails());
        System.out.println();


        // Details of Jackie Chan
        Name name4 = new Name ("Jackie", "Chan");
        Date birth4 = new Date (7, 4, 1954);
        Person person4 = new Person(name4, birth4);

        System.out.println("Person 4's details: ");
        System.out.println("Initials: " + name4.getInitials());
        System.out.println("Full Name: " + name4.getFullName());
        System.out.println("Name Reversed: " + name4.getReverseName());
        System.out.println("Details: " + person4.getDetails());

        String acc4 = "chan789";
        Date open4 = new Date(1, 10, 1980);
        BankClient client4 = new BankClient(person4, open4, acc4);

        System.out.println("Bank Client details: " + client4.getDetails());

        int pin4 = 1954;
        double balance4 = 3000;
        double withdraw4 = 500;

        BankAccount bank4 = new BankAccount(acc4, open4, person4, balance4);
        bank4.withdraw(withdraw4, pin4);

        System.out.println("His bank status: " + bank4.getDetails());
        System.out.println();
    }
}
