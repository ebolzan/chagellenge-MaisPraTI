package models;

import java.util.Date;

public class Student extends Person {

    private Float finalGrade;

    public Student(String name, String phone, Date birthDate, Date insertDate, Date lastChangeDate, Float finalGrade) {

        super( name,  phone,  birthDate,  insertDate, lastChangeDate);
        this.finalGrade = finalGrade;
    }

    public Float getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(Float grade){
        this.finalGrade = grade;
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