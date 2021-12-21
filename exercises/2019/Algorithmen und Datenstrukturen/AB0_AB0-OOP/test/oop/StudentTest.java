package oop;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StudentTest {
  @Test
  public void initStudentTest() {
    Student stud = new Student ("Wagner", "Tim", 28, 445678);
    assertEquals(445678, stud.getMatrikelnr());
  }
  
  @Test
  public void inheritanceTest() {
	  Student stud = new Student ("Wagner", "Tim", 28, 445678);
	  assertTrue("Student should inherit from Person", Person.class.isAssignableFrom(Student.class));
  }
  
  @Test
  public void toStringTest() {
    Student stud = new Student ("Wagner", "Tim", 28, 445678);
    assertTrue("toString should contain the matrikelnr", stud.toString().contains("445678"));
  }
  
  @Test
  public void equalsTest() {
    Student stud = new Student ("Wagner", "Tim", 28, 445678);
    Student stud2 = new Student ("Wagner", "Tim", 28, 445677);
    
    assertNotEquals(stud, stud2);
    assertEquals(stud, stud);
  }
  
  @Test
  public void hashCodeTest() {
    Student stud = new Student ("Wagner", "Tim", 28, 445678);
    Student stud2 = new Student ("Wagner", "Tim", 28, 445677);
    
    assertNotEquals(stud.hashCode(), stud2.hashCode());
    assertEquals(stud.hashCode(), stud.hashCode());
  }
}
