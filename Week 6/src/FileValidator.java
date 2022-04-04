import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * This class contains methods that will Validate a file to make sure it has balanced brackets.
 * The ValidateFile method will return an ArrayList with each error and its location.
 * The FormatResults method will sort and format a string to be output.
 * The ReadFile method will return an ArrayList with the file
 *
 * @author Josiah Kowalski
 * @version 2/18/22
 */
public class FileValidator {
    // Map (Dictionary) that contains each bracket and its pair
    private static final Map<Character, Character> bracketTypesDictionary = Map.of(
            '}', '{',
            ')','(',
            ']','[',
            '>','<'
    );

    public static void main(String[] args) throws IOException {
        // Enter the file source here, when I used the CMD to run this it worked with this source but when running
        // from my IDE I have to include the folder, "Week 6\src\FileValidatorTestFile.java". I left it as just the
        // file name since that will probably work for you.
        String source = "Week 6/src/FileValidatorTestFile.java";
        // Verbose mode, use the arg "/verbose"
        if (Arrays.asList(args).contains("/verbose")){
            // Get an ArrayList of the file split into lines using the ReadFile method
            ArrayList<String> file = ReadFile(source);
            // Get an ArrayList of the results using the ValidateFile method, if it is empty then there are no errors.
            // Each error is a record containing the line number, character number, and the bracket type.
            ArrayList<BracketLocations> resultsArr = ValidateFile(file);
            // Get a formatted string containing the results using the FormatResults method
            String resultsStr = FormatResults(resultsArr);
            // Print results
            System.out.println(resultsStr);
        }
        else{
            System.out.println(isValid(source));
        }
    }

    /**
     * This method is used for a 'quiet' mode, it only returns whether the file is valid or not. It does not show where
     * the errors are in the file. It can also be used to check if a file is valid from outside this class, i.e.
     * FileValidator.isValid("FilePathHere.java").
     *
     * @param source Name of file to be validated
     * @return True if file is valid, false if not
     * @throws IOException Needed to read the file
     */
    public static boolean isValid(String source) throws IOException {
        ArrayList<String> file = ReadFile(source);
        return ValidateFile(file).isEmpty();
    }

    /**
     * Orders the ArrayList and then returns a formatted string with the results, will contain the bracket type,
     * line number, and character number in numerical order.
     *
     * @param errors ArrayList containing unbalanced brackets
     * @return a formatted string the results, can contain the errors in the file or that the file has no errors.
     */
    private static String FormatResults(ArrayList<BracketLocations> errors){
        if (errors.isEmpty()) {
            return "No bracket errors have been found.";
        }
        // Sort by char number first then by line number
        errors.sort(Comparator.comparingInt(BracketLocations::getCharNumber).reversed());
        errors.sort(Comparator.comparingInt(BracketLocations::getLineNumber).reversed());
        StringBuilder results = new StringBuilder("Error:");
        // Iterate through the errors and create a line for each error with the location and bracket type
        for (BracketLocations error : errors){
            results.insert(6, "\nLine: " + error.lineNumber() +
                    " Character: " + error.charNumber() +
                    " Bracket Type: " + error.bracketType());
        }
        return results.toString();
    }

    /**
     * Checks if file has any unbalanced brackets and returns a
     * formatted string with each bracket without a correct pair
     *
     * @param file ArrayList of a file with each Validate being a separate line
     * @return a formatted string with the results using the FormatResults method
     */
    public static ArrayList<BracketLocations> ValidateFile(ArrayList<String> file){
        // Declare and initialize variables
        int charNumber;
        int lineNumber = 1;
        Deque<BracketLocations> bracketLocationsDeque = new LinkedList<>();
        ArrayList<BracketLocations> errors = new ArrayList<>();
        for (String line : file) {
            // Reset the character number at the beginning of each new line
            charNumber = 1;
            for (char ch : line.toCharArray()){
                if (bracketTypesDictionary.containsValue(ch)) {
                    bracketLocationsDeque.push(new BracketLocations(lineNumber, charNumber, ch));
                }
                else if (bracketTypesDictionary.containsKey(ch)) {
                    // call the closedBracket helper method
                    closedBracket(charNumber, lineNumber, bracketLocationsDeque, errors, ch);
                }
                charNumber ++;
            }
            lineNumber ++;
        }
        // If there are still brackets in the deque, add them to the list of errors
        while (!bracketLocationsDeque.isEmpty()){
            errors.add(bracketLocationsDeque.pop());
        }
        return errors;
    }

    /**
     * This is used as a helper method for the ValidateFile method, mainly to reduce the amount of code in that method.
     */
    private static void closedBracket(int charNumber, int lineNumber, Deque<BracketLocations> bracketLocationsDeque, ArrayList<BracketLocations> errors, char ch) {
        boolean match;
        BracketLocations lastElement;
        // If there are no brackets in the deque then add the closing bracket
        if (bracketLocationsDeque.isEmpty()){
            errors.add(new BracketLocations(lineNumber, charNumber, ch));
        }
        else {
            // Checks if there is a match somewhere in the deque
            match = bracketLocationsDeque.stream().anyMatch(bracketLocation ->
                    bracketLocation.getBracketType() == bracketTypesDictionary.get(ch));
            // Loop breaks when a correct bracket is found in the deque and continues only if
            // the deque is not empty and there is at least one match somewhere in the deque
            do {
                lastElement = bracketLocationsDeque.pop();
                // If the last bracket doesn't match the current then add it to the errors
                if (lastElement.getBracketType() != bracketTypesDictionary.get(ch)) {
                    errors.add(lastElement);
                } else {
                    return;
                }
            } while (!bracketLocationsDeque.isEmpty() && match);
        }
    }

    /**
     *
     * @param source String with path to a file to be read
     * @return An ArrayList that contains the file separated into lines
     * @throws IOException To read the file
     */
    public static ArrayList<String> ReadFile(String source)
            throws IOException {
        ArrayList<String> file = new ArrayList<>();
        // Reads the whole file
        FileReader fr = new FileReader(source);
        // Splits the file into lines
        BufferedReader br = new BufferedReader(fr);
        String line;
        // Loops through the file and adds each line to an ArrayList
        while ((line = br.readLine()) != null){
            file.add(line);
        }
        return file;
    }
}

/**
 * This record is used to store the bracketType, lineNumber, and charNumber to be pushed into the deque.
 */
record BracketLocations(int lineNumber, int charNumber, char bracketType) {
    public int getLineNumber() {
        return lineNumber;
    }

    public int getCharNumber() {
        return charNumber;
    }

    public char getBracketType() {
        return bracketType;
    }
}
