class Payment {
    public void pay(double amount) {
        System.out.println("Paid (cash): Rs " + amount);
    }
}

class CardPayment extends Payment {
    public void payWithProcessingFee(double amount) {
        double total = amount * 1.02;
        System.out.println("Charged (card, incl. fee): Rs " + total);
    }
}

class TransactionProcessor {

    public double processTransaction(Payment payment, double amount) {

        if (payment instanceof CardPayment) {
            CardPayment cardPayment = (CardPayment) payment;
            cardPayment.payWithProcessingFee(amount);

            return amount * 1.02;
        } else {
            payment.pay(amount);
            return amount;
        }
    }
}

public class PaymentDemo {
    public static void main(String[] args) {

        Payment[] payments = {
                new CardPayment(),
                new Payment(),
                new CardPayment(),
                new Payment(),
                new CardPayment()
        };

        double[] amounts = {100, 50, 200, 75, 120};

        TransactionProcessor processor = new TransactionProcessor();

        double totalCollected = 0;

        for (int i = 0; i < payments.length; i++) {
            totalCollected +=
                    processor.processTransaction(payments[i], amounts[i]);
        }

        System.out.println("Total Collected: Rs " + totalCollected);
    }
}