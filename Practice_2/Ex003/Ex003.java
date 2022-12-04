package Practice_2.Ex003;

// В файле содержится строка с данными:

// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
//  {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
//   {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]

// Напишите метод, который разберёт её на составные части и, используя StringBuilder создаст массив строк такого вида:

// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.
import java.io.BufferedReader;
import java.io.FileReader;


public class Ex003 {
    public static void main(String[] args) throws Exception{
        String strData = getData("in.txt");
        String[] newData= modifiedData(strData);
        String[] answer = request(newData);
        for (String string : answer) {
            System.out.println(string);
        }
    }

    //Получение данных из файла
    public static String getData(String filename) throws Exception{
        BufferedReader fileBuf = new BufferedReader(new FileReader("Practice_2/Ex003/"+filename));
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
        String mod = str.substring(2,str.length()-2);
        String[] result = mod.trim().split("\\},\\{");
        return result;
    }

    //Формирование запроса
    public static String[] request(String[] args) {
        int ind = 0;
        String[] result= new String[args.length];
        for (int s= 0; s< args.length;s++){
            StringBuilder strBuild = new StringBuilder("Студент %s получил %s по предмету %s.");
            if (args[s].contains("null")) continue;
            String[] temp = args[s].split(",");
            for (int p = 0; p< temp.length;p++) {
                ind = strBuild.indexOf("%");
                strBuild.replace(ind,ind+2,temp[p].substring(temp[p].indexOf(":")+2,temp[p].length()-1));
            }
            result[s]=strBuild.toString();
        }
        return result;
    }
}

