import controllers.PersonController;
import models.DaoPerson;
import models.Person;
import models.Student;
import views.TerminalView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        TerminalView t = new TerminalView();
        DaoPerson d = new DaoPerson();

        PersonController personController = new PersonController(d,t);

        personController.init();

        System.exit(0);

    }

    private static void mainMenu() {
        System.out.println("----------Insert Person or Student----------");
        System.out.println("1 - Insert Person or Student");
        System.out.println("2 - Delete Person or Student");
        System.out.println("3 - Update Person or Student");
        System.out.println("4 - List all Person or Student");
        System.out.println("0 - Exit");
    }

    private static void updatePerson(int idField, Person p) throws IOException, IOException, ParseException {
        Scanner in = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        switch (idField){
            case 1:
                System.out.println("Type new name:");
                String name = br.readLine();
                p.setName(name);
                break;
            case 2:
                System.out.println("Type new phone:");
                String phone = br.readLine();
                p.setPhone(phone);
                break;
            case 3:
                System.out.println("Type new birthday (dd-mm-yyyy):");
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                String birthDay = br.readLine();
                Date date = formatter.parse(birthDay);
                p.setBirthDate(date);
                break;
            case 4:
                System.out.println("Type new grade final:");
                Float grade = Float.parseFloat(br.readLine());

                if(p instanceof Student){
                    ((Student)p).setFinalGrade(grade);
                }
                break;
            default:
                p.setLastChangeDate(new Date());
        }
    }
}