package HomeWork;

import java.util.Scanner;

//    Задание 4. Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
//        Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
public class hw_4 {
    public static void main(String[] args) {
        emptyStringCheck();
    }

    public static void emptyStringCheck() {
        String chkStr;

        System.out.print("Введите строку: ");
        Scanner scanner = new Scanner(System.in);
        chkStr = scanner.nextLine();
        if (chkStr.isEmpty()) {
            throw new IllegalArgumentException("!!!!!!!!!!!!! Пустую строку водить нельзя !!!!!!!!!!!! ");
        } else {
            System.out.println("Все в порядке!");
        }

    }
}
