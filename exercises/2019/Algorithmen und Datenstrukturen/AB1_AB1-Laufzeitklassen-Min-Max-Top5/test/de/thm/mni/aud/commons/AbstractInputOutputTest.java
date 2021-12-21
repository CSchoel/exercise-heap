package de.thm.mni.aud.commons;

import org.junit.Before;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertFalse;

public abstract class AbstractInputOutputTest {

    private static final String STUDENT_INPUT_PROPERTY = "input";
    private static final String STUDENT_OUTPUT_PROPERTY = "student-output";

    protected List<String> studentInputLines;
    protected List<String> studentOutputLines;

    @Before
    public void prepare() throws IOException {
        String studentInputFile = System.getProperty(STUDENT_INPUT_PROPERTY);
        String studentOutputFile = System.getProperty(STUDENT_OUTPUT_PROPERTY);

        if (studentInputFile == null) {
            studentInputFile = "exampleInput.txt";
        }
        if (studentOutputFile == null) {
            studentOutputFile = "exampleOutput.txt";
        }
        studentInputLines = Files.readAllLines(
            Paths.get(studentInputFile),
            StandardCharsets.UTF_8
        );
        studentOutputLines = Files.readAllLines(
            Paths.get(studentOutputFile),
            StandardCharsets.UTF_8
        );
        assertFalse("Leerer Input!", studentInputLines.isEmpty());
        assertFalse("Leerer Output!", studentOutputLines.isEmpty());
    }
}
