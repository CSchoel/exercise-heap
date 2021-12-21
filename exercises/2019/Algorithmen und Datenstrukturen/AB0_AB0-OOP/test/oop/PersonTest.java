package oop;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class PersonTest {
  @Test
  public void propertiesTest() {
    Person p = new Person("Meier", "Hans", 42);
    Field[] fields = p.getClass().getDeclaredFields();
    for(Field field : fields) {
      int mod = field.getModifiers();
      assertTrue("All properties should be 'private final'", Modifier.isFinal(mod) && Modifier.isPrivate(mod));
    }
  }

  @Test
  public void initPerson() {
    Person[] persons = new Person[] {
        new Person("Meier", "Hans", 42),
        new Person("Peter", "Jessy", 24),
        new Person("Wagner", "Tim", 45)
    };
    assertEquals("Meier", persons[0].getName());
    assertEquals("Hans", persons[0].getVorname());
    assertEquals(42, persons[0].getAlter());
    
    assertEquals("Peter", persons[1].getName());
    assertEquals("Jessy", persons[1].getVorname());
    assertEquals(24, persons[1].getAlter());
    
    assertEquals("Wagner", persons[2].getName());
    assertEquals("Tim", persons[2].getVorname());
    assertEquals(45, persons[2].getAlter());
  }
  
  @Test
  public void equalsTest() {
    Person p1 = new Person("Meier", "Hans", 42);
    Person p1Copy = new Person("Meier", "Hans", 42);
    Person p2 = new Person("Peter", "Jessy", 24);
    Person p3 = new Person("Meier", "Hans", 43);

    assertEquals(p1, p1Copy);
    assertNotEquals(p1, null);
    assertNotEquals(p1, p2);
    assertNotEquals(p1, p3);
  }
  
  @Test
  public void hashCodeTest() {
    Person p1 = new Person("Meier", "Hans", 42);
    Person p1Copy = new Person("Meier", "Hans", 42);
    Person p2 = new Person("Peter", "Jessy", 24);
    Person p3 = new Person("Meier", "Hans", 43);

    assertEquals(p1.hashCode(), p1Copy.hashCode());
    assertNotEquals(p1.hashCode(), p2.hashCode());
  }
  
  @Test
  public void toStringTest() {
    Person p1 = new Person("Meier", "Hans", 42);
    Person p2 = new Person("Meier", "Hans", 42);
    assertTrue("toString() should contain the lastname", p1.toString().contains("Meier"));
    assertTrue("toString() should contain the surname", p1.toString().contains("Hans"));
    assertTrue("toString() should contain the age", p1.toString().contains("42"));
    assertFalse("Should not contain 'Jessy'", p1.toString().contains("Jessy"));
    
    assertEquals(p1.toString(), p2.toString());
  }
  
  @Test
  public void compareToTest() {
    Person p1 = new Person("Meier", "Hans", 42);
    Person p2 = new Person("Meier", "Hans", 43);
    assertTrue("Persons should be compared by their age", 0 > p1.compareTo(p2));
    assertTrue("Persons should be compared by their age", 0 < p2.compareTo(p1));
    assertTrue("Persons should be compared by their age", 0 == p1.compareTo(p1));
  }
}
