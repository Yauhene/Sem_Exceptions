package HomeWork;

public class Main {
    static String testIn = "Иванов Порфирий Кузьмич 23.08.1899 2345676543 m";
    static int paramCount = 6;

    public static void main(String[] args) {
        inputStringPrepairing(testIn);
    }

    public static String[] inputStringPrepairing(String str) {
        boolean fName = false;
        boolean lName = false;
        boolean patronymic = false;
        boolean birthDate = false;
        boolean phone = false;
        boolean sex = false;

        String[] parsedStrArr = str.split(" ");
        String[] tempStr = new String[paramCount];

        findFIO(parsedStrArr,tempStr);
        findBDay(parsedStrArr,tempStr);

//        System.out.println("tempStr после выполнения findFIO():");
//        for (int i = 0; i < tempStr.length; i++) {
//            //tempStr[i] = tempStr[i];
//            System.out.print(tempStr[i] + "; ");
//            System.out.println();
//        }

//        for (int i = 0; i < parsedStr.length; i++) {
//            System.out.println("i: " + i + "  " + parsedStr[i] + " ");
////            System.out.println(!parsedStr[i].matches("[.0-9]+") && parsedStr.length !=1);
//            if (!parsedStr[i].matches("[.0-9]+") && parsedStr.length !=1 ) {
////                System.out.println("lName = false: " + lName = false);
//                if (lName == false) {
//                    System.out.println("пытаемся выделить фамилию");
//                    System.out.println(parsedStr[i] + ": это фамилия");
//                    tempStr[0] = parsedStr[i];
//                    lName = true;
//                }
//                if (lName == true && fName == false) {
//                    //                    System.out.println("проверка на имя");
//                    tempStr[1] = parsedStr[i];
//                    fName = true;
//                    System.out.println(parsedStr[i] + ": это имя");
//                }
//                if (fName == true && patronymic == false) {
//                    tempStr[2] = parsedStr[i];
//                    patronymic = true;
//                    System.out.println(parsedStr[i] + ": это отчество");
//                }
//            } else {
//
//                if (parsedStr[i] == "m" || parsedStr[i] == "f") {
//                    System.out.println(": Есть циферки!");
//                    tempStr[3] = parsedStr[i];
//                    sex = true;
//                }
//                if (IsBDateFormat(parsedStr[i])) {
//                    tempStr[4] = parsedStr[i];
//                    birthDate = true;
//                }
//            }
//
//            if (i == (parsedStr.length - 1)) {
//                System.out.println();
//            }
//        }
        if (parsedStrArr.length != paramCount) {
            System.out.println("Несоответствие количества элементов в строке");
        }
        System.out.println("В итоге tempStr:");
        for (int i = 0; i < tempStr.length; i++) {
            System.out.print(tempStr[i] + "; ");
        }
        System.out.println();
        return parsedStrArr;

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
//                    System.out.println("pDate.charAt(i) = " + pDate.charAt(i));
                    points = true;
                }
            }
        }
        bdFormat = digits && points;
        //System.out.println("bdFormat = " + bdFormat);
        return bdFormat;
    }
    public static String[] findFIO(String[] str, String[] outStr) {
        //int counter = 0;
        int currIndex = -1;
        int validCount = 3;
        String[] arr = new String[3];
        for (int i = 0; i < str.length; i++) {
            if ((!str[i].matches("[.0-9]+")) && (str.length != 1 )) {
                currIndex++;
                if (currIndex < validCount) {
                    arr[currIndex] = str[i];
//                    System.out.println("currIndex: " + currIndex);
//                    System.out.println("tempArr[i]= " + arr[i]);

                }
            }
        }
        if (currIndex != validCount) {
            System.out.println("Несоответствие полей ФИО");
            //return false;
        } else {
            for (int i = 0; i < arr.length; i++) {
                outStr[i] = arr[i];
            }
        }
//        System.out.println("outStr на выходе из findFIO()");
//        for (int i = 0; i < outStr.length; i++){
//            System.out.print(outStr[i] + "; ");
//        }
//        System.out.println();
        return arr;
    }
    public static void findBDay(String[] inStr, String[] outStr) {
        int limitCount = 1;
        int count = 0;
        for (int i = 0; i < inStr.length; i++) {
            if ((inStr[i].matches("[.0-9]+"))) {

                System.out.println("count = " + count);
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
}
