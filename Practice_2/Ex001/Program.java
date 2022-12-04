package Practice_2.Ex001;

import java.io.BufferedReader;
import java.io.FileReader;

// В файле содержится строка с исходными данными в такой форме: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
// Требуется на её основе построить и вывести на экран новую строку, в форме SQL запроса:
// SELECT * FROM students WHERE name = "Ivanov" AND country = "Russia" AND city = "Moscow";

// Для разбора строки используйте String.split. Сформируйте новую строку, используя StringBuilder. Значения null не включаются в запрос.
public class Program {
    public static void main(String[] args) throws Exception{
        String strData = getData("in.txt");
        String[] newData= modifiedData(strData);
        String result = request(newData);
        System.out.println(result);
    }

    //Получение данных из файла
    public static String getData(String filename) throws Exception{
        BufferedReader fileBuf = new BufferedReader(new FileReader("Practice_2/Ex001/"+filename));
        StringBuilder dataBuild = new StringBuilder();
        String str="";
        while ((str=fileBuf.readLine())!=null){
            dataBuild.append(str);
        }
        fileBuf.close();
        return dataBuild.toString();

    }

    //Разбор строки
    public static String[] modifiedData(String str) {
        String mod = str.substring(1,str.length()-1);
        System.out.println(mod);
        String[] result = mod.split(", ");
        return result;
    }

    //Формирование запроса
    public static String request(String[] args) {
        StringBuilder strBuild = new StringBuilder("SELECT * FROM students WHERE name = % AND country = % AND city = %");
        int ind = 0;
        for (int s= 0; s< args.length;s++){
            if (args[s].contains("null")) continue;
            ind = strBuild.indexOf("%");
            strBuild.replace(ind,ind+1,args[s].substring(args[s].indexOf(":")+1,args[s].length()));
        }
        return strBuild.toString();
    }
}
