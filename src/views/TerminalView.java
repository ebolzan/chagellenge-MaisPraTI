package views;

import controllers.PersonController;
import models.DaoPerson;
import models.Person;
import models.Student;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TerminalView {

    private PersonController personController;

    private BufferedReader bufferedReader;

    public TerminalView()
    {
        Scanner in = new Scanner(System.in);
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public PersonController getPersonController() {
        return personController;
    }

    public void setPersonController(PersonController personController) {
        this.personController = personController;
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
                System.out.println("Enter grade: 0.0 - 10.0:");
                float grade = Float.parseFloat(this.bufferedReader.readLine());

                if (this.personController.insertPerson(name, phone, date, dateInsertModified, dateInsertModified, grade))
                    System.out.println("Student saved with success!");
                else
                    System.out.println("Error in save Student");
            }
            else
            {
                if (this.personController.insertPerson(name, phone, date, dateInsertModified, dateInsertModified))
                    System.out.println("Person saved with success!");
                else
                    System.out.println("Error in save Person");
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

        System.out.println("| id | Name             | Phone           | Birthday  | Insert Date | Last change | FinalGrade |");
        System.out.println("|----|------------------|-----------------|-----------|-------------|-------------|------------|");

        Integer it = 0;
        for(Person person: p.getListPerson())
        {
            int spaceId    = 4 - String.valueOf(it).length();
            int spaceName  = 18 - person.getName().length();
            int spacePhone = 17 - person.getPhone().length();

            String space = String.format("%"+  spaceId +"s", " ");

            System.out.print("|"+it);
            System.out.print(space);

            space = String.format("%"+  spaceName +"s", " ");
            System.out.print("|"+person.getName());
            System.out.print(space);

            space = String.format("%"+  spacePhone +"s", " ");
            System.out.print("|"+person.getPhone());
            System.out.print(space);

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date birthDay = person.getBirthDay();
            System.out.print("|"+dateFormat.format(birthDay)+" ");

            Date insertDate = person.getInsertDate();
            System.out.print("|"+dateFormat.format(insertDate)+"   ");

            Date insertLastChange = person.getLastChangeDate();
            System.out.print("|"+dateFormat.format(insertLastChange)+"   ");

            if (person instanceof Student)
            {
                Float finalGrade = ((Student) person).getFinalGrade();
                System.out.print("|"+finalGrade+"         |");
            }
            else
            {
                System.out.print("|Person      |");
            }
        }
    }

    public void deletePerson(DaoPerson p)
    {
        this.listAllPerson(p);

        if(p.getListPerson().isEmpty())
            return;

        System.out.println("Choose index option for delete:");

        try {
            String opt = this.bufferedReader.readLine();

            if(this.personController.deletePerson(Integer.parseInt(opt)))
            {
                System.out.println("Person deleted with success!");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
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
                System.out.print(" 4 - Grade Final");
            }

            int editField = Integer.parseInt(this.bufferedReader.readLine());
            System.out.println("New value:");
            String newValue = this.bufferedReader.readLine();
            if(this.personController.updatePerson(index, editField, newValue))
                System.out.println("Person update with success!");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
