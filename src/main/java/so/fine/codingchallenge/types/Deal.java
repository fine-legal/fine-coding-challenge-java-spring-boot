package so.fine.codingchallenge.types;

public class Deal {
    public enum DealStatus {
        NEW,
        IN_PROGRESS,
        CLOSED
    }

    protected String name;
    protected String description;
    protected DealStatus status;
    protected double amountInvolved;

    public Deal(String name, String description, DealStatus status, double amountInvolved) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.amountInvolved = amountInvolved;
    }

    // Getters and Setters for all the properties

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DealStatus getStatus() {
        return status;
    }

    public void setStatus(DealStatus status) {
        this.status = status;
    }

    public double getAmountInvolved() {
        return amountInvolved;
    }

    public void setAmountInvolved(double amountInvolved) {
        this.amountInvolved = amountInvolved;
    }
}
