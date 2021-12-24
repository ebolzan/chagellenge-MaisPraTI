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
}
