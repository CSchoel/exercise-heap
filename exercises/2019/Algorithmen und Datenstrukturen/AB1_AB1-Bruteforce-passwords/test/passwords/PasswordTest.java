package passwords;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class PasswordTest  {

  private ArrayList<String> passwords;

  @Before
  public void init() {
    passwords = Passwords.passwords();
  }

  @After
  public void cleanUp() {
    passwords.clear();
    passwords = null;
  }

  @Test
  public void thereAre7454981PasswordsTest() {
    assertEquals("There should be 7454981 passwords in the generated list!", 7454981, passwords.size());
  }

  @Test
  public void passwordsAreUniqueTest() {
    List<String> passwords = new ArrayList<>(this.passwords);
    Collections.sort(passwords);

    String last = null;
    for (final String password : passwords) {
      if (last == null) {
        last = password;
      } else if (last.equals(password)) {
        fail(String.format("Each password should exist exactly once in the generated list! Password '%s' is a duplicate!", password));
      } else {
        last = password;
      }
    }
  }

  @Test
  public void passwordsMatchExpectedShapeTest() {
    final Pattern pattern = Pattern.compile("grunz[a-zA-Z]{0,4}");

    for (final String password : passwords) {
      if (!pattern.matcher(password).matches()) {
        fail(String.format("Password '%s' doesn't match expected shape!", password));
      }
    }
  }



}
