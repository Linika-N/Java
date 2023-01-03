package Practice_6.Ex001;

import java.util.HashSet;


// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
// Создать множество ноутбуков.
// Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. 
//Критерии фильтрации можно хранить в Map. Например:

// “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет …

// Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

public class Program {
    public static void main(String[] args) {
        HashSet<Laptop> laptops= laptopList();
        Filters.laptopFilters(laptops);
    }
    public static HashSet<Laptop> laptopList() {
        HashSet<Laptop> list = new HashSet<Laptop>();
        Laptop one = new Laptop("Lenovo",4,256,"Windows","grey");
        Laptop two = new Laptop("Acer",16,512,"Windows","black");
        Laptop three = new Laptop("HP",16,512,"Windows","blue");
        Laptop four = new Laptop("Asus",16,1024,"Windows","grey");
        Laptop five = new Laptop("Apple",8,256,"macOS","white");
        Laptop six = new Laptop("Apple",16,512,"macOS","grey");
        Laptop seven = new Laptop("Asus",8,1024,"Endless OS","grey");
        Laptop eight = new Laptop("Acer",4,256,"Windows","black");
        Laptop nine = new Laptop("Apple",8,256,"macOS","brown");
        Laptop ten = new Laptop("HUAWEI",16,512,"Windows","grey");
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);
        list.add(five);
        list.add(six);
        list.add(seven);
        list.add(eight);
        list.add(nine);
        list.add(ten);
        return list;
    }

}
