package Practice_3.Ex001;

import java.util.ArrayList;
import java.util.Random;

// Реализовать алгоритм сортировки слиянием.
public class Ex001 {
    public static void main(String[] args) {
        ArrayList<Integer> array = makeArray();
        System.out.println("Первоначальный массив: \n" + array);
        mergeSort(array);
        System.out.println("Отсортированный массив: \n" + array);
    }
    public static ArrayList<Integer> makeArray() {
        Random rnd = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i<rnd.nextInt(5,15); i++) {
            list.add(rnd.nextInt(-50, 51));
        }
        return list;
    }
    public static void mergeSort(ArrayList<Integer> arr) {
        if (arr.size()>1) {
            int half = arr.size()/2;
            ArrayList<Integer> left = new ArrayList<Integer>(arr.subList(0, half));
            ArrayList<Integer> right = new ArrayList<Integer>(arr.subList(half,arr.size()));

            mergeSort(left);
            mergeSort(right);

            merge(arr,left,right);

        } 
    
    }
    public static void merge(ArrayList<Integer> arr,ArrayList<Integer> l,ArrayList<Integer> r) {
        int allElements = l.size()+r.size();
        int a,al,ar;
        a=al=ar=0;
        while(a<allElements){
            if((al<l.size())&& (ar<r.size())){
                if(l.get(al)<r.get(ar)){
                    arr.set(a,l.get(al));
                    a++;
                    al++;
                }
                else{
                    arr.set(a,r.get(ar));
                    a++;
                    ar++;
                }
            }
            else{
                if(al>=l.size()){
                    while(ar<r.size()){
                        arr.set(a,r.get(ar));
                        a++;
                        ar++;
                    }
                }
                if (ar>=r.size()){
                    while(al<l.size()){
                        arr.set(a,l.get(al));
                        a++;
                        al++;
                    }
                }
            }
        }
    }
}
