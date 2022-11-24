package Ex001;
/**
 * Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
 */

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        //1-треугольное число; 2 - факториал 
        Scanner uScanner = new Scanner(System.in);
        userInterface(1,uScanner);
        userInterface(2,uScanner);       
        uScanner.close();
    }
    public static void userInterface(int choice,Scanner scan) {     
        //Функционал пользователя
        String msg ="Введите число для вычисления треугольного числа: ";
        if (choice == 2) msg = "Введите число для вычисления факториала: ";  
        int number = userData(msg,scan);
        int answer;
        if (choice ==1) answer = triangularNumber(number);
        else answer = factorialOfNumber(number);
        printAnswer(number, answer, choice);        
    }
    public static int userData(String message,Scanner s) {     
        //Данные пользователя
        int num= -1;
        System.out.println(message);
        while (num<0){
            num=s.nextInt();
            if (num<0) System.out.println("Число должно быть больше либо равно 0!");
        }
        return num;        
    }
    public static int triangularNumber(int number) {        
        //Треугольное число от n
        return number*(number+1)/2;
    }
    public static int factorialOfNumber(int number) {       
        // n факториал
        if (number==1 || number == 0) return 1;
        else return factorialOfNumber(number-1)*number;
    }
    public static void printAnswer(int n,int result,int type) {
        // вывод в консоль
        if (type==1) System.out.printf("Треугольное число от %d = %d. \n",n,result);
        else System.out.printf("%d! = %d. \n",n,result);
    }
}