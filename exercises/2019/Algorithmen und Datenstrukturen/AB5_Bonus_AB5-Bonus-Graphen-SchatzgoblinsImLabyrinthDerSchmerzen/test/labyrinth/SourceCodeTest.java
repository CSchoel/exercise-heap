package labyrinth;

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
          "labyrinth.GoblinDresche",
          "labyrinth.Room",
          "labyrinth.Labyrinth"
        ),
        new ConstructorImplementations(
          new Constructor("labyrinth.Room.Room()")
            .requireVisibilityPublic()
            .requireParameters("int"),
          new Constructor("labyrinth.Labyrinth.Labyrinth()")
            .requireVisibilityPublic()
            .requireParameters("List<String>")
        ),
        new MethodImplementations(true,
          new Method("labyrinth.GoblinDresche.main()")
            .requireVisibilityPublic()
            .requireModifierStatic()
            .requireReturnType("void")
            .requireParameters("String[]"),
          new Method("labyrinth.GoblinDresche.findeDenGoblin()")
            .requireVisibilityPublic()
            .requireModifierStatic()
            .requireReturnType("List<Integer>")
            .requireParameters("Labyrinth", "int"),
          new Method("labyrinth.GoblinDresche.dfs()")
            .requireVisibilityPrivate()
            .requireModifierStatic()
            .requireReturnType("void")
            .requireParameters("Room", "boolean[]", "int", "int"),
          new Method("labyrinth.Room.connectRooms()")
            .requireVisibilityPublic()
            .requireReturnType("void")
            .requireParameters("List<Room>"),
          new Method("labyrinth.Room.getRoomNumber()")
            .requireVisibilityPublic()
            .requireReturnType("int")
            .requireParametersNone(),
          new Method("labyrinth.Room.getNeighborRooms()")
            .requireVisibilityPublic()
            .requireReturnType("ArrayList<Room>")
            .requireParametersNone(),
          new Method("labyrinth.Labyrinth.makeGraphfromAscii()")
            .requireVisibilityPrivate()
            .requireReturnType("void")
            .requireParameters("int", "int"),
          new Method("labyrinth.Labyrinth.initLabyrinth()")
            .requireVisibilityPrivate()
            .requireReturnType("void")
            .requireParameters("int", "int"),
          new Method("labyrinth.Labyrinth.getNeighbors()")
            .requireVisibilityPrivate()
            .requireReturnType("List<Room>")
            .requireParameters("int", "int"),
          new Method("labyrinth.Labyrinth.getLabyrinth()")
            .requireVisibilityPublic()
            .requireReturnType("Room")
            .requireParametersNone(),
          new Method("labyrinth.Labyrinth.getRooms()")
            .requireVisibilityPublic()
            .requireReturnType("List<Room>")
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
