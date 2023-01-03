package Practice_6.Ex001;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Filters {
    public static void laptopFilters(HashSet<Laptop> laptops) { //Общий функционал подбора ноутбуков по фильтрам пользователя
        Scanner scan = new Scanner(System.in);
        System.out.println("Хотите подобрать ноутбук? Yes or No");
        String check = scan.nextLine().toLowerCase();
        while (check.equals("yes")) {
            HashMap<String, String> userRequest = userFilter(scan);
            userResponse(laptops, userRequest); 
            System.out.println("Подобрать ноутбук снова?");
            check=scan.nextLine().toLowerCase();
        }
        scan.close();
    }

    public static HashMap<String, String> userFilter(Scanner sc) {  //Запрос параметров у пользователя
        HashMap<String, String> response = new HashMap<String, String>();
        System.out.println("Для подбора ноутбука выберите критерий:");
        System.out.println("Введите наименование модели или 0");
        response.put("needModel", sc.nextLine());
        System.out.println("Введите объем ОЗУ: 4,8,16 или 0");
        response.put("needRAM", sc.nextLine());
        System.out.println("Введите объем ЖД: 256,512,1024 или 0");
        response.put("needSSDCapacity", sc.nextLine());
        System.out.println("Введите операционную систему: Windows, macOS, Endless или 0");
        response.put("needOSVersion", sc.nextLine());
        System.out.println("Введите цвет: white, black, grey,blue, brown или 0");
        response.put("needColor", sc.nextLine());
        return response;
    }

    public static void userResponse(HashSet<Laptop> shopsLaptops, HashMap<String, String> response) {   //Поиск  в множестве ноутбуков параметров пользователя
        for (Laptop laptop : shopsLaptops) {
            if (!response.get("needModel").equals("0")){
                if (!laptop.getModel().toLowerCase().equals(response.get("needModel").toLowerCase())) continue;
            }
            if (!response.get("needRAM").equals("0")){
                if (laptop.getRam()!=Integer.parseInt(response.get("needRAM"))) continue;
            }
            if (!response.get("needSSDCapacity").equals("0")){
                if (!String.valueOf(laptop.getSsdCapacity()).equals(response.get("needSSDCapacity"))) continue;
            }
            if (!response.get("needOSVersion").equals("0")){
                if (!laptop.getOsVersion().toLowerCase().equals(response.get("needOSVersion").toLowerCase())) continue;
            }
            if (!response.get("needColor").equals("0")){
                if (!laptop.getColor().toLowerCase().equals(response.get("needColor").toLowerCase())) continue;
            }
            System.out.println(laptop);
        }
    }
}
