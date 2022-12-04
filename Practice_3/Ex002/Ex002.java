package Practice_3.Ex002;

import java.util.ArrayList;
import java.util.Random;

// Пусть дан произвольный список целых чисел. Удалить из него чётные числа.
public class Ex002 {
    public static void main(String[] args) {
        ArrayList<Integer> array = makeArray();
        System.out.println("Первоначальный список: \n" + array);
        ArrayList<Integer> result = deleteEvenNumbers(array);
        System.out.println("Список без четных чисел: \n" + result);
    }
    public static ArrayList<Integer> makeArray() {
        Random rnd = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i<rnd.nextInt(5,15); i++) {
            list.add(rnd.nextInt(-50, 51));
        }
        return list;
    }
    public static ArrayList<Integer> deleteEvenNumbers(ArrayList<Integer> arr) {
        ArrayList<Integer> oddList = new ArrayList<>();
        for(int i=0;i<arr.size();i++){
            if (arr.get(i)%2!=0){
                oddList.add(arr.get(i));
            }
        }
        return oddList;
    }

}
