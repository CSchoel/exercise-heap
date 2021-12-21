package morsecode;

import de.thm.mni.aud.commons.AbstractFileIOTest;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class MorseCodeTest extends AbstractFileIOTest {

  public MorseCodeTest(){
    super("morse-code.txt");
  }

  @Test
  public void encodeTest() {
    final String TEST_INPUT1 = "The quick brown fox jumps over the lazy dog 0987654321-.,";
    final String TEST_OUTPUT1 = "-..... --.-..-..-.-.-.- -....-.---.---. ..-.----..- .---..---.--.... ---...-..-. -..... .-...---..-.-- -..-----. ---------.---..--...-.............-...--..---.-----....-.-.-.---..--";
    assertEquals(TEST_OUTPUT1, MorseCode.encode(TEST_INPUT1));
  }

  @Test
  public void exceptionTest(){
    PrintStream oldStream = System.err;
    StringBuilder builder = new StringBuilder();
    try {
      PrintStream newStream = new PrintStream(new OutputStream() {
        @Override
        public void write(int b) throws IOException {
          builder.append((char)b);
        }
      });
      System.setErr(newStream);

      final String TEST_INPUT1 = " ";
      MorseCode.encode(TEST_INPUT1);

      assertFalse(builder.toString(),builder.length()>0);
      System.setErr(oldStream);

    }catch (Exception | AssertionError e){
      System.setErr(oldStream);
      fail(e.getMessage());
    }
  }

  @Test
  public void encodeFailTest() {
    final String TEST_INPUT2 = "The quick brown fox jumps over the lazy dog 0987654321-.,";
    final String TEST_OUTPUT2 = "-..... --.-..-.-.-.-.- -....-.---.---. ..-.----..- .---..---.--.... ---...-..-. -..... .-...---..-.-- -..-----. ---------.---..--...-.............-...--..---.-----....-.-.-.---..--";
    assertNotEquals(TEST_OUTPUT2, MorseCode.encode(TEST_INPUT2));
  }

  @Test
  public void emptyTest() {
    assertEquals("", MorseCode.encode(""));
  }

  @Test
  public void dictTest(){
    assertNotNull(MorseCode.getDictionary("morse-code.txt"));
  }


}
