package de.thm.mni.aud.commons;

import org.junit.Assert;

import sourcecodetester.SourceCodeTester;
import sourcecodetester.util.ErrorMessage;
import sourcecodetester.util.TestGroupResult;

import java.io.File;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**<p>A TestSuite for running a 'SourceCodeTester'.</p>
 * <p>
 *    Implement your tests in the 'setupTests' method by adding test groups
 *    and test to the SourceCodeTester object.
 * </p>
 * <p>
 *    Use the method 'runTests(String)' in your @Test methods to run all the
 *    tests of a specific test group. If at least one test failed, a
 *    CodeAnalyserException will be thrown containing the feedback text.
 *    Assertions are thrown when the student jar name is not provided or the
 *    jar file can not be found/accessed.
 * </p>
 * <p>
 *    The student jar name is provided via the system property 'student-jar'.
 * </p>
 */
public abstract class CodeAnalyser {

  private boolean showCodeSnippets = true;
  private boolean isDevelopment = false;

  private String jarPath;
  private SourceCodeTester sct = null;
  private Map<String, TestGroupResult> results = null;

  /**
   * Using this constructor, the path/name to the jar file will be obtain
   * through the 'student-jar' (or 'user.dir') property.
   */
  public CodeAnalyser() {
    jarPath = System.getProperty("student-jar");
    String devMode = System.getProperty("code-analyzer-development-mode");
    if ("true".equals(devMode)) {
      isDevelopment = true;
      String devMsg = "[INFO]: static code analyser runs in DEVELOPMENT mode!";
      System.out.println(devMsg);
    }

    if (jarPath == null) {
      jarPath = System.getProperty("user.dir") + File.separator + "src";
      String msg = "[INFO]: manually setting student-jar property for static"
                 + " code analyser to: ";
      System.out.println(msg+jarPath);
    }
  }

  /**
   * Using this constructor, the path/name to the jar file can be set manually.
   */
  public CodeAnalyser(String jarPath) {
    this.jarPath = jarPath;
  }


  /**
   * The tests and test groups are supposed to be added to the provided
   * SourceCodeTester object.
   * The names of the test groups should be unique.
   */
  public abstract void setupTests(SourceCodeTester sct);


  /**
   * <p>Runs the tests of the test group with the provided name.</p>
   * <p>
   *    Throws a CodeAnalyserException exception, if at least one of the tests
   *    were not passed.
   * </p>
   * <p>
   *    Returns a fully formated feedback String as the exception message text.
   * </p>
   * @param testGroupName The name of the test group which tests should be run.
   * @exception CodeAnalyserException Thrown when tests of this test group
   *    were not passed. The exception message is the formated feedback String.
   */
  public void runTests(String testGroupName) throws CodeAnalyserException {
    checkPreRequirements();
    
    // setup tests
    if (sct == null) {
      sct = new SourceCodeTester(isDevelopment);
      setupTests(sct);
    }
  	
    ErrorMessage.extractCodeSnippets = showCodeSnippets;
    
    // run tests
    if (results == null) {
      results = runAllTests();
    }
    
    // throw exception and return feedback text if at least one test failed.
    if (results.containsKey(testGroupName)) {
      TestGroupResult testGroupResult = results.get(testGroupName);
      if (testGroupResult.getFailedTests().size() > 0) {
        throw new CodeAnalyserException(
          "TRIM START"
          + testGroupResult.transformToString(showCodeSnippets)
          + "TRIM END"
        );
      }
    } else {
      String msg = "The testgroup with name '"
                 + testGroupName
                 + "' does not exist! If you are a student and reading this,"
                 + " please notify your teacher about it.";
      Assert.fail(msg);
    }

  }

  /**
   * <p>Runs the tests of the test group with the provided name.</p>
   * <p>
   *    Always throws a CodeAnalyserJSONException exception, even if all tests
   *    were passed.
   * </p>
   * <p>
   *    Returns a JSON String as the exception message text.
   * </p>
   * @param testGroupName The name of the test group which tests should be run.
   * @exception CodeAnalyserJSONException Always thrown, no matter the tests'
   *    outcome. The error message is the json String providing all the details
   *    available.
   */
  public void runTestsJSON(String testGroupName)
      throws CodeAnalyserJSONException {
    checkPreRequirements();
    
    // setup tests
    if (sct == null) {
      sct = new SourceCodeTester(isDevelopment);
      setupTests(sct);
    }
  	
    ErrorMessage.extractCodeSnippets = showCodeSnippets;
    
    // run tests
    if (results == null) {
      results = runAllTests();
    }
    
    // throw exception and return json text
    if (results.containsKey(testGroupName)) {
      TestGroupResult testGroupResult = results.get(testGroupName);
      if (isDevelopment) {
        if (testGroupResult.getFailedTests().size() > 0) {
          String msg = testGroupResult.transformToString(showCodeSnippets);
          // only thrown in development when tests failed
          throw new CodeAnalyserJSONException(msg);
        }
      } else {
        String msg = "TRIM START"
                   + testGroupResult.transformToJsonString()
                   + "TRIM END";
        // always thrown in production
        throw new CodeAnalyserJSONException(msg);
      }
    } else {
      String msg = "The testgroup with name '"
                 + testGroupName
                 + "' does not exist! If you are a student and reading this,"
                 + " please notify your teacher about it.";
      Assert.fail(msg);
    }

  }

  /**
   * Checks basic jar file requirements.
   */
  private void checkPreRequirements() {
    String msg = "Path/name to the student jar file must be set as"
               + " 'student-jar' property!";
    Assert.assertNotNull(msg, jarPath);
    Path p = Paths.get(jarPath);
    msg = String.format(
      "The jar '%s' doesn't exist or isn't readable!",
      jarPath
    );
    Assert.assertTrue(msg, Files.exists(p) && Files.isReadable(p));
  }

  /**
   * Runs all the tests and saves the results of the test groups for later
   * access.
   * @return The Map with the results of the static code analysis.
   */
  private Map<String, TestGroupResult> runAllTests() {
    ArrayList<TestGroupResult> testGroupResults = sct.runTestsObjects(jarPath);
    HashMap<String, TestGroupResult> results = new HashMap<>();

    for (TestGroupResult testGroupResult : testGroupResults) {
      // save test group result by test group name
      results.put(testGroupResult.getTestGroup().getName(), testGroupResult);
    }

    return results;
  }

}
