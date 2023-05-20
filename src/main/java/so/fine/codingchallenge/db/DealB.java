package so.fine.codingchallenge.db;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class DealB extends AbstractDeal {

    private int salary;

    private LocalDate contractStart;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public LocalDate getContractStart() {
        return contractStart;
    }

    public void setContractStart(LocalDate contractStart) {
        this.contractStart = contractStart;
    }
}
