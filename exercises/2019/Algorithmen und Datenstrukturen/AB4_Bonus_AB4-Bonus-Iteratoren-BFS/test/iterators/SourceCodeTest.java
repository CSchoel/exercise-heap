package iterators;

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
          "iterators.BFSIterator",
          "iterators.IteratorTest",
          "iterators.Tree"
        ),
        new InterfaceImplementations(
          "iterators.TreeInterface"
        ),
        new ConstructorImplementations(
          new Constructor("iterators.BFSIterator.BFSIterator()")
            .requireVisibilityPublic()
            .requireParameters("TreeInterface<E>"),
          new Constructor("iterators.Tree.Tree()")
            .requireVisibilityPublic()
            .requireParameters("E")
        ),
        new ClassImplementsInterfaces(
          "iterators.BFSIterator",
          "java.util.Iterator"
        ),
        new ClassImplementsInterfaces(
          "iterators.Tree",
          "iterators.TreeInterface"
        ),
        new ClassExtendsFromClass(
          "iterators.TreeInterface",
          "java.lang.Iterable"
        ),
        new MethodImplementations(true,
          new Method("iterators.TreeInterface.getContent()")
            .requireVisibilityPublic()
            .requireReturnType("E")
            .requireParametersNone(),
          new Method("iterators.TreeInterface.getChildren()")
            .requireVisibilityPublic()
            .requireReturnType("List<TreeInterface<E>>")
            .requireParametersNone(),
          new Method("iterators.TreeInterface.addChild()")
            .requireVisibilityPublic()
            .requireReturnType("void")
            .requireParameters("TreeInterface<E>"),
          new Method("iterators.TreeInterface.addChild()")
            .requireVisibilityPublic()
            .requireReturnType("TreeInterface<E>")
            .requireParameters("E"),
          new Method("iterators.BFSIterator.hasNext()")
            .requireVisibilityPublic()
            .requireReturnType("boolean")
            .requireParametersNone(),
          new Method("iterators.BFSIterator.next()")
            .requireVisibilityPublic()
            .requireReturnType("E")
            .requireParametersNone(),
          new Method("iterators.IteratorTest.main()")
            .requireVisibilityPublic()
            .requireModifierStatic()
            .requireReturnType("void")
            .requireParameters("String[]"),
          new Method("iterators.Tree.getContent()")
            .requireVisibilityPublic()
            .requireReturnType("E")
            .requireParametersNone(),
          new Method("iterators.Tree.getChildren()")
            .requireVisibilityPublic()
            .requireReturnType("List<TreeInterface<E>>")
            .requireParametersNone(),
          new Method("iterators.Tree.addChild()")
            .requireVisibilityPublic()
            .requireReturnType("void")
            .requireParameters("TreeInterface<E>"),
          new Method("iterators.Tree.addChild()")
            .requireVisibilityPublic()
            .requireReturnType("TreeInterface<E>")
            .requireParameters("E"),
          new Method("iterators.Tree.iterator()")
            .requireVisibilityPublic()
            .requireReturnType("Iterator<E>")
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
