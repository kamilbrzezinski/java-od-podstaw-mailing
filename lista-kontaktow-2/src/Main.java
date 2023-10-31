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
            System.out.println("3. Usuń kontakt");
            System.out.println("4. Wyszukaj kontakt");
            System.out.println("5. Zakończ program");
            System.out.println("Wybierz opcję: ");

            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case  1 -> displayContacts();
                case 2 -> addContact();
                case 3 -> deleteContact();
                case 4 -> searchContact();
                case 5 -> System.exit(0);
            }
        }
    }

    private static void displayContacts() {
        Set<String> names = contactBook.keySet();

        for (String name : names) {
            displayContactDetails(name);
        }
    }

    private static void displayContactDetails(String name) {
        System.out.println("Nazwa: " + name);
        System.out.println("Numer telefonu: " + contactBook.get(name));
        System.out.println();
    }


    private static void addContact() {
        System.out.println("Podaj nazwę: ");
        String name = scanner.nextLine();

        System.out.println("Podaj numer telefonu: ");
        String phoneNumber = scanner.nextLine();

        if (contactAlreadyExists(name)) {
            System.out.println("Kontakt o takiej nazwie już istnieje. Czy chcesz go zaktualizować o nowy numer telefonu? (tak / nie)");

            if (scanner.nextLine().equals("tak")) {
                contactBook.put(name, phoneNumber);
                System.out.println("Istniejący kontakt został zaktualizowany.");
            } else {
                System.out.println("Istniejący kontakt nie został zaktualizowany.");
            }
        } else {
            contactBook.put(name, phoneNumber);
        }
    }

    private static void deleteContact() {
        System.out.println("Podaj nazwę kontaktu do usunięcia: ");
        String name = scanner.nextLine();

        if (contactBook.get(name) != null) {
            contactBook.remove(name);
            System.out.println("Kontakt został usunięty!");
        } else {
            System.out.println("Kontakt nie został znaleziony!");
        }
    }

    private static void searchContact() {
        System.out.println("W jaki sposób chcesz wyszukać kontakt?");
        System.out.println("1. Nazwa");
        System.out.println("2. Numer telefonu");

        int option = Integer.parseInt(scanner.nextLine());

        switch (option) {
            case 1 -> searchByName();
            case 2 -> searchByPhoneNumber();
        }
    }

    private static void searchByName() {
        System.out.println("Podaj nazwę: ");
        String name = scanner.nextLine();

        if (contactBook.get(name) != null) {
            System.out.println("Znaleziono kontakt! ");
            displayContactDetails(name);
        } else {
            System.out.println("Nie znaleziono żadnego kontaktu o takiej nazwie.");
        }
    }

    private static void searchByPhoneNumber() {
        boolean found = false;

        System.out.println("Podaj numer telefonu: ");
        String phoneNumber = scanner.nextLine();

        Set<String> names = contactBook.keySet();

        for (String name : names) {
            if (contactBook.get(name).equals(phoneNumber)) {
                displayContactDetails(name);
                found = true;
            }
        }

        if (!found) System.out.println("Nie znaleziono żadnego kontaktu z takim numerem telefonu.");
    }

    private static boolean contactAlreadyExists(String name) {
        String contact = contactBook.get(name);

        return contact != null;
    }
}