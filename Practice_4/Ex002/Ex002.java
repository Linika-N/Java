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
    }
    public static LinkedList<Integer> createList() {
        Random rnd = new Random();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int g = 0; g<rnd.nextInt(5,15); g++){
            linkedList.add(rnd.nextInt(-25, 25));
        }
        return linkedList;
    }
    public static Integer userData(String msg) {
        Scanner scn = new Scanner(System.in);
        System.out.println("msg");
        Integer temp = scn.nextInt();
        while (temp<1){
            System.out.println("Число должно быть больше 0!!!");
            temp = scn.nextInt();
        }
        scn.close();
        return temp;
    }
    
    // enqueue() - помещает элемент в конец очереди
    public static void enqueue(LinkedList<Integer> startList) {
        int number = userData("Введите элемент для переноса в конец очереди");
        Integer temp = startList.remove(number);
        startList.addLast(temp);
        Integer num = userData("Введите порядковый номер элемента, который хоите переместить в конец очереди");
        
    }
    
    // dequeue() - возвращает первый элемент из очереди и удаляет его
    public static void dequeue(String[] args) {
        
    }

    // first() - возвращает первый элемент из очереди, не удаляя.
    public static void first(String[] args) {
        
    }
}
