import models.DaoPerson;
import models.Person;
import models.Student;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DaoPerson daoPerson = new DaoPerson();

        System.out.println("----------Insert Person or Student----------");
        System.out.println("1 - Insert Person or Student");
        System.out.println("2 - Delete Person or Student");
        System.out.println("3 - Update Person or Student");
        System.out.println("4 - List all Person or Student");
        System.out.println("0 - Exit");

        String option = "1";
        int menu = Integer.parseInt(option);

        while (menu != 0)
        {
            switch (menu)
            {
                case 1:
                    try {
                        System.out.println("Enter Name:");
                        String name = br.readLine();

                        System.out.println("Enter Phone:");
                        String phone = br.readLine();

                        System.out.println("Birthday: ex dd-mm-yyyy");
                        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                        String birthDay = br.readLine();
                        Date date = formatter.parse(birthDay);

                        Date dateInsertModified = new Date();

                        System.out.println("Have final Grade? (y:n)");
                        String haveGrade = br.readLine();

                        if(haveGrade.contains("y"))
                        {
                            System.out.println("Enter grade");
                            float grade = Float.parseFloat(br.readLine());

                            Student student = new Student(name, phone, date, dateInsertModified, dateInsertModified, grade);
                            student.toString();
                            daoPerson.insertPerson(student);
                        }
                        else
                        {
                            Person person = new Person(name, phone, date, dateInsertModified, dateInsertModified);
                            daoPerson.insertPerson(person);
                        }

                        menu = 2;
                    }
                    catch (Exception e)
                    {
                        e.getStackTrace();
                    }

                    break;

                case 2:
                    daoPerson.listAllPerson();
                    System.out.println("Type Person name for delete");
                    menu = 0;
                    break;

                default:
                    System.out.println("What is next option:");
                    menu = 3;
            }

         //   menu = 2;

        }


    }
}
