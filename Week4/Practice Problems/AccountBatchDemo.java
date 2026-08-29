class FeeAccount {
    public void pay(double amount) {
        System.out.println("Paid in one go (day-scholar account)");
    }
}

class HostelFeeAccount extends FeeAccount {
    @Override
    public void pay(double amount) {
        System.out.println("Paid in two installments (hostel account)");
    }
}

class PaymentProcessor {
    int hostelCount = 0;
    int dayScholarCount = 0;

    public void processPayment(FeeAccount account, double amount) {

        if (account instanceof HostelFeeAccount) {
            account.pay(amount);
            hostelCount++;
        } else {
            account.pay(amount);
            dayScholarCount++;
        }
    }

    public void printSummary() {
        System.out.println("Hostel accounts processed: " + hostelCount
                + " | Day-scholar accounts processed: "
                + dayScholarCount);
    }
}

public class AccountBatchDemo {
    public static void main(String[] args) {

        FeeAccount[] accounts = {
                new HostelFeeAccount(),
                new HostelFeeAccount(),
                new FeeAccount(),
                new FeeAccount()
        };

        double amount = 60000;

        PaymentProcessor processor = new PaymentProcessor();

        for (FeeAccount account : accounts) {
            processor.processPayment(account, amount);
        }

        processor.printSummary();
    }
}