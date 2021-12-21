package hangman;

import de.thm.mni.aud.commons.CodeAnalyser;
import org.junit.Test;
import sourcecodetester.SourceCodeTester;
import sourcecodetester.tests.*;
import sourcecodetester.util.Constructor;
import sourcecodetester.util.Method;

public class SourceCodeTest extends CodeAnalyser {

  @Override
  public void setupTests(SourceCodeTester sct) {

    // A reference to the tested implementation is required to successfully compile on Dozentron
    try {
      new Hangman("Hello World", 15);
    } catch(Throwable t) {
      // prevents any exceptions or errors because the static code tests should do that
    }

    // CLASS AND METHOD IMPLEMENTATIONS
    sct.createNewTestGroup("Class and Method Implementations", "The following tests are checking for correct class and method implementations.")
      .addTests(
        new ClassImplementations(
          "hangman.Hangman"
        ),
        new ConstructorImplementations(
          new Constructor("hangman.Hangman.Hangman()")
            .requireVisibilityPublic()
            .requireParameters("String", "int")
        ),
        new MethodImplementations(true,
          new Method("hangman.Hangman.getWord()")
            .requireVisibilityPublic()
            .requireReturnType("String")
            .requireParametersNone(),
          new Method("hangman.Hangman.isPossibleToLose()")
            .requireVisibilityPublic()
            .requireReturnType("boolean")
            .requireParametersNone(),
          new Method("hangman.Hangman.getLineCount()")
            .requireVisibilityPublic()
            .requireReturnType("int")
            .requireParametersNone(),
          new Method("hangman.Hangman.playRandomly()")
            .requireVisibilityPublic()
            .requireReturnType("char")
            .requireParametersNone(),
          new Method("hangman.Hangman.isWin()")
            .requireVisibilityPublic()
            .requireReturnType("boolean")
            .requireParametersNone(),
          new Method("hangman.Hangman.playStrategically()")
            .requireVisibilityPublic()
            .requireReturnType("char")
            .requireParametersNone()
          )
      )
    ;

    // CODE QUALITY
    sct.createNewTestGroup("Code Quality", "The following tests are checking the overall quality of your source code.")
      .addTests(
        new ClassNamesStartWithCapitalLetter(),
        new MethodNamesStartWithLowerCaseLetter(),
        new VariableNamesStartWithLowerCaseLetter(),
        new ClosingBraceInOwnLine(),
        new OpeningBraceInSameLineWithStatement(),
        new LineIndentation(8),
        new LimitCharactersPerLine(150)
      );
  }

  @Test
  public void implementations() { runTests("Class and Method Implementations");
  }

  @Test
  public void codeQuality() {
    runTests("Code Quality");
  }
}
