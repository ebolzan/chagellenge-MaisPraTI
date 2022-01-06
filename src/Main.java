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

}