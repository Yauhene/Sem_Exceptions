import java.util.Scanner;

public class Main1 {
    /*
    Реализуйте метод, принимающий в качестве аргумента целочисленный массив и некоторое значение.
    Метод ищет в массиве заданное значение и возвращает его индекс. При этом, например:
    если длина массива меньше некоторого заданного минимума, метод возвращает -1,
    в качестве кода ошибки.
    если искомый элемент не найден, метод вернет -2 в качестве кода ошибки.
    если вместо массива пришел null, метод вернет -3
    придумайте свои варианты исключительных ситуаций и верните соответствующие коды ошибок.
    Напишите метод, в котором реализуйте взаимодействие с пользователем.
    То есть, этот метод запросит искомое число у пользователя,
    вызовет первый, обработает возвращенное значение и покажет читаемый результат пользователю.
    Например, если вернулся -2, пользователю выведется сообщение: “Искомый элемент не найден”.
     */
    public static void main(String[] args) {
        int[] array = new int[]{2,6,3,4,-5,0};
        dialog(array);
    }

    private static void dialog(int[] array) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите искомое число");
        int num = scanner.nextInt();
        int code = checkArray(array, num);
        parseCode(code);
    }

    private static void parseCode(int code) {
        switch (code){
            case -1:
                System.out.println("Длинна массива меньше минимального");
                break;
            case -2:
                System.out.println("Искомый элемент не найден");
                break;
            case -3:
                System.out.println("Массив не инициализирован");
                break;
            default:
                System.out.println("Индекс искомого элемента: " + code);
        }
    }

    private static int checkArray(int[] array, int num){
        if (array == null){
            return -3;
        }
        int minLength = 5;
        if (array.length < minLength){
            return -1;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num){
                return i;
            }
        }
        return -2;
    }
}
