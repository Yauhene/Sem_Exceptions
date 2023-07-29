package Task5;

public class MyArrayDataException extends IllegalArgumentException{
    private int i;
    private int j;
    public MyArrayDataException(int i, int j) {
        super("Элемент под индексом [" + i + ", " + j + "] невозможно преобразовать в число");
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}
