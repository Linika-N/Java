package Practice_5.Ex003;
// Реализовать алгоритм пирамидальной сортировки (HeapSort)

import java.util.Random;

public class Ex003 {
    public static void main(String[] args) {
        int[] numbers = makeArray();
        printArray(numbers);
        heapSort(numbers);
        printArray(numbers);
    }

    public static int[] makeArray() {
        Random rnd = new Random();
        int[] numArray = new int[rnd.nextInt(5,15)];
        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = rnd.nextInt(-25,25);
        }
        return numArray;
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i!=arr.length-1){
                System.out.print(arr[i] + "\t");
            }
            else{
                System.out.println(arr[i]+"]");
            }
        }
    }

    public static void heapSort(int[] array) {
        int size = array.length;
        for (int i = size / 2 - 1; i >= 0; i--) {
            makeheaps(array, size, i);
        }
        for (int j = size - 1; j >= 0; j--) {
            int temp = array[0];
            array[0] = array[j];
            array[j] = temp;

            makeheaps(array, j, 0);
        }
    }

    public static void makeheaps(int[] arr, int lenght, int x) {
        int max = x;
        int left = 2 * x + 1;
        int right = 2 * x + 2;

        if (left < lenght && arr[left] > arr[max]) {
            max = left;
        }
        if (right < lenght && arr[right] > arr[max]) {
            max = right;
        }
        if (max != x) {
            int change = arr[x];
            arr[x] = arr[max];
            arr[max] = change;
            makeheaps(arr, lenght, max);
        }
    }
}
