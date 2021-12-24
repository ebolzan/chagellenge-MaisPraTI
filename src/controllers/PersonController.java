package controllers;

import models.DaoPerson;
import views.TerminalView;

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
