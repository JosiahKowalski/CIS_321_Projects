import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


class FileValidatorTest {

    ArrayList<String> list;
    ArrayList<BracketLocations> expectedList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        list = new ArrayList<>();
        list.add("public class Test {");
        list.add("public static void main(String[] args) {");
        list.add("}");
        list.add("}");
    }

    @Test
    void testOpenParenthesis() {
        list.add(2, "(");
        expectedList.add(new BracketLocations(3,1,'('));
        assertEquals(expectedList, FileValidator.ValidateFile(list));
    }
    @Test
    void testOpenSquiggle() {
        list.add(2, "{");
        expectedList.add(new BracketLocations(1,19,'{'));
        // This one is one line 1 character 19 because it looks for the first bad bracket
        assertEquals(expectedList, FileValidator.ValidateFile(list));
    }
    @Test
    void testOpenSquare() {
        list.add(2, "[");
        expectedList.add(new BracketLocations(3,1,'['));
        assertEquals(expectedList, FileValidator.ValidateFile(list));
    }
    @Test
    void testOpenAngle() {
        list.add(2, "<");
        expectedList.add(new BracketLocations(3,1,'<'));
        assertEquals(expectedList, FileValidator.ValidateFile(list));
    }
    @Test
    void testCloseParenthesis() {
        list.add(0, ")");
        expectedList.add(new BracketLocations(1,1,')'));
        assertEquals(expectedList, FileValidator.ValidateFile(list));
    }
    @Test
    void testCloseSquiggle() {
        list.add(0, "}");
        expectedList.add(new BracketLocations(1,1,'}'));
        assertEquals(expectedList, FileValidator.ValidateFile(list));
    }
    @Test
    void testCloseSquare() {
        list.add(0, "]");
        expectedList.add(new BracketLocations(1,1,']'));
        assertEquals(expectedList, FileValidator.ValidateFile(list));
    }
    @Test
    void testCloseAngle() {
        list.add(0, ">");
        expectedList.add(new BracketLocations(1,1,'>'));
        assertEquals(expectedList, FileValidator.ValidateFile(list));
    }
    @Test
    void testValid(){
        assertEquals(expectedList, FileValidator.ValidateFile(list));
    }
}