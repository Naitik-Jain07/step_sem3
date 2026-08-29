class MessWallet {
    private double balance;

    public MessWallet(double openingBalance) {
        if (openingBalance < 0) {
            System.out.println("Warning: Negative opening balance is not allowed. Starting balance set to 0.");
            this.balance = 0;
        } else {
            this.balance = openingBalance;
        }
    }

    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up rejected: Amount must be greater than 0.");
        } else {
            balance += amount;
            System.out.println("Top-up successful: ₹" + amount);
        }
    }

    public void deduct(double amount) {
        if (amount <= 0) {
            System.out.println("Deduction rejected: Amount must be greater than 0.");
        } else if (amount > balance) {
            System.out.println("Deduction rejected: Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Deduction successful: ₹" + amount);
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class MessWalletDemo {
    public static void main(String[] args) {

        MessWallet wallet = new MessWallet(-500);

        wallet.topUp(1000);
        wallet.topUp(-100);
        wallet.deduct(300);
        wallet.deduct(800);

        System.out.println("Current Balance: ₹" + wallet.getBalance());
    }
}