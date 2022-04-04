import java.util.HashMap;

public class DataDemo {
    FileParser parser;
    String [] headers;
    HashMap<String, College> colleges = new HashMap<>();
    public DataDemo (String filename) {
        parser = new FileParser (filename);
    }

    public String [] getHeaders () {
        return parser.getHeaders();
    }

    public String [] getNextLine () {
        return parser.parseNextLine();
    }

    public void showDataFor (String college) {
        if (colleges.containsKey(college)) {
            System.out.println(colleges.get(college));
        }
        else{
            System.out.println("No data for " + college);
        }
    }

    void loadAll () {
        String [] fields = getNextLine();
        while (fields != null) {
            College c = College.fromFields(fields);
            colleges.put(c.getName(), c);
            fields = getNextLine();
        }
    }

    public static void main (String [] args) {
        String example = "College.csv";
        DataDemo demo = new DataDemo(example);
        demo.loadAll();
        demo.showDataFor("Shepherd University");
        demo.showDataFor("West Liberty State College");
    }
}