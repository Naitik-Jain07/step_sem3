class GymMember {
    String memberId;
    int monthlyFee;
    int sessionsAttended = 0;
    public GymMember(String memberId, int monthlyFee) {
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
    }
    public void attendSession() {
        sessionsAttended++;
    }
    public int getSessionsAttended() {
        return sessionsAttended;
    }
    public String displayInfo() {
        return "Standard | Sessions: " + sessionsAttended;
    }
}

class PremiumMember extends GymMember {
    String trainerName;
    public PremiumMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    public String displayInfo() {
        return "Premium | Trainer: " + trainerName +
               " | Sessions: " + sessionsAttended;
    }
}

public class fourth {

    public static String batchPrint(GymMember[] members) {

        StringBuilder result = new StringBuilder();

        for (GymMember member : members) {

            // Polymorphism
            result.append(member.displayInfo());

            // Check before downcasting
            if (member instanceof PremiumMember) {
                PremiumMember premium = (PremiumMember) member;

                result.append(" [Trainer via downcast: ");
                result.append(premium.trainerName);
                result.append("]");
            }

            result.append(" | ");
        }

        return result.toString();
    }

    public static void main(String[] args) {

        GymMember[] members = {
            new GymMember("MEM6", 1000),
            new PremiumMember("MEM7", 2000, "Coach Riya")
        };

        System.out.println(batchPrint(members));
    }
}