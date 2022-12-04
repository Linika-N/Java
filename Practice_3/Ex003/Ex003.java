package Practice_3.Ex003;


import java.util.ArrayList;
import java.util.Random;

// Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметичское этого списка.
public class Ex003 {
    public static void main(String[] args) {
        ArrayList<Integer> array = makeArray();
        System.out.println("Первоначальный список: \n" + array);
        int min = minNumber(array);
        int max = maxNumber(array);
        int avr = averageNumber(array);
        System.out.println("Минимальное число: " + min + "\nМаксимальное число: " +  max + "\nСреднее арифметическое число: " + avr);
    }
    public static ArrayList<Integer> makeArray() {
        Random rnd = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i<rnd.nextInt(5,15); i++) {
            list.add(rnd.nextInt(-50, 51));
        }
        return list;
    }
    public static int minNumber(ArrayList<Integer> arr) {
        int answer = arr.get(0);
        for (int m = 1; m<arr.size();m++){
            int temp = arr.get(m);
            if (temp< answer) answer=temp;
        }
        return answer;
    }
    public static int maxNumber(ArrayList<Integer> arr) {
        int answer = arr.get(0);
        for (int m = 1; m<arr.size();m++){
            int temp = arr.get(m);
            if (temp> answer) answer=temp;
        }
        return answer;
    }
    public static int averageNumber(ArrayList<Integer> arr) {
        float temp = 0;
        for (int m = 0; m<arr.size();m++){
            temp += arr.get(m);
        }
        return Math.round(temp/arr.size());
        
    }

}
