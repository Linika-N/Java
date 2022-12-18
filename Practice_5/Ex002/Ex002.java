import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.TreeMap;

// Пусть дан список сотрудников: Иван, Пётр, Антон и так далее.
// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. 
// Отсортировать по убыванию популярности.

public class Ex002 {
    public static void main(String[] args) {
        ArrayList<String> namesList = makeList();
        System.out.println("Список имен\n" + namesList);
        HashMap<String,Integer> listToSort = countNames(namesList);
        System.out.println("Список повторений\n" + listToSort);
        TreeMap<Integer,ArrayList<String>> result = sortedDuplicates(listToSort);
        System.out.println("Отсортированный список\n" + result);


    }
    public static ArrayList<String> makeList() {
        String[] names = new String[]{"Иван", "Петр", "Антон", "Мария", "Анастасия", "Елена", "Афанасий", "Евпатий", "Калаврат"};
        Random rnd = new Random();
        ArrayList<String> duplicatedNames = new ArrayList<String>();
        for (int y = 0; y<names.length;y++){
            for(int i=0;i <rnd.nextInt(1,15);i++){
                duplicatedNames.add(names[y]);
            }
        }
        return duplicatedNames;

    }
    public static HashMap<String, Integer> countNames(ArrayList<String> list) {
        HashMap<String,Integer> namesMap = new HashMap<>(list.size());
        for (String string : list) {
            if (namesMap.containsKey(string)) {
                namesMap.put(string, namesMap.get(string)+1);
            }
            else{
                namesMap.putIfAbsent(string, 1);
            }

        }
        return namesMap;
    }
    public static TreeMap<Integer,ArrayList<String>> sortedDuplicates(HashMap<String,Integer> map) {
        TreeMap<Integer,ArrayList<String>> sortedMap = new TreeMap<Integer,ArrayList<String>>(Collections.reverseOrder());
        for (String string : map.keySet()) {
            if(sortedMap.containsKey(map.get(string))){
                sortedMap.get(map.get(string)).add(string);
            }else{
                sortedMap.put(map.get(string),new ArrayList<String>(Arrays.asList(string)));
            }
        }
        return sortedMap;
    }
}
