package WeeklyAssignment2;

public class SavingsAccount extends Account {
    private static final double INTEREST_RATE = 0.03;

    public SavingsAccount(String accountHolder, double balance) {
        super(accountHolder, balance);
    }


    public double calculateMonthlyInterest() {
        double interest = this.getBalance() * INTEREST_RATE;
//        do we deposit the interest when we calculate the interest?
//        this.deposit(interest);
        System.out.printf("$%.2f has been accrued to your account.\n", interest);
        return interest;
    }

    @Override
    public String toString() {
        return String.format("Account number: \t%d\nAccount holder: \t%s\nAccount balance: \t$%.2f\nInterest rate: \t\t%.2f%%", getAccountNumber(), getAccountHolder(), getBalance(), INTEREST_RATE * 100);
    }
}
