package WeeklyAssignment2;

public class CurrentAccount extends Account {
    public CurrentAccount(String accountHolder, double balance) {
        super(accountHolder, balance);
    }

    @Override
    public double calculateMonthlyInterest() {
        System.out.println("This is a current account.");
        System.out.println("Current accounts don't accrue any interest.");
        return 0;
    }

    @Override
    public String toString() {
        return "CurrentAccount{" +
                "accountNumber='" + this.getAccountNumber() + '\'' +
                ", accountHolder='" + this.getAccountHolder() + '\'' +
                ", balance=" + this.getBalance() +
                ", accountType= Current" +
                '}';
    }
}
