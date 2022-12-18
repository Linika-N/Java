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
                    System.out.println("Введите фамилию и номер через запятую");
                    String contactData = uScanner.nextLine();
                    addContact(map, contactData);
                    System.out.println(map);
                    break;
                case "2":
                    System.out.println("Введите фамилию или номер для поиска");
                    String searchData = uScanner.nextLine();
                    searchContact(map, searchData);
                    break;
                case "3":
                    System.out.println("Введите фамилию или номер для удаления");
                    String deleteData = uScanner.nextLine();
                    deleteContact(map, deleteData);
                    break;
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
        addData.toLowerCase();
        String[] personAndPhone = addData.trim().split(",");
        if (personAndPhone.length==2){
            personAndPhone[1] = personAndPhone[1].trim();
        }
        if (personAndPhone.length > 2) {
            System.out.println("Слишком много данных, попробуйте еще раз.");
            return;
        }
        if (personAndPhone.length < 2) {
            System.out.println("Слишком мало данных  или они введены неверно, попробуйте еще раз.");
            return;
        }
        if (book.isEmpty()) {
            ArrayList<String> person = new ArrayList<String>(Arrays.asList(personAndPhone));
            book.put(1, person);
        } else {
            boolean check = false;
            for (Integer key : book.keySet()) {
                if (book.get(key).get(0).equals(personAndPhone[0])) {
                    book.get(key).add(personAndPhone[1]);
                    check = true;
                }
            }
            if (!check) {
                book.put(book.values().size() + 1, new ArrayList<String>(Arrays.asList(personAndPhone)));
            }
        }
        System.out.printf("Контакт %s добавлен в справочник.\n", addData);
    }

    public static void searchContact(HashMap<Integer, ArrayList<String>> book, String dataForSearch) {
        String personOrPhone = dataForSearch.trim();
        Boolean check = false;
        if (!book.keySet().isEmpty()) {
            for (Integer key : book.keySet()) {
                if (book.get(key).contains(personOrPhone)) {
                    System.out.println(book.get(key));
                    check=true;
                }
            }
            if (check == false) {
                System.out.println("Контакт не найден");
            }

        } else {
            System.out.println("В книге нет контактов.");
        }
    }

    public static void deleteContact(HashMap<Integer, ArrayList<String>> book, String dataToDelete) {
        String personOrPhone = dataToDelete.trim();
        boolean check = false;
        if (!book.keySet().isEmpty()) {
            for (Integer key: book.keySet()) {
                if (book.get(key).contains(personOrPhone)) {
                    check = true;
                    if (book.get(key).get(0).equals(personOrPhone)) {
                        System.out.println("Элемент " + book.remove(key) + " удален");

                    } else {
                        int indToDelet = book.get(key).indexOf(personOrPhone);
                        String deletedPhone = book.get(key).remove(indToDelet);
                        System.out.println("Телефон " + deletedPhone + " удален\n");

                    }
                }
            }
            if (check == false) {
                System.out.println("Контакт не найден");
            }
        } else {
            System.out.println("В книге нет контактов.");
        }
        System.out.println(book);
    }
}