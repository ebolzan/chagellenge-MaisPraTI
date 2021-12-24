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
