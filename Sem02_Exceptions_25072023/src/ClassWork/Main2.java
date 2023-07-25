package ClassWork;

import java.util.Scanner;

public class Main2 {
    public static void ex0(){
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];
        System.out.println("Укажите индекс элемента массива, в который хотите записать значение 1");
        int index = scanner.nextInt();
        if (arr.length > index && index >= 0){
            arr[index] = 1;
        } else {
            System.out.println("Указан индекс за пределами массива");
        }
    }
}
