
public class College {
    private final String name;
    private int num_applied;
    private int num_accepted;
    private int num_enrolled;
    private int percent_graduated;
    /**
     * Constructor for objects of class College
     */
    public College(String n) {
        name = n;
    }

    public String getName () {
        return name;
    }

    public void setNumbers (int ap, int ac, int en, int gr) {
        num_applied = ap;
        num_accepted = ac;
        num_enrolled = en;
        percent_graduated = gr;
    }

    public String toString () {
        String show = String.format(
                "%s (%d app, %d acc, %d enr, %d%% grad)",
                name,num_applied,num_accepted,num_enrolled,percent_graduated);
        return show;
    }

    public static College fromFields (String [] fields) {
        // Specific to DOE College.csv files:
        College c = new College (fields[0]);
        int ap = Integer.parseInt(fields[2]);
        int ac = Integer.parseInt(fields[3]);
        int en = Integer.parseInt(fields[4]);
        int gr = Integer.parseInt(fields[5]);
        c.setNumbers(ap,ac,en,gr);
        return c;
    }
}
