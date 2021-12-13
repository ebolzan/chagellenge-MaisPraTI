package models;

import java.util.Date;

public class Student extends Person {

    private final Float finalGrade;

    public Student(String name, String phone, Date birthDate, Date insertDate, Date lastChangeDate, Float finalGrade) {

        super( name,  phone,  birthDate,  insertDate, lastChangeDate);
        this.finalGrade = finalGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", birthDate=" + birthDate +
                ", insertDate=" + insertDate +
                ", lastChangeDate=" + lastChangeDate +
                ", finalGrade=" + finalGrade +
                '}';
    }
}
