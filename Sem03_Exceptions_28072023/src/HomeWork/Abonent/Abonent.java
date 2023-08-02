package HomeWork.Abonent;

public class Abonent {
    public int id;
    public String fName = "";
    public  String lName = "";
    public String patronymic = "";
    public String birthDay = "";
    public String sex = "";
    public String phoneNumber = "";
    static public int index = 1;


    public Abonent(String lName, String fName, String patronymic, String phoneNumber,
                   String sex, String birthDay) {
        this.id = index;
        this.fName = fName;
        this.lName = lName;
        this.patronymic = patronymic;
        this.birthDay = birthDay;
        this.sex = sex;
        this.phoneNumber = phoneNumber;

        index++;


    }


    @Override
    public String toString() {
//        String outStr = "Абонент:\n" + id + " " + lName + " " + fName + " " + patronymic + " " + sex + " " + birthDay + " " + phoneNumber;
        return "id " + id + ": " + lName + " " + fName + " " + patronymic + " " + sex + " " + birthDay + " " + phoneNumber;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }
}
