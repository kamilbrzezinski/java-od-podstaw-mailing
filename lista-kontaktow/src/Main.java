/*
  Dołącz do kursu Java od podstaw: https://www.programujodpodstaw.pl/java-od-podstaw
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);
    private final static Map<String, String> contactBook = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Wyświetl wszystkie kontakty");
            System.out.println("2. Dodaj kontakt");
            System.out.println("3. Zakończ program");
            System.out.println("Wybierz opcję: ");

            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case  1 -> displayContacts();
                case 2 -> addContact();
                case 3 -> System.exit(0);
            }
        }
    }

    private static void addContact() {
        System.out.println("Podaj nazwę: ");
        String name = scanner.nextLine();

        System.out.println("Podaj numer telefonu: ");
        String phoneNumber = scanner.nextLine();

        contactBook.put(name, phoneNumber);
    }

    private static void displayContacts() {
        Set<String> names = contactBook.keySet();

        for (String name : names) {
            System.out.println("Nazwa: " + name);
            System.out.println("Numer telefonu: " + contactBook.get(name));
            System.out.println();
        }
    }
}