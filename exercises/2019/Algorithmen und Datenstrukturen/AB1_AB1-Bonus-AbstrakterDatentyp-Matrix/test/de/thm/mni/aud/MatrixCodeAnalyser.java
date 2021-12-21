package de.thm.mni.aud;

import de.thm.mni.aud.commons.CodeAnalyser;
import org.junit.Test;
import sourcecodetester.SourceCodeTester;
import sourcecodetester.enums.Visibility;
import sourcecodetester.tests.*;
import sourcecodetester.util.*;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;

public class MatrixCodeAnalyser extends CodeAnalyser {
  @Override
  public void setupTests(SourceCodeTester sct) {

    // CLASS AND METHOD IMPLEMENTATIONS
    sct.createNewTestGroup("Class and Method Implementations", "The following tests are checking for correct class and method implementations.")
      .addTests(
        new ClassImplementations(
          "de.thm.mni.aud.TwoDimDoubleMatrix",
          "de.thm.mni.aud.OneDimDoubleMatrix"
        ),
        new InterfaceImplementations(
          "de.thm.mni.aud.DoubleMatrix"
        ),
        new ConstructorImplementations(
          new Constructor("de.thm.mni.aud.TwoDimDoubleMatrix.TwoDimDoubleMatrix()")
            .requireVisibilityPublic()
            .requireParameters("int", "int"),
          new Constructor("de.thm.mni.aud.TwoDimDoubleMatrix.TwoDimDoubleMatrix()")
            .requireVisibilityPublic()
            .requireParameters("double[][]"),
          new Constructor("de.thm.mni.aud.OneDimDoubleMatrix.OneDimDoubleMatrix()")
            .requireVisibilityPublic()
            .requireParameters("int", "int"),
          new Constructor("de.thm.mni.aud.OneDimDoubleMatrix.OneDimDoubleMatrix()")
            .requireVisibilityPublic()
            .requireParameters("double[]", "int")
        )//,
//        new ClassImplementsInterfaces(
//          "de.thm.mni.aud.TwoDimDoubleMatrix",
//          "de.thm.mni.aud.DoubleMatrix"
//        ),
//        new ClassImplementsInterfaces(
//          "de.thm.mni.aud.OneDimDoubleMatrix",
//          "de.thm.mni.aud.DoubleMatrix"
//        ),
//        new MethodImplementations(false,
//          new Method("de.thm.mni.aud.DoubleMatrix.toString()")
//            .requireVisibilityPublic()
//            .requireReturnType("String")
//            .requireParametersNone(),
//          new Method("de.thm.mni.aud.DoubleMatrix.equals()")
//            .requireVisibilityPublic()
//            .requireReturnType("boolean")
//            .requireParameters("Object"),
//          new Method("de.thm.mni.aud.DoubleMatrix.get()")
//            .requireVisibilityPublic()
//            .requireReturnType("double")
//            .requireParameters("int", "int"),
//          new Method("de.thm.mni.aud.DoubleMatrix.set()")
//            .requireVisibilityPublic()
//            .requireReturnType("void")
//            .requireParameters("int", "int", "double"),
//          new Method("de.thm.mni.aud.TwoDimDoubleMatrix.identity()")
//            .requireVisibilityPublic()
//            .requireModifierStatic()
//            .requireReturnType("TwoDimDoubleMatrix")
//            .requireParameters("int"),
//          new Method("de.thm.mni.aud.TwoDimDoubleMatrix.unsafeGet()")
//            .requireVisibilityPublic()
//            .requireReturnType("double")
//            .requireParameters("int", "int"),
//          new Method("de.thm.mni.aud.TwoDimDoubleMatrix.unsafeSet()")
//            .requireVisibilityPublic()
//            .requireReturnType("void")
//            .requireParameters("int", "int", "double"),
//          new Method("de.thm.mni.aud.TwoDimDoubleMatrix.add()")
//            .requireVisibilityPublic()
//            .requireReturnType("DoubleMatrix")
//            .requireParameters("DoubleMatrix"),
//          new Method("de.thm.mni.aud.TwoDimDoubleMatrix.multiply()")
//            .requireVisibilityPublic()
//            .requireReturnType("DoubleMatrix")
//            .requireParameters("DoubleMatrix"),
//          new Method("de.thm.mni.aud.TwoDimDoubleMatrix.columns()")
//            .requireVisibilityPublic()
//            .requireReturnType("int")
//            .requireParametersNone(),
//          new Method("de.thm.mni.aud.TwoDimDoubleMatrix.rows()")
//            .requireVisibilityPublic()
//            .requireReturnType("int")
//            .requireParametersNone(),
//          new Method("de.thm.mni.aud.OneDimDoubleMatrix.identity()")
//            .requireVisibilityPublic()
//            .requireModifierStatic()
//            .requireReturnType("OneDimDoubleMatrix")
//            .requireParameters("int"),
//          new Method("de.thm.mni.aud.OneDimDoubleMatrix.unsafeSet()")
//            .requireVisibilityPublic()
//            .requireReturnType("void")
//            .requireParameters("int", "int", "double"),
//          new Method("de.thm.mni.aud.OneDimDoubleMatrix.add()")
//            .requireVisibilityPublic()
//            .requireReturnType("DoubleMatrix")
//            .requireParameters("DoubleMatrix"),
//          new Method("de.thm.mni.aud.OneDimDoubleMatrix.multiply()")
//            .requireVisibilityPublic()
//            .requireReturnType("DoubleMatrix")
//            .requireParameters("DoubleMatrix"),
//          new Method("de.thm.mni.aud.OneDimDoubleMatrix.columns()")
//            .requireVisibilityPublic()
//            .requireReturnType("int")
//            .requireParametersNone(),
//          new Method("de.thm.mni.aud.OneDimDoubleMatrix.rows()")
//            .requireVisibilityPublic()
//            .requireReturnType("int")
//            .requireParametersNone(),
//          new Method("de.thm.mni.aud.OneDimDoubleMatrix.unsafeGet()")
//            .requireVisibilityPublic()
//            .requireReturnType("double")
//            .requireParameters("int", "int")
//      )
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

    sct.createNewTestGroup("Internal structure", "")
      .addTests(new TestTemplate() {
        private Field[] getArrayFields(Class<?> clazz) {
          return Arrays.stream(clazz.getDeclaredFields()).filter(
            f -> f.getType().isArray()
          ).toArray(Field[]::new);
        }

        @Override
        public void runTest(CodeInfoCollection codeInfoCollection, ErrorBuilder errorBuilder) throws Exception {
          Field[] arrayFields = getArrayFields(OneDimDoubleMatrix.class);
          if (arrayFields.length != 1) {
            errorBuilder.addErrorMessage("OneDimDoubleMatrix should contain exactly one array field");
          }
          if (!arrayFields[0].getType().equals(double[].class)) {
            errorBuilder.addErrorMessage("Array field in OneDimDoubleMatrix should be of type double[], not " + arrayFields[0].getType());
          }
          arrayFields = getArrayFields(TwoDimDoubleMatrix.class);
          if (arrayFields.length != 1) {
            errorBuilder.addErrorMessage("TwoDimDoubleMatrix should contain exactly one array field");
          }
          if (!arrayFields[0].getType().equals(double[][].class)) {
            errorBuilder.addErrorMessage("Array field in TwoDimDoubleMatrix should be of type double[][], not " + arrayFields[0].getType());
          }
        }

        @Override
        public String generateName() {
          return "Internal fields";
        }

        @Override
        public String generateDescription() {
          return "Tests that OneDimDoubleMatrix is backed by a double[] and TwoDimDoubleMatrix is backed by a double[][]";
        }
      });

//		// FUNCTIONALITY
//		sct.createNewTestGroup("Functionality", "The following tests are checking specific code functionalities.")
//			.addTests(
//				new MethodRecursiveImplementations(
//					new Method("my.package.MyClass.myRecursiveMethod()")
//				),
//					new MethodCallUsedInMethods(
//					new Method("methodA()"),
//					new Method("methodZ()")
//				)
//			)
//		;

//		// LIMITATIONS
//		sct.createNewTestGroup("Limitations", "The following tests limit the usage of specific classes and method calls.")
//			.addTests(
//				new BlacklistClasses(
//					java.util.Collections.class.getName(),
//					java.util.ArrayList.class.getName()
//				),
//				new WhitelistClasses(
//					java.util.Collection.class.getName(),
//					java.util.Collections.class.getName()
//				),
//				new BlacklistMethods(
//					new Method("java.lang.Math.random()"),
//					new Method("java.lang.Math.max()"),
//					new Method("java.lang.Math.min()"),
//					new Method("java.util.Collections.max()"),
//					new Method("java.util.Collections.min()")
//				)
//			)
//		;

		// JAVA DOCUMENTATION
		sct.createNewTestGroup("Java Documentation", "The following tests are checking for Java Documentation.")
			.addTests(
				new JavadocPublicMethods(false, false, false)
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

  @Test
  public void internalStructure() {
    runTests("Internal structure");
  }

//	@Test
//	public void functionality() {
//		runTests("Functionality");
//	}

//	@Test
//	public void limitations() {
//		runTests("Limitations");
//	}

	@Test
	public void javaDocumentation() {
		runTests("Java Documentation");
	}


}
