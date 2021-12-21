package oop;

import static org.junit.Assert.*;
import org.junit.Test;

public class ProfessorTest {
  @Test
  public void initProfessorTest() {
    Professor prof = new Professor("Schölzel", "Christopher", 28, "M.Sc.");
    assertEquals("M.Sc.", prof.getTitel());
  }
  
  @Test
  public void inheritanceTest() {
	  assertTrue("Professor should inherit from Person", Person.class.isAssignableFrom(Professor.class));
  }
  
  @Test
  public void toStringTest() {
    Professor prof = new Professor("Schölzel", "Christopher", 28, "M.Sc.");
    assertTrue("toString should contain the title", prof.toString().contains("M.Sc."));
  }
  
  @Test
  public void equalsTest() {
    Professor prof = new Professor("Schölzel", "Christopher", 28, "M.Sc.");
    Professor prof2 = new Professor("Schölzel", "Christopher", 28, "B.Sc.");
    
    assertNotEquals(prof, prof2);
    assertEquals(prof, prof);
  }
  
  @Test
  public void hashCodeTest() {
    Professor prof = new Professor("Schölzel", "Christopher", 28, "M.Sc.");
    Person person = new Person("Schölzel", "Christopher", 28);
    
    assertNotEquals(prof.hashCode(), person.hashCode());
  }
}
