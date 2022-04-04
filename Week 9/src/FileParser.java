import java.io.*;
import java.util.*;
/**
 * Assume CSV format text file with headers in first line.
 */
public class FileParser {
    final String COMMA=",";
    String filename;
    boolean success;
    BufferedReader reader;
    String [] headers;

    boolean success () {
        return this.success;
    }

    public FileParser (String filename) {
        this.filename = filename;
        this.success = true;
        try {
            reader =
                    new BufferedReader(new FileReader(filename));
            this.headers = parseNextLine();
        } catch (Exception e) {
            this.headers = null;
            this.success = false;
        }
    }

    public String[] getHeaders () {
        return headers;
    }

    String [] parseNextLine() {
        String [] fields = null;
        if (success == true) {
            try {
                String line = reader.readLine();
                if (line == null)  {
                    success = false;
                } else {
                    fields = line.split(COMMA);
                }
            } catch (Exception e) {
                success = false;
            }
        }
        return fields;
    }
}
