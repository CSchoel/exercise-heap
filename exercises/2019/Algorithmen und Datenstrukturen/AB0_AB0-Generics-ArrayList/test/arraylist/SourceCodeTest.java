package arraylist;

import de.thm.mni.aud.commons.CodeAnalyser;
import org.junit.Test;
import static org.junit.Assert.*;


import sourcecodetester.SourceCodeTester;
import sourcecodetester.tests.*;
import sourcecodetester.util.Method;

public class SourceCodeTest extends CodeAnalyser {

  @Override
  public void setupTests(SourceCodeTester sct) {

    // A reference to the tested implementation is required to successfully compile on Dozentron
    try {
      new GenericArrayList<>(5);
    } catch(Throwable t) {
      // prevents any exceptions or errors because the static code tests should do that
    }

    // CLASS AND METHOD IMPLEMENTATIONS
    sct.createNewTestGroup("Class and Method Implementations", "The following tests are checking for correct class and method implementations.")
      .addTests(
        new ClassImplementations(
          "arraylist.GenericArrayList"
        ),
        new InterfaceImplementations(
          "arraylist.GenericList"
        ),
        new ClassImplementsInterfaces(
          "arraylist.GenericArrayList",
          "arraylist.GenericList"
        ),
        new MethodImplementations(
          new Method("arraylist.GenericArrayList.get()")
            .requireVisibilityPublic()
            .requireReturnType("E")
            .requireParameters("int"),
          new Method("arraylist.GenericArrayList.set()")
            .requireVisibilityPublic()
            .requireReturnType("void")
            .requireParameters("E", "int"),
          new Method("arraylist.GenericArrayList.size()")
            .requireVisibilityPublic()
            .requireReturnType("int")
            .requireParametersNone(),
          new Method("arraylist.GenericArrayList.add()")
            .requireVisibilityPublic()
            .requireReturnType("void")
            .requireParameters("E"),
          new Method("arraylist.GenericArrayList.remove()")
            .requireVisibilityPublic()
            .requireReturnType("void")
            .requireParameters("int"),
          new Method("arraylist.GenericArrayList.insert()")
            .requireVisibilityPublic()
            .requireReturnType("void")
            .requireParameters("E", "int")
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
