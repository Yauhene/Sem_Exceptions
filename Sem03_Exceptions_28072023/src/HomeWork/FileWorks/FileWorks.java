package HomeWork.FileWorks;

import HomeWork.Abonent.Abonent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWorks {

    private static void saveToFile(String filePath, ArrayList<Abonent> list) throws WriteInFileException{
        try (FileWriter writer = new FileWriter(filePath)){
            for (int i = 0; i < list.size(); i++){
                writer.write(String.valueOf(list.get(i)));
                writer.write("\n");
                writer.flush();
            }
        } catch (IOException e){
            throw new WriteInFileException("Запись в файл не удалась", e);
        }
    }

    public static void printAll(ArrayList<Abonent> list) throws WriteInFileException {
        String tempName;
        ArrayList<Abonent> tempArray;
        String wrString = "";

        for (int i = 0; i < list.size(); i++) {
            tempName = list.get(i).lName;
            tempArray = new ArrayList<>();
            tempArray = getNamesakes(list, i);
            System.out.println("tempArray: i " + i + "  " + tempArray + " -----------------");
//            wrString += list.get(i);
            System.out.println("tempArray: " + tempArray );
//            File file = new File(tempName);
            try (FileWriter writer = new FileWriter(tempName)) {

//                FileWriter writer = new FileWriter(file);

                for (int j = i; j < tempArray.size(); j++) {
//                    System.out.println("Пишем в файл " + tempArray.get(j));

                    wrString += tempArray.get(j);
                    wrString += "\n";
                    System.out.println("-------------------------");
//                    writer.write(String.valueOf(tempArray.get(j)));
//                    writer.write("\n");
                    System.out.println("j: " + j + "  wrString = " + wrString);
                }
                writer.write(wrString);
                writer.write("\n");
            } catch (IOException e) {
                    throw new WriteInFileException("Запись в файл не удалась", e);
            }
        }

    }
    public static ArrayList<Abonent> getNamesakes(ArrayList<Abonent> abList, int pos) {
        ArrayList<Abonent> tempArr = new ArrayList<>();
        String tempName = abList.get(pos).lName;
//        tempArr.add(abList.get(pos));
        for (int i = pos; i < abList.size(); i++) {
            if (abList.get(i).lName.equals(tempName)) {
                tempArr.add(abList.get(i));
            }
        }

        return  tempArr;
    }
}
