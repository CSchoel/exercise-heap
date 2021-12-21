package oop;

import java.util.Objects;

public class Professor extends Person {

    private final String titel;

    public Professor(String name, String vorname, int alter, String titel) {
        super(name, vorname, alter);
        this.titel = titel;
    }

    public String getTitel() {
        return titel;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Professor && o.hashCode() == hashCode();
    }

    @Override
    public int hashCode() {
        return super.hashCode() * titel.hashCode();
    }

    @Override
    public String toString() {
        return super.toString() + " " + titel;
    }

}
