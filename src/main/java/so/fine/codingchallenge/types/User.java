package so.fine.codingchallenge.types;

public class User extends Lead {
    private String state;
    private String court;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCourt() {
        return court;
    }

    public void setCourt(String court) {
        this.court = court;
    }
}
