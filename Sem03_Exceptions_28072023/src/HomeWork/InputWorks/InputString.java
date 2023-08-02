package HomeWork.InputWorks;

import HomeWork.Abonent.Abonent;
import HomeWork.Exceptions.*;
import HomeWork.FileWorks.WriteInFileException;
import HomeWork.Preparing.Preparing;

import java.util.ArrayList;
import java.util.Scanner;

import static HomeWork.FileWorks.FileWorks.printAll;
import static HomeWork.Preparing.Preparing.inputCheck;

public class InputString {

    public static int paramCount = 6;
    public static int FIOCount = 3;
    public static int sexCount = 1;
    public static int bdCount = 1;
    public static int phoneCount = 1;
    public static String[] tempStr;
    public static ArrayList<Abonent> abonentArrayList = new ArrayList<>();
    public static boolean more = false;

    /**
     * Ввод абонентов
     */
    public static void InputAb() {
        String inStr = "start";
        Scanner scanner = new Scanner(System.in);
//        screenCleaning();
//        boolean more = false;
        while (!inStr.equals("")) {
            System.out.println();
            printAbonentArrayList();
            tempStr = new String[paramCount];
            prompt();
            inStr = scanner.nextLine();
            System.out.println();
            if (!inStr.equals("")) {
                try {
                    more = inputCheck(tempStr.length, paramCount);
                    tempStr = inputStringPreparing(inStr, tempStr);

                    if (more) {
                        abonentArrayList.add(new Abonent(tempStr[0], tempStr[1], tempStr[2], tempStr[3], tempStr[4], tempStr[5]));
                        try {
                            printAll(abonentArrayList);
                        } catch (WriteInFileException e) {
                            System.out.println(e.getMessage());;
                        }
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                 }

            }
        }
    }

    /**
     * Формирование массива строковых элементов из введенной строки
     *
     * @param str
     * @param inpArray
     * @return
     */
    public static String[] inputStringPreparing(String str, String[] inpArray) {
        String[] parsedStrArr;
        InputString.more = false;
        System.out.println();
            parsedStrArr = str.split(" ");
            try {
                more = inputCheck(paramCount,parsedStrArr.length);
                more = Preparing.PreparingArray(parsedStrArr,tempStr);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            finally {
                System.out.println("-----------------------------------------------------");
            }
            System.out.println();
        System.out.println();
        return tempStr;

    }

    /**
     * Очистка экрана
     */
    public static void screenCleaning() {
        for (int i = 1; i == 100; i++) {
            System.out.println();
        }
    }

    /**
     * Вывод в консоль экземпляров абонентов из массива абонентов
     */
    public static void printAbonentArrayList(){
        if (abonentArrayList.size() > 0 | more == true) {
            System.out.println("Состояние списка абонентов (" + abonentArrayList.size() + " записей) ==================================");
            for (int i = 0; i < abonentArrayList.size(); i++) {
                System.out.println(abonentArrayList.get(i));
            }
            System.out.println();
        }
    }

    /**
     * приостановка выполнения программы
     */
    public  static void pauseIt() {
        String s;
        System.out.println("Enter key please...");
        Scanner scanner = new Scanner(System.in);
        s = scanner.nextLine();
    }
public static void prompt() {
    System.out.println("Введите строку с данными пользователя. Ввод должен производиться с разделением полей пробелами");
    System.out.println("Фамилия - буквы, день рождения в формате \"dd.mm.yyyy, пол - латинские \"m/f\", номер телфеона -цифры");
    System.out.print("===== Выход из режима ввода - нажать Enter. Введите строку: ");
}
}
