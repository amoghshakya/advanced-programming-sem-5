package WeeklyAssignment2;

public class SavingsAccount extends Account {
    private static final double INTEREST_RATE = 0.3;

    public SavingsAccount(String accountHolder, double balance) {
        super(accountHolder, balance);
    }


    public double calculateMonthlyInterest() {
        double interest = this.getBalance() * INTEREST_RATE;
//        this.deposit(interest);
        System.out.printf("Interest of %.2f has been accrued from your account.", interest);

        return interest;
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "accountNumber='" + this.getAccountNumber() + '\'' +
                ", accountHolder='" + this.getAccountHolder() + '\'' +
                ", balance=" + this.getBalance() +
                ", accountType= Savings" +
                ", INTEREST_RATE=" + INTEREST_RATE +
                '}';
    }
}
