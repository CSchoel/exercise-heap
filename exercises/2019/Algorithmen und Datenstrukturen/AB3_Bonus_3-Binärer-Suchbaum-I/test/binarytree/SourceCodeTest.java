package binarytree;

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
          "binarytree.BinaryIntTree",
          "binarytree.BinaryIntTree.BinaryIntTreeNode"
        ),
        new AbstractClassImplementations(
          "binarytree.ABinaryIntTreeNode",
          "binarytree.ABinaryIntTree"
        ),
        new ConstructorImplementations(
          new Constructor("binarytree.BinaryIntTree.BinaryIntTree()")
            .requireVisibilityPublic()
            .requireParametersNone()
        ),
        new ClassExtendsFromClass(
          "binarytree.BinaryIntTree.BinaryIntTreeNode",
          "binarytree.ABinaryIntTreeNode"
        ),
        new ClassExtendsFromClass(
          "binarytree.BinaryIntTree",
          "binarytree.ABinaryIntTree"
        ),
        new MethodImplementations(true,
          new Method("binarytree.ABinaryIntTreeNode.value()")
            .requireVisibilityPublic()
            .requireReturnType("int")
            .requireParametersNone(),
          new Method("binarytree.ABinaryIntTreeNode.left()")
            .requireVisibilityPublic()
            .requireReturnType("ABinaryIntTreeNode")
            .requireParametersNone(),
          new Method("binarytree.ABinaryIntTreeNode.right()")
            .requireVisibilityPublic()
            .requireReturnType("ABinaryIntTreeNode")
            .requireParametersNone(),
          new Method("binarytree.ABinaryIntTree.root()")
            .requireVisibilityPublic()
            .requireReturnType("ABinaryIntTreeNode")
            .requireParametersNone(),
          new Method("binarytree.ABinaryIntTree.add()")
            .requireVisibilityPublic()
            .requireReturnType("void")
            .requireParameters("int"),
          new Method("binarytree.ABinaryIntTree.remove()")
            .requireVisibilityPublic()
            .requireReturnType("void")
            .requireParameters("int"),
          new Method("binarytree.ABinaryIntTree.contains()")
            .requireVisibilityPublic()
            .requireReturnType("boolean")
            .requireParameters("int"),
          new Method("binarytree.ABinaryIntTree.isEmpty()")
            .requireVisibilityPublic()
            .requireReturnType("boolean")
            .requireParametersNone(),
          new Method("binarytree.ABinaryIntTree.size()")
            .requireVisibilityPublic()
            .requireReturnType("int")
            .requireParametersNone(),
          new Method("binarytree.BinaryIntTree.root()")
            .requireVisibilityPublic()
            .requireReturnType("ABinaryIntTreeNode")
            .requireParametersNone(),
          new Method("binarytree.BinaryIntTree.add()")
            .requireVisibilityPublic()
            .requireReturnType("void")
            .requireParameters("int"),
          new Method("binarytree.BinaryIntTree.remove()")
            .requireVisibilityPublic()
            .requireReturnType("void")
            .requireParameters("int"),
          new Method("binarytree.BinaryIntTree.contains()")
            .requireVisibilityPublic()
            .requireReturnType("boolean")
            .requireParameters("int"),
          new Method("binarytree.BinaryIntTree.isEmpty()")
            .requireVisibilityPublic()
            .requireReturnType("boolean")
            .requireParametersNone(),
          new Method("binarytree.BinaryIntTree.size()")
            .requireVisibilityPublic()
            .requireReturnType("int")
            .requireParametersNone(),
          new Method("binarytree.BinaryIntTree.BinaryIntTreeNode.value()")
            .requireVisibilityPublic()
            .requireReturnType("int")
            .requireParametersNone(),
          new Method("binarytree.BinaryIntTree.BinaryIntTreeNode.left()")
            .requireVisibilityPublic()
            .requireReturnType("ABinaryIntTreeNode")
            .requireParametersNone(),
          new Method("binarytree.BinaryIntTree.BinaryIntTreeNode.right()")
            .requireVisibilityPublic()
            .requireReturnType("ABinaryIntTreeNode")
            .requireParametersNone(),
          new Method("binarytree.BinaryIntTree.BinaryIntTreeNode.add()")
            .requireVisibilityPrivate()
            .requireReturnType("boolean")
            .requireParameters("int"),
          new Method("binarytree.BinaryIntTree.BinaryIntTreeNode.contains()")
            .requireVisibilityPrivate()
            .requireReturnType("boolean")
            .requireParameters("int"),
          new Method("binarytree.BinaryIntTree.BinaryIntTreeNode.remove()")
            .requireVisibilityPrivate()
            .requireReturnType("BinaryIntTreeNode")
            .requireParameters("BinaryIntTreeNode", "int"),
          new Method("binarytree.BinaryIntTree.BinaryIntTreeNode.findMinimumValue()")
            .requireVisibilityPrivate()
            .requireReturnType("int")
            .requireParameters("BinaryIntTreeNode")
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
