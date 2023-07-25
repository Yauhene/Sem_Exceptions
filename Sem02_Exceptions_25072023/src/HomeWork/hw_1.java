package HomeWork;

import java.util.Scanner;

//    1. Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
//        и возвращает введенное значение.
//        Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо
//        повторно запросить у пользователя ввод данных.
public class hw_1 {
    public static void main(String[] args) {
        System.out.println("Все хорошо, введенное число:  " + numRequest());
    }

    public static double numRequest() {
        double number = 0;
        boolean getOut = false;
        while (!getOut) {
            System.out.print("Введите дробное число (тип double): ");
            Scanner scanner = new Scanner(System.in);
            try {
                number = Double.parseDouble(scanner.next());
                System.out.println();
                //System.out.println(number);
                //System.out.println("Все хорошо, введенное число - " + number);
                getOut = true;
                //return number;
            } catch (NumberFormatException e) {
                System.out.println("---------- ??????!!!!! ---------------------");
                System.out.println();
                System.out.println("Непорядок... Вы ввели что-то несоответствующее типу double.");
                System.out.println();
                System.out.println("А ну-ка еще разок, только аккуратней!");
                getOut = false;
                number = 0;
            }

        }
        return number;
    }


}
