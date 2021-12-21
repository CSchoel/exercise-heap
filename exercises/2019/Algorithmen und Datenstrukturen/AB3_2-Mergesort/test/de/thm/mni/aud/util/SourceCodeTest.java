package de.thm.mni.aud.util;

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
          "de.thm.mni.aud.util.MergeSortAdapter",
          "de.thm.mni.aud.util.DoublyLinkedList",
          "de.thm.mni.aud.util.DoublyLinkedList.DoublyLinkedNode",
          "de.thm.mni.aud.util.DLLInvariantException",
          "de.thm.mni.aud.util.MergeSortVisualizer",
          "de.thm.mni.aud.SortableDLL"
        ),
        new InterfaceImplementations(
          "de.thm.mni.aud.util.MergeSortListener"
        ),
        new ConstructorImplementations(
          new Constructor("de.thm.mni.aud.util.DoublyLinkedList.DoublyLinkedNode.DoublyLinkedNode()")
            .requireVisibilityPublic()
            .requireParameters("E"),
          new Constructor("de.thm.mni.aud.util.DLLInvariantException.DLLInvariantException()")
            .requireVisibilityPublic()
            .requireParameters("String", "String", "List<String>")
        ),
        new ClassImplementsInterfaces(
          "de.thm.mni.aud.util.MergeSortAdapter",
          "de.thm.mni.aud.util.MergeSortListener"
        ),
        new ClassImplementsInterfaces(
          "de.thm.mni.aud.util.DoublyLinkedList",
          "java.lang.Iterable"
        ),
        new ClassImplementsInterfaces(
          "de.thm.mni.aud.util.MergeSortVisualizer",
          "de.thm.mni.aud.util.MergeSortListener"
        ),
        new ClassExtendsFromClass(
          "de.thm.mni.aud.util.DLLInvariantException",
          "java.lang.RuntimeException"
        ),
        new ClassExtendsFromClass(
          "de.thm.mni.aud.SortableDLL",
          "de.thm.mni.aud.util.DoublyLinkedList"
        ),
        new MethodImplementations(true,
          new Method("de.thm.mni.aud.util.DoublyLinkedList.checkBackward()")
            .requireVisibilityProtected()
            .requireReturnType("String")
            .requireParameters("DoublyLinkedNode<E>", "DoublyLinkedNode<E>"),
          new Method("de.thm.mni.aud.util.DoublyLinkedList.checkForward()")
            .requireVisibilityProtected()
            .requireReturnType("String")
            .requireParameters("DoublyLinkedNode<E>", "DoublyLinkedNode<E>"),
          new Method("de.thm.mni.aud.util.DoublyLinkedList.checkClassInvariant()")
            .requireVisibilityProtected()
            .requireReturnType("void")
            .requireParameters("DoublyLinkedNode<E>", "DoublyLinkedNode<E>", "boolean"),
          new Method("de.thm.mni.aud.util.DoublyLinkedList.checkClassInvariant()")
            .requireVisibilityProtected()
            .requireReturnType("void")
            .requireParameters("DoublyLinkedNode<E>", "int", "boolean"),
          new Method("de.thm.mni.aud.util.DoublyLinkedList.checkClassInvariant()")
            .requireVisibilityPublic()
            .requireReturnType("void")
            .requireParametersNone(),
          new Method("de.thm.mni.aud.util.DoublyLinkedList.DoublyLinkedNode.hasNext()")
            .requireVisibilityPublic()
            .requireReturnType("boolean")
            .requireParametersNone(),
          new Method("de.thm.mni.aud.util.DoublyLinkedList.DoublyLinkedNode.hasPrev()")
            .requireVisibilityPublic()
            .requireReturnType("boolean")
            .requireParametersNone(),
          new Method("de.thm.mni.aud.util.DoublyLinkedList.link()")
            .requireVisibilityProtected()
            .requireModifierStatic()
            .requireReturnType("void")
            .requireParameters("DoublyLinkedNode<E>", "DoublyLinkedNode<E>"),
          new Method("de.thm.mni.aud.util.DoublyLinkedList.iterator()")
            .requireVisibilityPublic()
            .requireReturnType("Iterator<E>")
            .requireParametersNone(),
          new Method("de.thm.mni.aud.util.DoublyLinkedList.hasNext().iterator()")
            .requireVisibilityPublic()
            .requireReturnType("boolean")
            .requireParametersNone(),
          new Method("de.thm.mni.aud.util.DoublyLinkedList.next().iterator()")
            .requireVisibilityPublic()
            .requireReturnType("E")
            .requireParametersNone(),
          new Method("de.thm.mni.aud.util.DoublyLinkedList.revIterator()")
            .requireVisibilityPublic()
            .requireReturnType("Iterator<E>")
            .requireParametersNone(),
          new Method("de.thm.mni.aud.util.DoublyLinkedList.hasNext().revIterator()")
            .requireVisibilityPublic()
            .requireReturnType("boolean")
            .requireParametersNone(),
          new Method("de.thm.mni.aud.util.DoublyLinkedList.next().revIterator()")
            .requireVisibilityPublic()
            .requireReturnType("E")
            .requireParametersNone(),
          new Method("de.thm.mni.aud.util.DoublyLinkedList.append()")
            .requireVisibilityPublic()
            .requireReturnType("void")
            .requireParameters("E"),
          new Method("de.thm.mni.aud.util.DoublyLinkedList.prepend()")
            .requireVisibilityPublic()
            .requireReturnType("void")
            .requireParameters("E"),
          new Method("de.thm.mni.aud.util.DoublyLinkedList.size()")
            .requireVisibilityPublic()
            .requireReturnType("int")
            .requireParametersNone(),
          new Method("de.thm.mni.aud.util.DoublyLinkedList.toString()")
            .requireVisibilityPublic()
            .requireReturnType("String")
            .requireParametersNone(),
          new Method("de.thm.mni.aud.util.DoublyLinkedList.equals()")
            .requireVisibilityPublic()
            .requireReturnType("boolean")
            .requireParameters("Object"),
          new Method("de.thm.mni.aud.util.DoublyLinkedList.hashCode()")
            .requireVisibilityPublic()
            .requireReturnType("int")
            .requireParametersNone(),
          new Method("de.thm.mni.aud.util.MergeSortVisualizer.split()")
            .requireVisibilityPublic()
            .requireReturnType("void")
            .requireParameters("DoublyLinkedList.DoublyLinkedNode<E>", "int", "DoublyLinkedList.DoublyLinkedNode<E>", "int"),
          new Method("de.thm.mni.aud.util.MergeSortVisualizer.appendN()")
            .requireVisibilityPrivate()
            .requireReturnType("void")
            .requireParameters("StringBuilder", "DoublyLinkedList.DoublyLinkedNode<E>", "int"),
          new Method("de.thm.mni.aud.util.MergeSortVisualizer.finishMerge()")
            .requireVisibilityPublic()
            .requireReturnType("void")
            .requireParameters("DoublyLinkedList.DoublyLinkedNode<E>", "int"),
          new Method("de.thm.mni.aud.util.MergeSortVisualizer.toString()")
            .requireVisibilityPublic()
            .requireReturnType("String")
            .requireParametersNone(),
          new Method("de.thm.mni.aud.SortableDLL.sort()")
            .requireVisibilityPublic()
            .requireReturnType("void")
            .requireParametersNone(),
          new Method("de.thm.mni.aud.SortableDLL.sort()")
            .requireVisibilityPublic()
            .requireReturnType("void")
            .requireParameters("MergeSortListener<E>"),
          new Method("de.thm.mni.aud.SortableDLL.sort()")
            .requireVisibilityPrivate()
            .requireReturnType("DoublyLinkedNode<E>")
            .requireParameters("DoublyLinkedNode<E>", "int", "MergeSortListener<E>", "DoublyLinkedNode<E>"),
          new Method("de.thm.mni.aud.SortableDLL.merge()")
            .requireVisibilityPrivate()
            .requireReturnType("DoublyLinkedNode<E>")
            .requireParameters("DoublyLinkedNode<E>", "int", "DoublyLinkedNode<E>", "int", "MergeSortListener<E>", "DoublyLinkedNode<E>"),
          new Method("de.thm.mni.aud.util.MergeSortListener.split()")
            .requireVisibilityPackage()
            .requireReturnType("void")
            .requireParameters("DoublyLinkedList.DoublyLinkedNode<E>", "int", "DoublyLinkedList.DoublyLinkedNode<E>", "int"),
          new Method("de.thm.mni.aud.util.MergeSortListener.startMerge()")
            .requireVisibilityPackage()
            .requireReturnType("void")
            .requireParameters("DoublyLinkedList.DoublyLinkedNode<E>", "int", "DoublyLinkedList.DoublyLinkedNode<E>", "int"),
          new Method("de.thm.mni.aud.util.MergeSortListener.finishMerge()")
            .requireVisibilityPackage()
            .requireReturnType("void")
            .requireParameters("DoublyLinkedList.DoublyLinkedNode<E>", "int")
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
