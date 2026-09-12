public class LoanReceipt {
    private final String memberId;
    private final String[] bookIds;
    public LoanReceipt(String memberId, String[] bookIds) {
        this.memberId = memberId;
        this.bookIds = bookIds.clone();
    }

    public String getMemberId() {
        return memberId;
    }

    public String[] getBookIds() {
        return bookIds.clone();
    }

    public LoanReceipt withCorrectedBookId(int index, String newId) {

        String[] correctedIds = bookIds.clone();

        if (index >= 0 && index < correctedIds.length) {
            correctedIds[index] = newId;
        }

        return new LoanReceipt(memberId, correctedIds);
    }

    static class ReferenceOnlyLoanReceipt extends LoanReceipt {
        private final String roomNumber;
        public ReferenceOnlyLoanReceipt(String memberId, String[] bookIds, String roomNumber) {
            super(memberId, bookIds);
            this.roomNumber = roomNumber;
        }
        public String getRoomNumber() {
            return roomNumber;
        }
    }

    static class CirculationLedger {
        private static String branchCode;

        static {
            branchCode = "PT-001";
        }
        public static String getBranchCode() {
            return branchCode;
        }
    }

    static String processNightlyCirculation(LoanReceipt[] receipts) {
        StringBuilder result = new StringBuilder();
        for (LoanReceipt receipt : receipts) {
            if (receipt == null) {
                continue;
            }
            if (receipt instanceof ReferenceOnlyLoanReceipt) {
                ReferenceOnlyLoanReceipt referenceReceipt =
                        (ReferenceOnlyLoanReceipt) receipt;
                result.append("REFERENCE-ONLY: ")
                      .append(referenceReceipt.getMemberId())
                      .append(" - ")
                      .append(referenceReceipt.getRoomNumber())
                      .append("\n");

            } else {

                result.append("REGULAR: ")
                      .append(receipt.getMemberId())
                      .append("\n");
            }
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {

        LoanReceipt r = new LoanReceipt(
                "LIB-8841",
                new String[]{"BK-100", "BK-101"}
        );

        String[] ids = r.getBookIds();
        ids[0] = "HACKED";
        System.out.println(r.getBookIds()[0]);

        LoanReceipt corrected = r.withCorrectedBookId(1, "BK-102");
        System.out.println(r.getBookIds()[1]);
        System.out.println(corrected.getBookIds()[1]);

        LoanReceipt[] receipts = {
                new ReferenceOnlyLoanReceipt(
                        "LIB-001",
                        new String[]{"BK-200"},
                        "Reading Room 3"
                ),
                null,
                new LoanReceipt(
                        "LIB-002",
                        new String[]{"BK-201"}
                )
        };

        System.out.println(
                processNightlyCirculation(receipts)
        );

        System.out.println(
                CirculationLedger.getBranchCode()
        );
    }
}

