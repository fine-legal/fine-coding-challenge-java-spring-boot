package so.fine.codingchallenge.db;

import jakarta.persistence.Entity;

@Entity
public class DealA extends AbstractDeal {

    private int withdrawals;

    private int deposits;

    public int getWithdrawals() {
        return withdrawals;
    }

    public void setWithdrawals(int withdrawals) {
        this.withdrawals = withdrawals;
    }

    public int getDeposits() {
        return deposits;
    }

    public void setDeposits(int deposits) {
        this.deposits = deposits;
    }
}
