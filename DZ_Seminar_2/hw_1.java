package DZ_Seminar_2;

import java.util.Scanner;

//    1. Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
//        и возвращает введенное значение.
//        Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо
//        повторно запросить у пользователя ввод данных.
public class hw_1 {  
    public static void main(String[] args) {
        float number = getFloatInput();
        System.out.println("Введенное число: " + number);
    }

    public static float getFloatInput() {
        Scanner scanner = new Scanner(System.in);
        float number = 0.0f;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Введите дробное число: ");
                String input = scanner.nextLine();
                number = Float.parseFloat(input);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод! Попробуйте снова.");
            }
        }

        return number;
    }
}
