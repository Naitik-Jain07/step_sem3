class PlacementRecord {
    String studentName;
    String company;
    double packageLpa;

    PlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    void printRecord() {
        System.out.println("Student: " + studentName +
                " | Company: " + company +
                " | Package: " + packageLpa + " LPA");
    }
}

public class PlacementDemo {
    public static void main(String[] args) {

        PlacementRecord[] records = {
            new PlacementRecord("Rahul", "Google", 18.5),
            new PlacementRecord("Priya", "Microsoft", 16.0),
            new PlacementRecord("Arjun", "Amazon", 14.5)
        };

        for (PlacementRecord record : records) {
            record.printRecord();
        }
    }
}