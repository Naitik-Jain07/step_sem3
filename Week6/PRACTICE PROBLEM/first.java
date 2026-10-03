class LibraryMember {
    String memberId;
    int borrowLimit;
    public LibraryMember(String memberId, int borrowLimit) {
        if (memberId == null || memberId.trim().length() < 4) {
            throw new IllegalArgumentException();
        }
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
    }
}

class StudentMember extends LibraryMember {
    String course;
    int booksBorrowed = 0;

    public StudentMember(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }
    public void borrowBook() {
        if (booksBorrowed < borrowLimit) {
            booksBorrowed++;
        }
    }
    public int getBooksBorrowed() {
        return booksBorrowed;
    }
}

public class first {
    public static String enrollBatch(String[] memberIds, int borrowLimit) {
        int enrolled = 0;
        int rejected = 0;
        for (String id : memberIds) {
            try {
                new LibraryMember(id, borrowLimit);
                enrolled++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        return "Enrolled: " + enrolled + " | Rejected: " + rejected;
    }

    public static void main(String[] args) {
        StudentMember s = new StudentMember("STU10", 3, "CSE");
        s.borrowBook();
        s.borrowBook();
        System.out.println(s.getBooksBorrowed());
        String[] ids = {"STU1", "LB1", "STU2", " ", "STU3"};
        System.out.println(enrollBatch(ids, 3));
    }
}