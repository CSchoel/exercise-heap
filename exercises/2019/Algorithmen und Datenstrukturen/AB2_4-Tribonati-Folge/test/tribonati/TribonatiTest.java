package tribonati;

import static org.junit.Assert.*;
import org.junit.Test;

public class TribonatiTest  {


  @Test (timeout = 10000)
  public void t01_tribTest() {
    assertEquals(0, Tribonati.tribDyn(0, new long[1]));
    assertEquals(1, Tribonati.tribDyn(1, new long[2]));
    assertEquals(1, Tribonati.tribDyn(2, new long[3]));
    assertEquals(2, Tribonati.tribDyn(3, new long[4]));
    assertEquals(24, Tribonati.tribDyn(7, new long[8]));
    assertEquals(98950096, Tribonati.tribDyn(32, new long[33]));
  }

  @Test(timeout = 100)
  public void t02_dynamicProgrammingTest() {
    assertEquals(7015254043203144209L,Tribonati.tribDyn(73, new long[74]));
  }

  @Test(timeout=250)
  public void t03_brainSizeTest(){
    assertEquals(98950096, Tribonati.tribDyn(32, new long[1043]));
    assertEquals(2, Tribonati.tribDyn(3, new long[10]));
    try{
    assertNotEquals(3, Tribonati.tribDyn(3, new long[1]));
    fail();
    }
    catch (IndexOutOfBoundsException e ){/* Diese Exception ist erlaubt */}
  }

  @Test(timeout=250)
  public void t04_brainValueTest(){
    long[] testArray = new long[8];
    Tribonati.tribDyn(7,testArray);
    assertEquals(24,testArray[7]);
    assertEquals(13, testArray[6]);
    assertEquals(2, testArray[3]);
    assertEquals(0, testArray[0]);

    testArray = new long[33];
    Tribonati.tribDyn(32,testArray);
    assertEquals(98950096,testArray[32]);
    assertEquals(53798080, testArray[31]);
    assertEquals(3136, testArray[15]);
    assertEquals(0, testArray[0]);
  }

  @Test(timeout=250)
  public void t05_brainValueSizeTest(){
    long[] testArray = new long[1069];
    Tribonati.tribDyn(32,testArray);
    assertEquals(98950096,testArray[32]);
    assertEquals(53798080, testArray[31]);
    assertEquals(3136, testArray[15]);
    assertEquals(0, testArray[0]);
  }



}
