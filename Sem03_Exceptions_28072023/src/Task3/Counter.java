package Task3;

import java.io.IOException;

/*Задание №2
        Создайте
        класс Счетчик, у которого есть метод add(), увеличивающий
        значение внутренней int переменной на 1. Сделайте так, чтобы с объектом
        такого типа можно было работать в блоке try with resources. Нужно бросить
        исключение, если работа с объектом типа счетчик была не в ресурсном try
        и/ или ресурс остался открыт. Подумайте какой тип исключения подойдет
        лучше всего.
*/

public class Counter implements AutoCloseable{
    private int count;
    private boolean opened;

    public Counter() {
        opened = true;
    }

    public void add() throws IOException{
        if (!opened){
            throw new IOException("ресурс закрыт");
        }
        count++;
    }

    public boolean isOpened() {
        return opened;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void close() {
        opened = false;
        System.out.println("Ресурс закрыли");
    }
}
