package HomeWork.Preparing;

import HomeWork.InputWorks.InputString;
import HomeWork.Main;

import static HomeWork.InputWorks.InputString.InputAb;
import static HomeWork.InputWorks.InputString.paramCount;

public class Preparing {
    /**
     * Разбор строки с инфрмацией об абоненте на составляющие
     * с возвратом структурированной строки
     * @param inStr
     * @param outStr
     */
    public static void Preparing(String[] inStr, String[] outStr) {
        inputCheck(inStr,outStr);
        findFIO(inStr,outStr);
        findBDay(inStr,outStr);
        findPhone(inStr,outStr);
        findSex(inStr,outStr);

    }
    public static boolean IsBDateFormat(String pDate) {
        boolean bdFormat = false;
        boolean digits = false;
        boolean points = false;

        for (int i = 0; i < pDate.length(); i++) {
            if (i == 0 || i == 1 || i == 3 || i == 4
                    || i == 6 || i == 7 || i == 8 || i == 9) {
                if (pDate.charAt(i) >= '0' && pDate.charAt(i) <= '9') {
                    digits = true;
                }
            }
            if (i == 2 || i == 5) {
                if (pDate.charAt(i) == '.') {
                    points = true;
                }
            }
        }
        bdFormat = digits && points;
        return bdFormat;
    }

    public static String[] findFIO(String[] str, String[] outStr) {
        //int counter = 0;
        int currIndex = 0;
        int validCount = 3;
        String[] arr = new String[3];
        for (int i = 0; i < str.length; i++) {
            if ((!str[i].matches("[.0-9]+")) && (str.length != 1 )) {
                if (currIndex < validCount) {
                    arr[currIndex] = str[i];
                    currIndex++;
                }
            }
        }
        if (currIndex != validCount) {
            System.out.println("Несоответствие полей ФИО");
        } else {
            for (int i = 0; i < arr.length; i++) {
                outStr[i] = arr[i];
            }
        }
        return arr;
    }

    public static void findBDay(String[] inStr, String[] outStr) {
        int limitCount = 1;
        int count = 0;
        for (int i = 0; i < inStr.length; i++) {
            if ((inStr[i].matches("[.0-9]+"))) {

                if (IsBDateFormat(inStr[i])) {
                    outStr[4] = inStr[i];
                    count++;
                    if (count > limitCount) {
                        System.out.println("Несоответствие количества полей ДР: " + limitCount);
                    }
                }


            }
        }
    }
    public static void findPhone(String[] inStr, String[] outStr) {
        int foundCount = -1;
        int limitCount = 1;
        for (int i = 0; i < inStr.length; i++) {
//            System.out.println("i = " + i + "| inStr[i] = " + inStr[i]);
            if ((inStr[i].matches("[0-9]+"))) {
                    outStr[5] = inStr[i];
                    foundCount++;
                    if (foundCount > limitCount) {
                        System.out.println("Несоответствие количества полей телефонного номера: " + limitCount);
                    }
            }
        }
    }
    public static void findSex(String[] inStr, String[] outStr) {
        int foundCount = 0;
        int limitCount = 1;
        for (int i = 0; i < inStr.length; i++) {
//            System.out.println("i = " + i + " | inStr[i] = " + inStr[i] + " | inStr[i].equals(\"m\") " + inStr[i].equals("m"));
            if ((inStr[i].length() == 1) && (inStr[i].equals("m") | inStr[i].equals("f"))) {
                outStr[3] = inStr[i];
                foundCount++;
//                System.out.println("foundCount = " + foundCount);
                if (foundCount > limitCount) {
                    System.out.println("Несоответствие количества полей пола: " + foundCount);
                }
            }
        }
    }

    /**
     * Проверка на соответствие строки с информацией об абоненте
     * @param inStr
     * @param outStr
     */
    public static void inputCheck(String[] inStr, String[] outStr) {
        if (inStr.length != InputString.paramCount) {
            System.out.println("Несоответствие количества элементов в строке");
        }
    }
}
