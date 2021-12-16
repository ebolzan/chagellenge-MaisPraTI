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

        this.listPerson.forEach(n -> {
            int i = 0;
            System.out.println(i+"---"+n);
            i++;
        });
    }
}
