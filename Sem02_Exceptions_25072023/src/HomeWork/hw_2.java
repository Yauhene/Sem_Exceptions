package HomeWork;


//    Задание 2
//    Если необходимо, исправьте данный код
public class hw_2 {
    public static void main(String[] args) {
        try {
            int d = 0;
            int[] intArray = new int[]{1,222,32,4,53,62,17,86};
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Catching exception: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e.getMessage());
        }
        System.out.println("-------------------------");
    }
}


