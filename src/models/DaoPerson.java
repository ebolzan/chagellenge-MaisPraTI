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

    public Person deletePerson(int index)
    {
        return this.listPerson.remove(index);
    }

    public Person getPerson(int index)
    {
            return this.listPerson.get(index);
    }

    public void listAllPerson()
    {
        if(this.listPerson.isEmpty())
        {
            System.out.println("D'ont exists nothing person's save in database");
            return;
        }

        int it = 0;
        for(Person p: this.listPerson)
        {
            System.out.println(it+"--"+p);
            it++;
        }
    }
}