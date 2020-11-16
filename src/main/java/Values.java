public enum Values {

    VALUES (new String[] {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "King", "Queen", "Judge"});

    private String[] values;

    Values(String[] values) {
        this.values = values;
    }

    public String[] getValues() {
        return values;
    }
}
