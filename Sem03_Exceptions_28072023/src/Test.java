import static HomeWork.Preparing.Preparing.inputCheck;

public class Test {
    public static void main(String[] args) {
        int a;
        int b;
        boolean more = true;

        a = 3;
        b = 6;
        try {
            more = inputCheck(a,b);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(more);
    }
}
