package hashables;

import de.thm.mni.aud.commons.CodeAnalyser;
import org.junit.Test;
import sourcecodetester.SourceCodeTester;
import sourcecodetester.tests.*;
import sourcecodetester.util.Constructor;
import sourcecodetester.util.Method;

public class SourceCodeTest extends CodeAnalyser {

    @Override
    public void setupTests(SourceCodeTester sct) {

      // CLASS AND METHOD IMPLEMENTATIONS
      sct.createNewTestGroup("Class and Method Implementations", "The following tests are checking for correct class and method implementations.")
        .addTests(
          new ClassImplementations(
            "hashables.Interval",
            "hashables.Tile",
            "hashables.Gene"
          ),
          new ConstructorImplementations(
            new Constructor("hashables.Interval.Interval()")
              .requireVisibilityPublic()
              .requireParameters("double", "double", "boolean", "boolean"),
            new Constructor("hashables.Tile.Tile()")
              .requireVisibilityPublic()
              .requireParameters("Type", "String", "short", "short"),
            new Constructor("hashables.Gene.Gene()")
              .requireVisibilityPublic()
              .requireParameters("String")
          ),
          new MethodImplementations(true,
            new Method("hashables.Interval.hashCode()")
              .requireVisibilityPublic()
              .requireReturnType("int")
              .requireParametersNone(),
            new Method("hashables.Interval.equals()")
              .requireVisibilityPublic()
              .requireReturnType("boolean")
              .requireParameters("Object"),
            new Method("hashables.Interval.toString()")
              .requireVisibilityPublic()
              .requireReturnType("String")
              .requireParametersNone(),
            new Method("hashables.Tile.equals()")
              .requireVisibilityPublic()
              .requireReturnType("boolean")
              .requireParameters("Object"),
            new Method("hashables.Tile.toString()")
              .requireVisibilityPublic()
              .requireReturnType("String")
              .requireParametersNone(),
            new Method("hashables.Tile.hashCode()")
              .requireVisibilityPublic()
              .requireReturnType("int")
              .requireParametersNone(),
            new Method("hashables.Gene.equals()")
              .requireVisibilityPublic()
              .requireReturnType("boolean")
              .requireParameters("Object"),
            new Method("hashables.Gene.complement()")
              .requireVisibilityPrivate()
              .requireReturnType("Gene")
              .requireParametersNone(),
            new Method("hashables.Gene.toString()")
              .requireVisibilityPublic()
              .requireReturnType("String")
              .requireParametersNone(),
            new Method("hashables.Gene.hashCode()")
              .requireVisibilityPublic()
              .requireReturnType("int")
              .requireParametersNone()
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
