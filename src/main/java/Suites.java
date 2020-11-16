import java.util.ArrayList;

public enum Suites {

    SUITES (new String[] {"Spade", "Club", "Diamond", "Heart"});

    private String[] suite;

    Suites(String[] suite) {
        this.suite = suite;
    }

    public String[] getSuite() {
        return suite;
    }


}
