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
          "binarytree.BinaryTree",
          "binarytree.BinaryTree.BinaryTreeNode"
        ),
        new AbstractClassImplementations(
          "binarytree.ABinaryTreeNode",
          "binarytree.ABinaryTree"
        ),
        new ConstructorImplementations(
          new Constructor("binarytree.BinaryTree.BinaryTree()")
            .requireVisibilityPublic()
            .requireParameters("Comparator<T>"),
          new Constructor("binarytree.ABinaryTree.ABinaryTree()")
            .requireVisibilityPublic()
            .requireParameters("Comparator<T>")
        ),
        new ClassExtendsFromClass(
          "binarytree.BinaryTree",
          "binarytree.ABinaryTree"
        ),
        new ClassExtendsFromClass(
          "binarytree.BinaryTree.BinaryTreeNode",
          "binarytree.ABinaryTreeNode"
        ),
        new MethodImplementations(true,
          new Method("binarytree.ABinaryTreeNode.value()")
            .requireVisibilityPublic()
            .requireReturnType("T")
            .requireParametersNone(),
          new Method("binarytree.ABinaryTreeNode.left()")
            .requireVisibilityPublic()
            .requireReturnType("ABinaryTreeNode<T>")
            .requireParametersNone(),
          new Method("binarytree.ABinaryTreeNode.right()")
            .requireVisibilityPublic()
            .requireReturnType("ABinaryTreeNode<T>")
            .requireParametersNone(),
          new Method("binarytree.BinaryTree.root()")
            .requireVisibilityPublic()
            .requireReturnType("ABinaryTreeNode<T>")
            .requireParametersNone(),
          new Method("binarytree.BinaryTree.add()")
            .requireVisibilityPublic()
            .requireReturnType("void")
            .requireParameters("T"),
          new Method("binarytree.BinaryTree.remove()")
            .requireVisibilityPublic()
            .requireReturnType("void")
            .requireParameters("T"),
          new Method("binarytree.BinaryTree.contains()")
            .requireVisibilityPublic()
            .requireReturnType("boolean")
            .requireParameters("T"),
          new Method("binarytree.BinaryTree.isEmpty()")
            .requireVisibilityPublic()
            .requireReturnType("boolean")
            .requireParametersNone(),
          new Method("binarytree.BinaryTree.size()")
            .requireVisibilityPublic()
            .requireReturnType("int")
            .requireParametersNone(),
          new Method("binarytree.BinaryTree.BinaryTreeNode.value()")
            .requireVisibilityPublic()
            .requireReturnType("T")
            .requireParametersNone(),
          new Method("binarytree.BinaryTree.BinaryTreeNode.left()")
            .requireVisibilityPublic()
            .requireReturnType("ABinaryTreeNode<T>")
            .requireParametersNone(),
          new Method("binarytree.BinaryTree.BinaryTreeNode.right()")
            .requireVisibilityPublic()
            .requireReturnType("ABinaryTreeNode<T>")
            .requireParametersNone(),
          new Method("binarytree.BinaryTree.BinaryTreeNode.add()")
            .requireVisibilityPrivate()
            .requireReturnType("boolean")
            .requireParameters("T"),
          new Method("binarytree.BinaryTree.BinaryTreeNode.contains()")
            .requireVisibilityPrivate()
            .requireReturnType("boolean")
            .requireParameters("T"),
          new Method("binarytree.BinaryTree.BinaryTreeNode.remove()")
            .requireVisibilityPrivate()
            .requireReturnType("BinaryTreeNode")
            .requireParameters("BinaryTreeNode", "T"),
          new Method("binarytree.BinaryTree.BinaryTreeNode.findMinimumValue()")
            .requireVisibilityPrivate()
            .requireReturnType("T")
            .requireParameters("BinaryTreeNode"),
          new Method("binarytree.ABinaryTree.root()")
            .requireVisibilityPublic()
            .requireReturnType("ABinaryTreeNode<T>")
            .requireParametersNone(),
          new Method("binarytree.ABinaryTree.add()")
            .requireVisibilityPublic()
            .requireReturnType("void")
            .requireParameters("T"),
          new Method("binarytree.ABinaryTree.remove()")
            .requireVisibilityPublic()
            .requireReturnType("void")
            .requireParameters("T"),
          new Method("binarytree.ABinaryTree.contains()")
            .requireVisibilityPublic()
            .requireReturnType("boolean")
            .requireParameters("T"),
          new Method("binarytree.ABinaryTree.isEmpty()")
            .requireVisibilityPublic()
            .requireReturnType("boolean")
            .requireParametersNone(),
          new Method("binarytree.ABinaryTree.size()")
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
