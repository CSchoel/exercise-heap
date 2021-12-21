package cycles.abstractGraph;


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
  "cycles.Graph"
  ),
  new AbstractClassImplementations(
  "cycles.abstractGraph.AbstractGraph"
  ),
  new ConstructorImplementations(
  new Constructor("cycles.abstractGraph.AbstractGraph.AbstractGraph()")
  .requireVisibilityPublic()
  .requireParametersNone()
  ),
  new ClassExtendsFromClass(
  "cycles.Graph",
  "cycles.abstractGraph.AbstractGraph"
  ),
  new MethodImplementations(true,
  new Method("cycles.abstractGraph.AbstractGraph.connect()")
  .requireVisibilityPublic()
  .requireReturnType("void")
  .requireParameters("E", "E"),
  new Method("cycles.abstractGraph.AbstractGraph.addKnot()")
  .requireVisibilityPublic()
  .requireReturnType("void")
  .requireParameters("E"),
  new Method("cycles.abstractGraph.AbstractGraph.getKnots()")
  .requireVisibilityPublic()
  .requireReturnType("Set<E>")
  .requireParametersNone(),
  new Method("cycles.abstractGraph.AbstractGraph.hasCycles()")
  .requireVisibilityPublic()
  .requireReturnType("boolean")
  .requireParametersNone(),
  new Method("cycles.abstractGraph.AbstractGraph.getAdjacent()")
  .requireVisibilityPublic()
  .requireReturnType("Set<E>")
  .requireParameters("E"),
  new Method("cycles.Graph.hasCycles()")
  .requireVisibilityPublic()
  .requireReturnType("boolean")
  .requireParametersNone()
  ))
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
