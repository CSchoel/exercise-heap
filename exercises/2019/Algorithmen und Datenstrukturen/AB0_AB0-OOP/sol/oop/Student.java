package oop;

public class Student extends Person {

    private final int matrikelnummer;

    public Student(String name, String vorname, int alter, int matrikelnummer) {
        super(name, vorname, alter);
        this.matrikelnummer = matrikelnummer;
    }

    public int getMatrikelnr() {
        return matrikelnummer;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Student && o.hashCode() == hashCode();
    }

    @Override
    public int hashCode() {
        return super.hashCode() * matrikelnummer;
    }

    @Override
    public String toString() {
        return super.toString() + " " + matrikelnummer;
    }

}
