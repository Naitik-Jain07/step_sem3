class LibraryMember {
    String memberId;
    int borrowLimit;
    private int[] fineHistory = new int[100];
    private int fineCount = 0;

    public LibraryMember(String memberId, int borrowLimit) {
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
    }

    protected void chargeFine(int amount) {
        fineHistory[fineCount] = amount;
        fineCount++;
    }

    public int[] getFineHistory() {
        int[] result = new int[fineCount];

        for (int i = 0; i < fineCount; i++) {
            result[i] = fineHistory[i];
        }

        return result;
    }

    public int getTotalFine() {
        int total = 0;

        for (int i = 0; i < fineCount; i++) {
            total = total + fineHistory[i];
        }

        return total;
    }
}

class StudentMember extends LibraryMember {
    String course;

    public StudentMember(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }

    protected void chargeFine(int amount) {
        super.chargeFine(amount / 2);
    }
}

public class third{
    public static void main(String[] args) {

        StudentMember s = new StudentMember("STU5", 3, "CSE");

        s.chargeFine(100);

        System.out.println(s.getTotalFine());

        int[] history = s.getFineHistory();

        history[0] = 999;

        int[] newHistory = s.getFineHistory();

        System.out.println(newHistory[0]);
    }
}