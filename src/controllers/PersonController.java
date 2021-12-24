package controllers;

import models.DaoPerson;
import models.Person;
import models.Student;
import views.TerminalView;

import java.util.Date;

public class PersonController {

    private DaoPerson daoPerson;
    private TerminalView terminalView;

    public PersonController(DaoPerson daoPerson, TerminalView terminalView) {
        this.daoPerson = daoPerson;
        this.terminalView = terminalView;
    }

    public void init()
    {
        int option;

        do {
            option = this.terminalView.mainMenu();

            switch (option){
                case 1:
                    this.terminalView.insertPerson();
                    break;
                case 2:
                    this.terminalView.deletePerson(this.daoPerson);
                    break;
                case 3:
                    this.terminalView.updatePerson(this.daoPerson);
                    break;
                case 4:
                    this.terminalView.listAllPerson(this.daoPerson);
                    break;
            }

        }while (option != 0);

    }

    public boolean insertPerson(String name, String phone, Date date, Date dateInserted, Date dateInsertModified)
    {
        Person p = new Person(name,phone,date, dateInserted, dateInsertModified);

        return this.daoPerson.insertPerson(p);
    }

    public boolean insertPerson(String name, String phone, Date date, Date dateInserted, Date dateInsertModified, Float grade)
    {
        Student student = new Student(name,phone,date, dateInserted, dateInsertModified,grade);

        return this.daoPerson.insertPerson(student);

    }




    public DaoPerson getDaoPerson() {
        return daoPerson;
    }

    public void setDaoPerson(DaoPerson daoPerson) {
        this.daoPerson = daoPerson;
    }

    public TerminalView getTerminalView() {
        return terminalView;
    }

    public void setTerminalView(TerminalView terminalView) {
        this.terminalView = terminalView;
    }
}
