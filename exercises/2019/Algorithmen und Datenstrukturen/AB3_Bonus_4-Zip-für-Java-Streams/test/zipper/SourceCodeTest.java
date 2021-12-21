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
          "zipper.Tuple",
          "zipper.Zipper"
        ),
        new MethodImplementations(true,
          new Method("zipper.Tuple._1()")
            .requireVisibilityPackage()
            .requireReturnType("A")
            .requireParametersNone(),
          new Method("zipper.Tuple._2()")
            .requireVisibilityPackage()
            .requireReturnType("B")
            .requireParametersNone(),
          new Method("zipper.Tuple.equals()")
            .requireVisibilityPublic()
            .requireReturnType("boolean")
            .requireParameters("Object"),
          new Method("zipper.Tuple.toString()")
            .requireVisibilityPublic()
            .requireReturnType("String")
            .requireParametersNone(),
          new Method("zipper.Zipper.zip()")
            .requireVisibilityPackage()
            .requireModifierStatic()
            .requireReturnType("Stream<Tuple<A,B>>")
            .requireParameters("Stream<A>", "Stream<B>"),
          new Method("zipper.Zipper.hasNext().zip()")
            .requireVisibilityPublic()
            .requireReturnType("boolean")
            .requireParametersNone(),
          new Method("zipper.Zipper.next().zip()")
            .requireVisibilityPublic()
            .requireReturnType("Tuple<A,B>")
            .requireParametersNone(),
          new Method("zipper.Zipper.zip()")
            .requireVisibilityPrivate()
            .requireModifierStatic()
            .requireReturnType("Tuple<A,B>")
            .requireParameters("A", "B"),
          new Method("zipper.Zipper.zipWith()")
            .requireVisibilityPackage()
            .requireModifierStatic()
            .requireReturnType("Stream<C>")
            .requireParameters("Stream<A>", "Stream<B>", "BiFunction<A,B,C>")
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
