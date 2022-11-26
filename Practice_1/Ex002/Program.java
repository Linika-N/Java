// Вывести все простые числа от 1 до 1000 

package Ex002;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner uScanner = new Scanner(System.in);
        System.out.println("Введите число от 1 до 1000");
        int num = 0;
        while (num<1){
            num=uScanner.nextInt();
            if (num<1 || num > 1000) System.out.println("Число должно быть от 1 до 1000!");
        }
        String answer = primeNumber(num);
        uScanner.close();
        System.out.printf("Простые числа от 1 до %d: %s",num,answer);
    }
    public static String primeNumber(int number) {     
        //Поиск простых чисел от 1 до числа пользователя
        if (number ==1) return String.valueOf(number);
        String result = "1 ";
        boolean flag = true;
        for (int a = 2; a<= number;a++){
            for (int c = 1;c<=a;c++){
                if (a%c==0 && c!=a && c!=1) {
                    flag=false;
                    break;
                }
            }
            if(flag==true){
                result = result.concat(String.valueOf(a)+" "); 
            }
            flag = true;
        }
        return result;
    }
}