package Practice_2.Ex002;

import java.util.logging.*;
import java.io.IOException;
import java.util.Random;

// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
public class Ex002 {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Ex002.class.getName());
        try{ 
            FileHandler fh = new FileHandler("Practice_2/Ex002/Logger.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        }catch (IOException e){
            logger.log(Level.WARNING,"Exception",e);
        }
        int[] array = makeArray();
        printArray(array,"Изначальный массив: ");
        int[] sortArray = bubbleSort(array,logger);
        printArray(sortArray, "Отсортированный массив: "); 
        
    }
    public static int[] makeArray() {
        Random rnd = new Random();
        int[] list = new int[rnd.nextInt(5,15)];
        for (int i = 0; i<list.length; i++) {
            list[i]= rnd.nextInt(-50, 50);
        }
        return list;
    }
    public static int[] bubbleSort(int[] arr,Logger log) {
        int[] result = arr.clone();
        int temp=0;
        for (int i=0;i<result.length;i++) {
            for (int j=0;j<result.length-1;j++) {
                if (result[j]> result[j+1]){
                    temp = result[j];
                    result[j] = result[j+1];
                    result[j+1] = temp;
                    log.log(Level.INFO,String.format("Поменяли местами %d и %d",result[j], result[j+1]));
                }
            }
        }
        return result;
    }
    public static void printArray(int[] arr, String message) {
        System.out.println(message);
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
