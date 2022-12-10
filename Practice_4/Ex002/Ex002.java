package Practice_4.Ex002;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

// Реализуйте очередь с помощью LinkedList со следующими методами:
// enqueue() - помещает элемент в конец очереди, 
// dequeue() - возвращает первый элемент из очереди и удаляет его,
// first() - возвращает первый элемент из очереди, не удаляя.


public class Ex002 {
    public static void main(String[] args) {
        LinkedList<Integer> list = createList();
        System.out.println("Первоначальный список:\n"+list);
        Integer indexOfElement = scan();
        enqueue(list,indexOfElement);
        Integer firstElement = dequeue(list);
        print(list, firstElement);
        firstElement = first(list);
        print(list, firstElement);
         
    }
    public static Integer scan() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Введите порядковый номер элемента для перемещения в конец очереди: ");
        Integer temp = scn.nextInt();
        while (temp<1){
            System.out.println("Число должно быть больше 0!!!");
            temp = scn.nextInt();
        }
        scn.close();
        return temp;
    }
    public static void print(LinkedList<Integer> startList, Integer element) {
        System.out.printf("Из списка удален первый элемент: %d\n", element);
        System.out.println(startList); 
    }
    public static LinkedList<Integer> createList() {
        Random rnd = new Random();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int g = 0; g<rnd.nextInt(5,15); g++){
            linkedList.add(rnd.nextInt(-25, 25));
        }
        return linkedList;
    }    
    // enqueue() - помещает элемент в конец очереди
    public static void enqueue(LinkedList<Integer> startList, int number) {
        Integer temp = startList.remove(number-1);
        startList.addLast(temp);
        System.out.printf("Элемент под номером %d (%d) перенесен в конец очереди:\n",number,startList.getLast()); 
        System.out.println(startList);       
    }
    
    // dequeue() - возвращает первый элемент из очереди и удаляет его
    public static Integer dequeue(LinkedList<Integer> startList) {
        return startList.removeFirst();
    }

    // first() - возвращает первый элемент из очереди, не удаляя.
    public static Integer first(LinkedList<Integer> startList) {
        return startList.getFirst();
    }
}
