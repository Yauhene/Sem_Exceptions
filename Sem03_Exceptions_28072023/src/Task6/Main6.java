package Task6;

import HomeWork.FileWorks.WriteInFileException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main6 {
    /*
    Запишите в файл следующие строки:
    Анна=4
    Елена=5
    Марина=6
    Владимир=?
    Константин=?
    Иван=4
    Реализуйте метод, который считывает данные из файла и сохраняет в двумерный массив
    (либо HashMap, если студенты с ним знакомы). В отдельном методе нужно будет пройти по структуре данных,
    если сохранено значение ?, заменить его на соответствующее число.
    Если на каком-то месте встречается символ, отличный от числа или ?, бросить подходящее исключение.
    Записать в тот же файл данные с замененными символами ?.
     */
    public static void main(String[] args) {
        readAndWrite();
    }

    private static void readAndWrite() {
            
        try {
            Map<String, String> map = readFile("src/Task6/test.txt");
            // System.out.println(map);
            // System.out.println(map.get("Елена"));
            replaceText(map);
            saveToFile("src/Task6/test1.txt", map);
        } catch (IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (IllegalArgumentException e){
            System.out.println("Неверный формат записи");
            System.out.println(e.getMessage());
        }
    }

    private static void saveToFile(String filePath, Map<String, String> map) throws WriteInFileException {
        try (FileWriter writer = new FileWriter(filePath)){
            for (Map.Entry<String, String> entry: map.entrySet()){
                writer.write(entry.toString());
                writer.write("\n");
                writer.flush();
            }
        } catch (IOException e){
            throw new WriteInFileException("Запись в файл не удалась", e);
        }
    }

    private static void replaceText(Map<String, String> map){
        for (Map.Entry<String, String> entry: map.entrySet()){
            String key = entry.getKey();
            String val = entry.getValue();
            if (val.equals("?")){
                entry.setValue(String.valueOf(key.length()));
            } else if (!val.matches("[0-9]+")) {
                throw new IllegalArgumentException("Ошибка в строке: " + entry);
            }
        }
    }

    private static Map<String, String> readFile(String filePath) throws ReadFileException {
        Map<String, String> map = new LinkedHashMap<>();
        File file = new File(filePath);
        try (Scanner scanner = new Scanner(file)){
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                String[] temp = line.split("=");
                map.put(temp[0], temp[1]);
            }
        } catch (IOException e){
            throw new ReadFileException("Чтение файла не удалось", e);
        }
        return map;
    }
}

