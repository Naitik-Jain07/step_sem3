class LateFeeAccount {
    String regNo;
    double totalFee;

    public LateFeeAccount(String regNo, double totalFee) {
        this.regNo = regNo;
        this.totalFee = totalFee;
    }

    // Cannot be overridden
    public final double calculateLateFee(int daysLate) {
        return totalFee * 0.01 * daysLate;
    }

    // Cannot be overridden
    public final void printSummary(int daysLate) {

        if (daysLate <= 0) {
            System.out.println(regNo + " - On time, no late fee");
        } else {
            double lateFee = calculateLateFee(daysLate);

            System.out.println(
                regNo + " | Total Fee: Rs " + totalFee +
                " | Late Fee: Rs " + lateFee
            );
        }
    }
}

public class LateFeeDemo {
    public static void main(String[] args) {

        String[] regNos = {
            "RA001", "RA002", "RA003", "RA004"
        };

        double[] totalFees = {
            200000, 150000, 180000, 220000
        };

        int[] daysLate = {
            10, 0, -2, 5
        };

        // Process the complete batch in one pass
        for (int i = 0; i < regNos.length; i++) {

            LateFeeAccount account =
                new LateFeeAccount(regNos[i], totalFees[i]);

            account.printSummary(daysLate[i]);
        }
    }
}