package so.fine.codingchallenge.types;

public class DealB extends Deal {
    private double grossSalary;
    private String contractStartDate;

    public DealB(String name, String description, DealStatus status, double amountInvolved,
                 double grossSalary, String contractStartDate) {
        super(name, description, status, amountInvolved);
        this.grossSalary = grossSalary;
        this.contractStartDate = contractStartDate;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }
}
