package hillclimbing;

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
      Hillclimber ref = null;
    } catch (Throwable t) {
      // prevents any exceptions or errors because the static code tests should do that
    }


      // CLASS AND METHOD IMPLEMENTATIONS
      sct.createNewTestGroup("Class and Method Implementations", "The following tests are checking for correct class and method implementations.")
        .addTests(
          new ClassImplementations(
            "hillclimbing.Hillclimber",
            "hillclimbing.Coordinate",
            "hillclimbing.ClimbListener"
          ),
          new ConstructorImplementations(
            new Constructor("hillclimbing.Hillclimber.Hillclimber()")
              .requireVisibilityPublic()
              .requireParameters("int[][]"),
            new Constructor("hillclimbing.Coordinate.Coordinate()")
              .requireVisibilityPublic()
              .requireParameters("int", "int")
          ),
          new MethodImplementations(true,
            new Method("hillclimbing.Hillclimber.climb()")
              .requireVisibilityPublic()
              .requireReturnType("Coordinate")
              .requireParameters("Coordinate", "ClimbListener"),
            new Method("hillclimbing.Coordinate.equals()")
              .requireVisibilityPublic()
              .requireReturnType("boolean")
              .requireParameters("Object"),
            new Method("hillclimbing.Coordinate.hashCode()")
              .requireVisibilityPublic()
              .requireReturnType("int")
              .requireParametersNone(),
            new Method("hillclimbing.Coordinate.toString()")
              .requireVisibilityPublic()
              .requireReturnType("String")
              .requireParametersNone(),
            new Method("hillclimbing.ClimbListener.getPath()")
              .requireVisibilityPublic()
              .requireReturnType("List<Coordinate>")
              .requireParametersNone(),
            new Method("hillclimbing.ClimbListener.climbCallback()")
              .requireVisibilityPublic()
              .requireReturnType("void")
              .requireParameters("Coordinate")
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
//				new LimitStatementAmount(10, false, new Method("package.Class.method()")),
          new LimitCharactersPerLine(150)
        )
      ;

//		// FUNCTIONALITY
//		sct.createNewTestGroup("Functionality", "The following tests are checking specific code functionalities.")
//			.addTests(
//				new MethodRecursiveImplementations(
//					new Method("my.package.MyClass.myRecursiveMethod()")
//				),
//					new MethodCallUsedInMethods(
//					new Method("methodA()"),
//					new Method("methodZ()")
//				)
//			)
//		;

//		// LIMITATIONS
//		sct.createNewTestGroup("Limitations", "The following tests limit the usage of specific classes and method calls.")
//			.addTests(
//				new BlacklistClasses(
//					java.util.Collections.class.getName(),
//					java.util.ArrayList.class.getName()
//				),
//				new WhitelistClasses(
//					java.util.Collection.class.getName(),
//					java.util.Collections.class.getName()
//				),
//				new BlacklistMethods(
//					new Method("java.lang.Math.random()"),
//					new Method("java.lang.Math.max()"),
//					new Method("java.lang.Math.min()"),
//					new Method("java.util.Collections.max()"),
//					new Method("java.util.Collections.min()")
//				)
//			)
//		;

//		// JAVA DOCUMENTATION
//		sct.createNewTestGroup("Java Documentation", "The following tests are checking for Java Documentation.")
//			.addTests(
//				new JavadocAllMethods(),
//				new JavadocSpecificMethods(
//					new Method("myMethod"),
//					new Method("my.package.MyClass.myMethod", Visibility.PACKAGE, "void", new Parameter("boolean", "isTrue"))
//				),
//				new JavadocPublicMethods(false, false, false)
//			)
//		;

    }

    @Test
    public void implementations () {
      runTests("Class and Method Implementations");
    }

    @Test
    public void codeQuality () {
      runTests("Code Quality");
    }

//	@Test
//	public void functionality() {
//		runTests("Functionality");
//	}

//	@Test
//	public void limitations() {
//		runTests("Limitations");
//	}

//	@Test
//	public void javaDocumentation() {
//		runTests("Java Documentation");
//	}
  }
