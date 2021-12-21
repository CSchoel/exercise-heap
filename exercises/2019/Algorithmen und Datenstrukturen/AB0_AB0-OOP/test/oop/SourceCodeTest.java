package oop;

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
      new Student("Testwalker", "Luke", 42, 1337);
    } catch(Throwable t) {
      // prevents any exceptions or errors because the static code tests should do that
    }

    // CLASS AND METHOD IMPLEMENTATIONS
    sct.createNewTestGroup("Class and Method Implementations", "The following tests are checking for correct class and method implementations.")
      .addTests(
        new ClassImplementations(
          "oop.Student",
          "oop.Professor",
          "oop.Person"
        ),
        new ConstructorImplementations(
          new Constructor("oop.Student.Student()")
            .requireVisibilityPublic()
            .requireParameters("String", "String", "int", "int"),
          new Constructor("oop.Professor.Professor()")
            .requireVisibilityPublic()
            .requireParameters("String", "String", "int", "String"),
          new Constructor("oop.Person.Person()")
            .requireVisibilityPublic()
            .requireParameters("String", "String", "int")
        ),
        new ClassImplementsInterfaces(
          "oop.Person",
          "java.lang.Comparable"
        ),
        new ClassExtendsFromClass(
          "oop.Student",
          "oop.Person"
        ),
        new ClassExtendsFromClass(
          "oop.Professor",
          "oop.Person"
        ),
        new MethodImplementations(true,
          new Method("oop.Student.getMatrikelnr()")
            .requireVisibilityPublic()
            .requireReturnType("int")
            .requireParametersNone(),
          new Method("oop.Student.equals()")
            .requireVisibilityPublic()
            .requireReturnType("boolean")
            .requireParameters("Object"),
          new Method("oop.Student.toString()")
            .requireVisibilityPublic()
            .requireReturnType("String")
            .requireParametersNone(),
          new Method("oop.Student.hashCode()")
            .requireVisibilityPublic()
            .requireReturnType("int")
            .requireParametersNone(),
          new Method("oop.Professor.getTitel()")
            .requireVisibilityPublic()
            .requireReturnType("String")
            .requireParametersNone(),
          new Method("oop.Professor.equals()")
            .requireVisibilityPublic()
            .requireReturnType("boolean")
            .requireParameters("Object"),
          new Method("oop.Professor.toString()")
            .requireVisibilityPublic()
            .requireReturnType("String")
            .requireParametersNone(),
          new Method("oop.Professor.hashCode()")
            .requireVisibilityPublic()
            .requireReturnType("int")
            .requireParametersNone(),
          new Method("oop.Person.getName()")
            .requireVisibilityPublic()
            .requireReturnType("String")
            .requireParametersNone(),
          new Method("oop.Person.getVorname()")
            .requireVisibilityPublic()
            .requireReturnType("String")
            .requireParametersNone(),
          new Method("oop.Person.getAlter()")
            .requireVisibilityPublic()
            .requireReturnType("int")
            .requireParametersNone(),
          new Method("oop.Person.equals()")
            .requireVisibilityPublic()
            .requireReturnType("boolean")
            .requireParameters("Object"),
          new Method("oop.Person.toString()")
            .requireVisibilityPublic()
            .requireReturnType("String")
            .requireParametersNone(),
          new Method("oop.Person.hashCode()")
            .requireVisibilityPublic()
            .requireReturnType("int")
            .requireParametersNone(),
          new Method("oop.Person.compareTo()")
            .requireVisibilityPublic()
            .requireReturnType("int")
            .requireParameters("Person")
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
        //new LineIndentation(8),
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
