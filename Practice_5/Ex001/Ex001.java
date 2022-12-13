package Practice_5.Ex001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

//Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что один человек может иметь несколько телефонов.

public class Ex001 {
    public static void main(String[] args) {
        HashMap<Integer, ArrayList<String>> book = new HashMap<>();
        Scanner scan = new Scanner(System.in, "Cp866");
        phoneBook(book, scan);
        scan.close();
    }

    public static void phoneBook(HashMap<Integer, ArrayList<String>> map, Scanner uScanner) {
        while (true) {
            functionChoice();
            String choice = uScanner.nextLine();
            if (choice.toLowerCase().equals("end")) {
                return;
            }
            switch (choice) {
                case "1":
                    System.out.println("Введите фамилию и номер");
                    String contactData = uScanner.nextLine();
                    addContact(map, contactData);
                    System.out.println(map);
                    break;
                case "2":
                    System.out.println("Введите фамилию или номер для поиска");
                    String searchData = uScanner.nextLine();
                    searchContact(map, searchData);
                    break;
                // case "3":
                // System.out.println("Введите фамилию или номер для удаления");
                // String deleteData = scan.nextLine();
                // deleteContact(deleteData);
                // break;
                default:
                    break;
            }
        }
    }

    public static void functionChoice() {
        System.out.println("Выберите функцию справочника: ");
        System.out.println("1. Добавить контакт");
        System.out.println("2. Поиск контакта");
        System.out.println("3. Удалить контакт");
        System.out.println("Для выхода из справочника введите \"End\"");
    }

    public static void addContact(HashMap<Integer, ArrayList<String>> book, String addData) {
        String[] personAndPhone = addData.trim().split(" ");
        // System.out.println(personAndPhone[0] + " " + personAndPhone[1]);
        if (!book.keySet().isEmpty()) {
            for (Integer key : book.keySet()) {
                if (book.get(key).get(0).equals(personAndPhone[0])) {
                    book.get(key).add(personAndPhone[1]);

                } else {
                    book.put(book.values().size() + 1, new ArrayList<String>(Arrays.asList(personAndPhone)));
                }
            }
        } else {
            book.put(book.values().size() + 1, new ArrayList<String>(Arrays.asList(personAndPhone)));
        }
        System.out.printf("Контакт %s добавлен в справочник.\n", addData);
    }
    public static void searchContact(HashMap<Integer, ArrayList<String>> book,String dataForSearch) {
        String personOrPhone = dataForSearch.trim();
        // System.out.println(personAndPhone[0] + " " + personAndPhone[1]);
        if (!book.keySet().isEmpty()) {
            for (Integer key : book.keySet()) {
                if (book..equals())
                if (book.get(key).contains(personOrPhone)) {
                    System.out.println(book.get(key));
                }
            }
            System.out.println("Контакт не найден"); 
        } else {
            System.out.println("В книге нет контактов.");
        }
    }
}