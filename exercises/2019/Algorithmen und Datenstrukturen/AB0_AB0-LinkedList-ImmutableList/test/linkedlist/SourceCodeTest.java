package linkedlist;

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
      ImmutableList<Integer> nil = new Nil<>();
    } catch(Throwable t) {
      // prevents any exceptions or errors because the static code tests should do that
    }

    // CLASS AND METHOD IMPLEMENTATIONS
    sct.createNewTestGroup("Class and Method Implementations", "The following tests are checking for correct class and method implementations.")
      .addTests(
        new ClassImplementations(
          "linkedlist.Nil",
          "linkedlist.Cons"
        ), new InterfaceImplementations(
          "linkedlist.ImmutableList"
        ),
        new ConstructorImplementations(
          new Constructor("linkedlist.Cons.Cons()")
            .requireVisibilityPublic()
            .requireParameters("A", "ImmutableList<A>")
        ),
        new ClassImplementsInterfaces("linkedlist.Nil",
          "linkedlist.ImmutableList"),
        new ClassImplementsInterfaces("linkedlist.Cons",
          "linkedlist.ImmutableList"),
        new MethodImplementations(true,
          new Method("linkedlist.Nil.cons()")
            .requireVisibilityPublic()
            .requireReturnType("ImmutableList<A>")
            .requireParameters("A"),
          new Method("linkedlist.Nil.append()")
            .requireVisibilityPublic()
            .requireReturnType("ImmutableList<A>")
            .requireParameters("A"),
          new Method("linkedlist.Nil.size()")
            .requireVisibilityPublic()
            .requireReturnType("int")
            .requireParametersNone(),
          new Method("linkedlist.Nil.getAt()")
            .requireVisibilityPublic()
            .requireReturnType("A")
            .requireParameters("int"),
          new Method("linkedlist.Nil.map()")
            .requireVisibilityPublic()
            .requireReturnType("ImmutableList<B>")
            .requireParameters("Function<A,B>"),
          new Method("linkedlist.Nil.toString()")
            .requireVisibilityPublic()
            .requireReturnType("String")
            .requireParametersNone(),
          new Method("linkedlist.Nil.equals()")
            .requireVisibilityPublic()
            .requireReturnType("boolean")
            .requireParameters("Object"),
          new Method("linkedlist.Nil.hashCode()")
            .requireVisibilityPublic()
            .requireReturnType("int")
            .requireParametersNone(),
          new Method("linkedlist.Cons.cons()")
            .requireVisibilityPublic()
            .requireReturnType("ImmutableList<A>")
            .requireParameters("A"),
          new Method("linkedlist.Cons.append()")
            .requireVisibilityPublic()
            .requireReturnType("ImmutableList<A>")
            .requireParameters("A"),
          new Method("linkedlist.Cons.size()")
            .requireVisibilityPublic()
            .requireReturnType("int")
            .requireParametersNone(),
          new Method("linkedlist.Cons.getAt()")
            .requireVisibilityPublic()
            .requireReturnType("A")
            .requireParameters("int"),
          new Method("linkedlist.Cons.map()")
            .requireVisibilityPublic()
            .requireReturnType("ImmutableList<B>")
            .requireParameters("Function<A,B>"),
          new Method("linkedlist.Cons.toString()")
            .requireVisibilityPublic()
            .requireReturnType("String")
            .requireParametersNone(),
          new Method("linkedlist.Cons.equals()")
            .requireVisibilityPublic()
            .requireReturnType("boolean")
            .requireParameters("Object"),
          new Method("linkedlist.Cons.hashCode()")
            .requireVisibilityPublic()
            .requireReturnType("int")
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
