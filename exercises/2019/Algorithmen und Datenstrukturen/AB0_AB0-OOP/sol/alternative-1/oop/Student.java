package oop;

public class Student extends Person {
  private final int matrikelnr;
  public final int getMatrikelnr() {
    return matrikelnr;
  }

  public Student(String name, String vorname, int alter, int matrikelnr) {
    super(name, vorname, alter);
    this.matrikelnr = matrikelnr;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Student other = (Student) obj;
    return this.getName().equals(other.getName()) &&
        this.getVorname().equals(other.getVorname()) &&
        this.getAlter() == other.getAlter() &&
        this.matrikelnr == other.matrikelnr;
  }
  
  @Override
  public String toString() {
    return String.format("[Student: %s %s %d, %d]", getVorname(), getName(), getAlter(), getMatrikelnr());
  }
  
  @Override
  public int hashCode() {
    return toString().hashCode();
  }
  
}
