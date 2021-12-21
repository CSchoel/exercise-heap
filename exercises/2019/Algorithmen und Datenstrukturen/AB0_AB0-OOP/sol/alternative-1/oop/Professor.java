package oop;

public class Professor extends Person {
  private final String titel;
  public final String getTitel() {
    return titel;
  }

  public Professor(String name, String vorname, int alter, String titel) {
    super(name, vorname, alter);
    this.titel = titel;
  }
  
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Professor other = (Professor) obj;
    return this.getName().equals(other.getName()) &&
        this.getVorname().equals(other.getVorname()) &&
        this.getAlter() == other.getAlter() &&
        this.titel.equals(other.titel);
  }
  
  @Override
  public String toString() {
    return String.format("[Professor: %s %s %s %d]", getTitel(), getVorname(), getName(), getAlter());
  }

  @Override
  public int hashCode() {
    return toString().hashCode();
  }
}
