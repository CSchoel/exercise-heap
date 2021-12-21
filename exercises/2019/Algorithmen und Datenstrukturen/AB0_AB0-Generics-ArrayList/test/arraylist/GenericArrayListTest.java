package arraylist;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;



public class GenericArrayListTest {

  @Test
  public void sizeTest() {
    GenericList<Integer> xs = new GenericArrayList<>(5);
    for(int i=5;i<10; i++)
      xs.add(i);

    assertEquals(5, xs.size());
  }

  @Test
  public void sizeTest2() {
	  GenericList<Integer> xs = new GenericArrayList<>(5);
	  assertEquals(0, xs.size());
  }

  @Test
  public void sizeTest3() {
	  GenericList<Integer> xs = new GenericArrayList<>(5);
	  xs.add(2);
	  xs.insert(5,0);
	  assertEquals(2, xs.size());
  }

  @Test
  public void getTest() {
    GenericList<Integer> xs = new GenericArrayList<>(5);
    for(int i=5;i<10; i++)
      xs.add(i);

    for(int i=0; i<5; i++)
      assertEquals(i+5, (int) xs.get(i));
  }

  @Test
  public void increaseCapacityTest() {
    GenericList<Integer> xs = new GenericArrayList<>(5);
    for(int i=0;i<100; i++)
      xs.add(i);

    xs.add(10);
    xs.add(20);
    assertTrue("capacity should get increased", xs.size() >= 99);
    assertEquals(20, (int) xs.get(101));
    assertEquals(10, (int) xs.get(100));
  }

  @Test
  public void removeTest() {
    GenericList<Integer> xs = new GenericArrayList<>(5);
    for(int i=5;i<10; i++)
      xs.add(i);

    xs.remove(4);
    xs.remove(2);
    assertEquals(3, xs.size());
    assertEquals(8, (int) xs.get(2));
    assertEquals(5, (int) xs.get(0));
  }

  @Test
  public void insertTest() {
    GenericList<Integer> xs = new GenericArrayList<>(101);
    for(int i=0;i<100; i++)
      xs.add(i);

    assertEquals(9, (int) xs.get(9));
    xs.insert(20, 9);
    assertEquals(20, (int) xs.get(9));
    for (int i=10; i <101; i++){
        assertEquals(i-1, (int) xs.get(i));
    }

  }

  @Test
  public void addSetTest(){
    GenericList<Integer> xs = new GenericArrayList<>(5);
    xs.add(5);
    xs.add(10);
    xs.add(15);
    xs.add(20);

    xs.set(0,2);

    List<Integer> lAct = List.of(xs.get(0),xs.get(1),xs.get(2),xs.get(3));

    assertEquals(List.of(5,10,0,20),lAct);
  }

}
