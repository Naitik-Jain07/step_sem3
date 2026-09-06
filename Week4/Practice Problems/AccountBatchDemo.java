class FeeAccount {
    public void processPayment(double amount) {
        System.out.println("Paid in one go (day-scholar account)");
    }
}

class HostelFeeAccount extends FeeAccount {
    public void processPayment(double amount) {
        System.out.println("Paid in two installments (hostel account)");
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

        int hostelCount = 0;
        int dayScholarCount = 0;
        for (int i = 0; i < accounts.length; i++) {

            if (accounts[i] instanceof HostelFeeAccount) {
                accounts[i].processPayment(amount);
                hostelCount++;
            } else {
                accounts[i].processPayment(amount);
                dayScholarCount++;
            }
        }
        System.out.println(
            "Hostel accounts processed: " + hostelCount +
            " | Day-scholar accounts processed: " + dayScholarCount
        );
    }
}