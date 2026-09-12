import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LibraryMember1 {

    private String membershipId;
    private String name;
    private boolean premiumMember;
    private String securityAnswerHash;

    // Public no-argument constructor
    public LibraryMember1() {
    }

    // Write-once property
    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String id) {
        if (membershipId == null) {
            membershipId = id;
        }
    }

    // Ordinary JavaBean property
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Boolean JavaBean property uses isX()
    public boolean isPremiumMember() {
        return premiumMember;
    }

    public void setPremiumMember(boolean premium) {
        this.premiumMember = premium;
    }

    // Write-only property: NO getter
    public void setSecurityAnswer(String answer) {
        securityAnswerHash = hashAnswer(answer);
    }

    // Private helper method, not a getter
    private String hashAnswer(String answer) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(answer.getBytes());

            StringBuilder result = new StringBuilder();

            for (byte b : hash) {
                result.append(String.format("%02x", b));
            }

            return result.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}