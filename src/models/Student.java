package models;

import java.util.Date;

public class Student extends Person {

    private Float finalGrade;

    public Student(String name, String phone, Date birthDate, Date insertDate, Date lastChangeDate, Float finalGrade) {

        super( name,  phone,  birthDate,  insertDate, lastChangeDate);
        try {
            setFinalGrade(finalGrade);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }

    public Float getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(Float grade) throws IllegalArgumentException{

        int zeroValue = Float.compare(grade,0.f);//zerovalue >=0
        int tenValue = Float.compare(grade,10.f);//tenvalue <=0

        //Value has to be between 0 and 10
        if(zeroValue >= 0 && tenValue <= 0)
            this.finalGrade = grade;
        else
           throw new IllegalArgumentException("Error input grade value");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", birthDay=" + birthDay +
                ", insertDate=" + insertDate +
                ", lastChangeDate=" + lastChangeDate +
                ", finalGrade=" + finalGrade +
                '}';
    }
}