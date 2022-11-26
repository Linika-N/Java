package Ex003;
//Реализовать простой калькулятор

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner uScanner = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        float a = uScanner.nextFloat();
        System.out.println("Введите операцию( + , - , * , / ): ");
        String operation = uScanner.next();
        System.out.println("Введите второе число: ");
        float b = uScanner.nextFloat();
        float answer = calc(a,operation,b);
        uScanner.close();
        System.out.printf("%.2f %s %.2f = %.2f",a,operation,b,answer);
    }
    public static float calc(float x, String op, float y) {
        switch (op) {
            case ("+"):
                return x+y;
            case "-":
                return x-y;
            case "*":
                return x*y;
            case "/":
                return x/y;
            default:
                return -1;
        }
    }
}
