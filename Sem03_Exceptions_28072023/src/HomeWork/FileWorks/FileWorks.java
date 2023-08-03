package HomeWork.FileWorks;

import HomeWork.Abonent.Abonent;
import HomeWork.Main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class FileWorks {
    /**
     * Печать данных из массива абонентов в файлы
     * @param list
     * @throws WriteInFileException
     */
    public static void printAll(ArrayList<Abonent> list) throws WriteInFileException {
        String tempName;
        ArrayList<Abonent> tempArr;
        String wrString = "";
        String fileName = "";
        int printCount = 0;
        HashSet<String> tempSet = new HashSet<>();

        for (int i = 0; i < list.size(); i++) {
            tempName = list.get(i).lName;
            tempArr = new ArrayList<>();
                if (!tempSet.contains(tempName)) {
                    tempSet.add(tempName);
                    tempArr = new ArrayList<>();
                    tempArr = getNamesakes(list, tempName);
                    fileName = "Sem03_Exceptions_28072023/src/HomeWork/" + tempName + ".txt";
                    try (FileWriter writer = new FileWriter(fileName)) {
                        wrString = "";
                        for (int j = 0; j < tempArr.size(); j++) {
                            wrString += tempArr.get(j);
                            wrString += "\n";
                        }
                        System.out.println("fileName: " + fileName);
                        writer.write(wrString);
                        writer.write("\n");
                        writer.flush();
                        writer.flush();
                    } catch (IOException e) {
                        throw new WriteInFileException("Запись в файл не удалась", e);
                    }
                }
                }
        }

    /**
     * Метод поиска однофамильцев
     * @param abList
     * @param pos
     * @return
     */
    public static ArrayList<Abonent> getNamesakes(ArrayList<Abonent> abList, String pos) {
        ArrayList<Abonent> tempArr = new ArrayList<>();
        String tempName = pos;
        for (int i = 0; i < abList.size(); i++) {
            if (abList.get(i).lName.equals(tempName)) {
                tempArr.add(abList.get(i));
            }
        }
        return  tempArr;
    }
}
