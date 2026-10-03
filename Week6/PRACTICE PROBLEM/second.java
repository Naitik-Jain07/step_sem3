class LibraryMember {
    String memberId;
    int borrowLimit;
    int booksBorrowed = 0;
    public LibraryMember(String memberId, int borrowLimit) {
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
    }
    public void borrowBook() {
        if (booksBorrowed < borrowLimit) {
            booksBorrowed++;
        }
    }
    public int getBooksBorrowed() {
        return booksBorrowed;
    }
    public String displayInfo() {
        return "General Member | Books Borrowed: " + booksBorrowed;
    }
}

class StudentMember extends LibraryMember {
    String course;
    public StudentMember(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }

    public String displayInfo() {
        return "Student Member | Course: " + course +
               " | Books Borrowed: " + booksBorrowed;
    }
}

class HonorsStudentMember extends StudentMember {
    int bonusLimit;
    public HonorsStudentMember(String memberId, int borrowLimit,
                               String course, int bonusLimit) {
        super(memberId, borrowLimit, course);
        this.bonusLimit = bonusLimit;
    }

    public String displayInfo() {
        return "Honors Student Member | Course: " + course +
               " | Bonus Limit: " + bonusLimit +
               " | Books Borrowed: " + booksBorrowed;
    }
}

class FacultyMember extends LibraryMember {
    String department;
    public FacultyMember(String memberId, int borrowLimit, String department) {
        super(memberId, borrowLimit);
        this.department = department;
    }

    public String displayInfo() {
        return "Faculty Member | Department: " + department +
               " | Books Borrowed: " + booksBorrowed;
    }
}

public class second {

    public static String classifyGeneration(LibraryMember member) {

        if (member instanceof HonorsStudentMember) {
            return "Multilevel descendant (3 generations deep)";
        }

        if (member instanceof FacultyMember) {
            return "Hierarchical sibling (independent branch)";
        }

        return "Student or General Member";
    }

    public static int getTotalBooksBorrowed(LibraryMember[] members) {

        int total = 0;

        for (LibraryMember member : members) {
            total = total + member.getBooksBorrowed();
        }

        return total;
    }
}