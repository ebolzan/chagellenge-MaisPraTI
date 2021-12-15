package models;

import java.util.ArrayList;

public class DaoPerson {

    private final ArrayList<Person> listPerson;

    public DaoPerson()
    {
        this.listPerson = new ArrayList<>();
    }

    public Boolean insertPerson(Person p)
    {
       return this.listPerson.add(p);
    }

    public Boolean deletePerson(Person p)
    {
        return this.listPerson.remove(p);
    }

    public void listAllPerson()
    {

        this.listPerson.forEach(n -> {
            int i = 0;
            System.out.println(i+"---"+n);
            i++;
        });
    }
}
