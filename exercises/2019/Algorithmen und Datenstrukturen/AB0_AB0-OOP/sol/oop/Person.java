package oop;

import java.util.Objects;

public class Person implements Comparable<Person> {

    private final String name, vorname;
    private final int alter;

    public Person(String name, String vorname, int alter) {
        this.name = name;
        this.vorname = vorname;
        this.alter = alter;
    }

    public String getName() {
        return name;
    }

    public String getVorname() {
        return vorname;
    }

    public int getAlter() {
        return alter;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Person && o.hashCode() == hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name) * Objects.hashCode(vorname) * alter;
    }

    @Override
    public int compareTo(Person o) {
        return equals(o) ? 0 : alter - o.alter;
    }

    @Override
    public String toString() {
        return vorname + " " + name + " ist " + alter;
    }

}
