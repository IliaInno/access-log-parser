import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Введите первое число: ");
        int firstNumber = new Scanner(System.in).nextInt();
        System.out.println("Введите второе число: ");
        int secondNumber = new Scanner(System.in).nextInt();

        int addition = firstNumber + secondNumber;
        int subtraction = firstNumber - secondNumber;
        int multiplication = firstNumber * secondNumber;
        double quotient = (double) firstNumber / secondNumber;

        System.out.println("Сумма чисел " + firstNumber + " и " + secondNumber + " равна " + addition);
        System.out.println("Разность чисел " + firstNumber + " и " + secondNumber + " равна " + subtraction);
        System.out.println("Произведение " + firstNumber + " на " + secondNumber + " равно " + multiplication);
        System.out.println("Частное от деления " + firstNumber + " на " + secondNumber + " равно "  + quotient);

    }
}