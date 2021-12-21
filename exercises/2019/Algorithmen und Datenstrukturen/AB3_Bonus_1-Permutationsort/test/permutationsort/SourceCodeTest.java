package permutationsort;

import de.thm.mni.aud.commons.CodeAnalyser;
import org.junit.Test;
import sourcecodetester.SourceCodeTester;
import sourcecodetester.tests.*;
import sourcecodetester.util.Method;

public class SourceCodeTest extends CodeAnalyser {
  @Override
  public void setupTests(SourceCodeTester sct) {

    // CLASS AND METHOD IMPLEMENTATIONS
    sct.createNewTestGroup("Class and Method Implementations", "The following tests are checking for correct class and method implementations.")
      .addTests(
        new ClassImplementations(
          "permutationsort.PermutationSort"
        ),
        new MethodImplementations(true,
          new Method("permutationsort.PermutationSort.permutations()")
            .requireVisibilityPublic()
            .requireModifierStatic()
            .requireReturnType("List<List<Integer>>")
            .requireParameters("List<Integer>"),
          new Method("permutationsort.PermutationSort.isSorted()")
            .requireVisibilityPrivate()
            .requireModifierStatic()
            .requireReturnType("boolean")
            .requireParameters("List<Integer>"),
          new Method("permutationsort.PermutationSort.permutationSort()")
            .requireVisibilityPublic()
            .requireModifierStatic()
            .requireReturnType("void")
            .requireParameters("List<Integer>")
        )
      )
    ;

    // CODE QUALITY
    sct.createNewTestGroup("Code Quality", "The following tests are checking the overall quality of your source code. You do not need to pass all of the tests to pass this exercise!")
      .addTests(
        new ClassNamesStartWithCapitalLetter(),
        new MethodNamesStartWithLowerCaseLetter(),
        new VariableNamesStartWithLowerCaseLetter(),
        new ClosingBraceInOwnLine(),
        new OpeningBraceInSameLineWithStatement(),
//				new LineIndentation(8),
//				new LimitStatementAmount(10, false, new Method("package.Class.method()")),
        new LimitCharactersPerLine(150)
      )
    ;

  }

  @Test
  public void implementations() {
    runTests("Class and Method Implementations");
  }

  @Test
  public void codeQuality() {
    runTests("Code Quality");
  }
}
