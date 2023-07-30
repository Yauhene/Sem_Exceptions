package HomeWork.InputWorks;

import HomeWork.Abonent.Abonent;
import HomeWork.FileWorks.WriteInFileException;

import java.util.ArrayList;
import java.util.Scanner;

import static HomeWork.FileWorks.FileWorks.printAll;
//import static HomeWork.FileWorks.FileWorks.saveToFile;
import static HomeWork.Preparing.Preparing.Preparing;

public class InputString {

    public static int paramCount = 6;
    public static String[] tempStr;
    public static ArrayList<Abonent> abonentArrayList = new ArrayList<>();

    /**
     * Ввод абонентов
     */
    public static void InputAb() {
        String inStr = "start";
        Scanner scanner = new Scanner(System.in);
        screenCleaning();
        while (!inStr.equals("")) {
            System.out.println();
            tempStr = new String[paramCount];
            System.out.println("Введите строку с данными пользователя. Ввод должен производиться с разделением полей пробелами");
            System.out.println("Фамилия - буквы, день рождения в формате \"dd.mm.yyyy, пол - латинские \"m/f\", номер телфеона -цифры");
            System.out.print("===== Выход из режима ввода - нажать Enter. Введите строку: ");
            inStr = scanner.nextLine();
            System.out.println();
            if (!inStr.equals("")) {
                tempStr = inputStringPreparing(inStr, tempStr);
                abonentArrayList.add(new Abonent(tempStr[0], tempStr[1], tempStr[2], tempStr[3], tempStr[4], tempStr[5]));
                printAbonentArrayList();
            }
        }
        try {
            printAll(abonentArrayList);
        } catch (WriteInFileException e) {
            throw new RuntimeException(e);
        }
//        saveToFile("")
        screenCleaning();
    }

    /**
     * Формирование массива строковых элементов из введенной строки
     *
     * @param str
     * @param inpArray
     * @return
     */
    public static String[] inputStringPreparing(String str, String[] inpArray) {

        String[] parsedStrArr = str.split(" ");
//        String[] tempStr = new String[paramCount];
        Preparing(parsedStrArr,tempStr);


//        System.out.print("В итоге tempStr: ");
//        for (int i = 0; i < tempStr.length; i++) {
//            System.out.print(tempStr[i] + "; ");
//        }
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
     * Вывод экземпляров абонентов из массива абонентов
     */
    public static void printAbonentArrayList(){

        System.out.println("Состояние abonentArrayList (" + abonentArrayList.size() + " elements) !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        for (int i = 0; i < abonentArrayList.size(); i++) {
            System.out.println(abonentArrayList.get(i));
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

}
