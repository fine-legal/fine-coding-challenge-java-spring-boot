package so.fine.codingchallenge.types;

import java.util.ArrayList;

public class DealA extends Deal {
    public class Withdrawal{}
    public class Deposit{}

    private ArrayList<Withdrawal> withdrawals;
    private ArrayList<Deposit> deposits;

    public DealA(String name, String description, DealStatus status, double amountInvolved,
                 ArrayList<Withdrawal> withdrawals, ArrayList<Deposit> deposits) {
        super(name, description, status, amountInvolved);
        this.withdrawals = withdrawals;
        this.deposits = deposits;
    }

    public ArrayList<Withdrawal> getWithdrawals() {
        return withdrawals;
    }

    public void setWithdrawals(ArrayList<Withdrawal> withdrawals) {
        this.withdrawals = withdrawals;
    }

    public ArrayList<Deposit> getDeposits() {
        return deposits;
    }

    public void setDeposits(ArrayList<Deposit> deposits) {
        this.deposits = deposits;
    }
}
