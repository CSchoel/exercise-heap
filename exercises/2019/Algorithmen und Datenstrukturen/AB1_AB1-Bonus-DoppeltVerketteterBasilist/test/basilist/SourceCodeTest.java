package basilist;

import de.thm.mni.aud.commons.CodeAnalyser;
import org.junit.Test;
import sourcecodetester.SourceCodeTester;
import sourcecodetester.tests.*;
import sourcecodetester.util.Method;

public class SourceCodeTest extends CodeAnalyser {

  @Override
  public void setupTests(SourceCodeTester sct) {

    // A reference to the tested implementation is required to successfully compile on Dozentron
    try {
      DoublyLinkedBasilist<Integer> ref = null;
    } catch(Throwable t) {
      // prevents any exceptions or errors because the static code tests should do that
    }

      // CLASS AND METHOD IMPLEMENTATIONS
      sct.createNewTestGroup("Class and Method Implementations", "The following tests are checking for correct class and method implementations.")
        .addTests(
          new ClassImplementations(
            "basilist.DoublyLinkedBasilist",
            "basilist.DoublyLinkedBasilist.List"
          ),
          new InterfaceImplementations(
            "basilist.GenericBasilist"
          ),
          new ClassImplementsInterfaces(
            "basilist.DoublyLinkedBasilist",
            "basilist.GenericBasilist"
          ),
          new MethodImplementations(true,
            new Method("basilist.DoublyLinkedBasilist.List.hashCode()")
              .requireVisibilityPublic()
              .requireReturnType("int")
              .requireParametersNone(),
            new Method("basilist.DoublyLinkedBasilist.List.equals()")
              .requireVisibilityPublic()
              .requireReturnType("boolean")
              .requireParameters("Object"),
            new Method("basilist.DoublyLinkedBasilist.get()")
              .requireVisibilityPublic()
              .requireReturnType("A")
              .requireParameters("int"),
            new Method("basilist.DoublyLinkedBasilist.set()")
              .requireVisibilityPublic()
              .requireReturnType("void")
              .requireParameters("A", "int"),
            new Method("basilist.DoublyLinkedBasilist.size()")
              .requireVisibilityPublic()
              .requireReturnType("int")
              .requireParametersNone(),
            new Method("basilist.DoublyLinkedBasilist.add()")
              .requireVisibilityPublic()
              .requireReturnType("void")
              .requireParameters("A"),
            new Method("basilist.DoublyLinkedBasilist.remove()")
              .requireVisibilityPublic()
              .requireReturnType("void")
              .requireParameters("int"),
            new Method("basilist.DoublyLinkedBasilist.insert()")
              .requireVisibilityPublic()
              .requireReturnType("void")
              .requireParameters("A", "int"),
            new Method("basilist.DoublyLinkedBasilist.hashCode()")
              .requireVisibilityPublic()
              .requireReturnType("int")
              .requireParametersNone(),
            new Method("basilist.DoublyLinkedBasilist.equals()")
              .requireVisibilityPublic()
              .requireReturnType("boolean")
              .requireParameters("Object"),
            new Method("basilist.DoublyLinkedBasilist.toString()")
              .requireVisibilityPublic()
              .requireReturnType("String")
              .requireParametersNone(),
            new Method("basilist.DoublyLinkedBasilist.map()")
              .requireVisibilityPublic()
              .requireReturnType("GenericBasilist<B>")
              .requireParameters("Function<A,B>"),
            new Method("basilist.DoublyLinkedBasilist.reverseMap()")
              .requireVisibilityPublic()
              .requireReturnType("GenericBasilist<B>")
              .requireParameters("Function<A,B>")
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
    public void implementations() {
      runTests("Class and Method Implementations");
    }

    @Test
    public void codeQuality() {
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

