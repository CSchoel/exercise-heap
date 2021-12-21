package dijkstra;

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
          "dijkstra.Graph",
          "dijkstra.Dijkstra",
          "dijkstra.Dijkstra.DijkstraInfo",
          "dijkstra.Edge",
          "dijkstra.Knot"
        ),
        new ConstructorImplementations(
          new Constructor("dijkstra.Graph.Graph()")
            .requireVisibilityPublic()
            .requireParameters("List<Knot>", "List<Edge>"),
          new Constructor("dijkstra.Edge.Edge()")
            .requireVisibilityPublic()
            .requireParameters("Knot", "Knot", "int"),
          new Constructor("dijkstra.Knot.Knot()")
            .requireVisibilityPublic()
            .requireParameters("int")
        ),
        new MethodImplementations(true,
          new Method("dijkstra.Graph.getKnots()")
            .requireVisibilityPublic()
            .requireReturnType("List<Knot>")
            .requireParametersNone(),
          new Method("dijkstra.Graph.getEdges()")
            .requireVisibilityPublic()
            .requireReturnType("List<Edge>")
            .requireParametersNone(),
          new Method("dijkstra.Dijkstra.execute()")
            .requireVisibilityPublic()
            .requireReturnType("void")
            .requireParameters("Knot"),
          new Method("dijkstra.Dijkstra.getShortestPath()")
            .requireVisibilityPublic()
            .requireReturnType("List<Knot>")
            .requireParameters("Knot", "Knot"),
          new Method("dijkstra.Edge.getSource()")
            .requireVisibilityPublic()
            .requireReturnType("Knot")
            .requireParametersNone(),
          new Method("dijkstra.Edge.getTarget()")
            .requireVisibilityPublic()
            .requireReturnType("Knot")
            .requireParametersNone(),
          new Method("dijkstra.Edge.getDistance()")
            .requireVisibilityPublic()
            .requireReturnType("int")
            .requireParametersNone(),
          new Method("dijkstra.Knot.equals()")
            .requireVisibilityPublic()
            .requireReturnType("boolean")
            .requireParameters("Object"),
          new Method("dijkstra.Knot.hashCode()")
            .requireVisibilityPublic()
            .requireReturnType("int")
            .requireParametersNone(),
          new Method("dijkstra.Knot.toString()")
            .requireVisibilityPublic()
            .requireReturnType("String")
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
