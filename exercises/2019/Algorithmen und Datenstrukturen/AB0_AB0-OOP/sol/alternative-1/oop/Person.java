package oop;

public class Person implements Comparable<Person> {
  public final String getName() {
    return name;
  }

  public final String getVorname() {
    return vorname;
  }

  public final int getAlter() {
    return alter;
  }

  private final String name;
  private final String vorname;
  private final int alter;
  
  public Person(String name, String vorname, int alter) {
    this.name = name;
    this.vorname = vorname;
    this.alter = alter;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Person other = (Person) obj;
    return this.name.equals(other.name) &&
        this.vorname.equals(other.vorname) &&
        this.alter == other.alter;
  }
  
  @Override
  public String toString() {
    return String.format("[Person: %s %s %d]", vorname, name, alter);
  }
  
  @Override
  public int hashCode() {
    return toString().hashCode();
  }

  @Override
  public int compareTo(Person other) {
    return this.alter - other.alter;
  }
}
