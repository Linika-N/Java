// Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.

package Practice_4.Ex001;

import java.util.LinkedList;
import java.util.Random;

public class Ex001 {
    public static void main(String[] args) {
        LinkedList<Integer> start = createList();
        System.out.println("Начальный список:\n" + start);
        LinkedList<Integer> answer = reverseList(start);
        System.out.println("Перевернутый список:\n" + answer);
    }

    public static LinkedList<Integer> createList() {
        Random rnd = new Random();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int g = 0; g<rnd.nextInt(5,15); g++){
            linkedList.add(rnd.nextInt(-25, 25));
        }
        return linkedList;
    }
    public static LinkedList<Integer> reverseList(LinkedList<Integer> list) {
        for (int k=0;k<list.size()/2;k++){
            Integer temp = list.get(k);
            list.set(k,list.get(list.size()-1-k));
            list.set(list.size()-1-k, temp);
        }
        return list;
    }
    
}