package views;

import models.DaoPerson;
import models.Person;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TerminalView {

    private BufferedReader bufferedReader;

    public TerminalView()
    {
        Scanner in = new Scanner(System.in);
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public int mainMenu()
    {
        System.out.println("----------Insert Person or Student----------");
        System.out.println("1 - Insert Person or Student");
        System.out.println("2 - Delete Person or Student");
        System.out.println("3 - Update Person or Student");
        System.out.println("4 - List all Person or Student");
        System.out.println("0 - Exit");

        int option=-1;

        try {
             String input = this.bufferedReader.readLine();
             option = Integer.parseInt(input);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return option;

    }

    public void insertPerson()
    {
        try {
            System.out.println("Enter Name:");
            String name = this.bufferedReader.readLine();

            System.out.println("Enter Phone:");
            String phone = this.bufferedReader.readLine();

            System.out.println("Birthday: ex dd-mm-yyyy");
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String birthDay = this.bufferedReader.readLine();
            Date date = formatter.parse(birthDay);

            Date dateInsertModified = new Date();

            System.out.println("Does he have final Grade? (y:n)");
            String haveGrade = this.bufferedReader.readLine();

            if(haveGrade.contains("y"))
            {
                System.out.println("Enter grade");
                float grade = Float.parseFloat(this.bufferedReader.readLine());

                //todo: controller function create person
               /* Student student = new Student(name, phone, date, dateInsertModified, dateInsertModified, grade);
                System.out.println(student.toString());
                daoPerson.insertPerson(student);
                System.out.println("Student saved with success!");*/
            }
            else
            {
                //todo: controller function create Student
               /* Person person = new Person(name, phone, date, dateInsertModified, dateInsertModified);
                System.out.println(person.toString());
                daoPerson.insertPerson(person);
                System.out.println("Person saved with success!");*/
            }
        }
        catch (Exception e)
        {
            e.getStackTrace();
        }
    }

    public void listAllPerson(DaoPerson p)
    {
        if(p.getListPerson().isEmpty())
        {
            System.out.println("D'ont exists nothing person's save in database");
            return;
        }

        int it = 0;
        for(Person person: p.getListPerson())
        {
            System.out.println(it+"--"+person);
            it++;
        }
    }

    public int deletePerson(DaoPerson p)
    {
        this.listAllPerson(p);

        System.out.println("Choose index option for delete:");

        try {
            String opt = this.bufferedReader.readLine();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        //todo: function controller for delete
        return 0;
    }

    public void updatePerson(DaoPerson p)
    {
        this.listAllPerson(p);

        System.out.println("Choose index option for update:");

        try {
            String opt = this.bufferedReader.readLine();
            int index = Integer.parseInt(opt);

            System.out.print("1- Edit name 2 - Edit phone 3 - Edit birthday");

            if(p.getPerson(index).getClass().getSimpleName().contains("Student"))
            {
                System.out.print("4 - Grade Final");
            }

            int editField = Integer.parseInt(this.bufferedReader.readLine());

            String newValue = this.bufferedReader.readLine();

            //todo: get connstrutor function update function(editField, newValue);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}
