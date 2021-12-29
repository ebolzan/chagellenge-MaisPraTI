package controllers;

import models.DaoPerson;
import models.Person;
import models.Student;
import views.TerminalView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PersonController {

    private DaoPerson daoPerson;
    private TerminalView terminalView;

    public PersonController(DaoPerson daoPerson, TerminalView terminalView) {
        this.daoPerson = daoPerson;
        this.terminalView = terminalView;
        this.terminalView.setPersonController(this);
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

        if (student.getFinalGrade() == null)
            return false;

        return this.daoPerson.insertPerson(student);
    }

    public boolean deletePerson(int index)
    {
        Person p = this.daoPerson.deletePerson(index);
        if( p == null) {
            return false;
        }
        else
        {
            System.out.println(p + "deleted with success!");
            return true;
        }
    }

    private void updateLastchange(int indexPerson)
    {
        this.daoPerson.getPerson(indexPerson).setLastChangeDate(new Date());
    }

    public Boolean updatePerson(int indexPerson, int field, String newValue)
    {
        Boolean output = false;

        switch (field)
        {
            case 1:
                this.daoPerson.getPerson(indexPerson).setName(newValue);
                updateLastchange(indexPerson);
                output = true;
                break;

            case 2:
                this.daoPerson.getPerson(indexPerson).setPhone(newValue);
                updateLastchange(indexPerson);
                output = true;
                break;

            case 3:
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                try {
                    Date date = formatter.parse(newValue);
                    this.daoPerson.getPerson(indexPerson).setBirthDay(new Date(newValue));
                    updateLastchange(indexPerson);
                    output = true;
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    output = false;
                }
                break;

            case 4:
                Float grade = Float.parseFloat(newValue);
                Person student = this.daoPerson.getPerson(indexPerson);
                if(student instanceof Student){
                    try {
                        ((Student)student).setFinalGrade(grade);
                        updateLastchange(indexPerson);
                        output = true;
                    }
                    catch (Exception e)
                    {
                        e.getMessage();
                        output = false;
                    }
                }
                break;
        }
        return output;
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