public class LibraryMember{
    private int membershipPin;
    int branchCode; //default
    protected double finesOwed;
    public String displayName;

    public LibraryMember(int membershipPin,int branchCode , double finesOwed,String displayName){
        this.membershipPin = membershipPin;
        this.branchCode = branchCode;
        this.finesOwed = finesOwed;
        this.displayName = displayName;
    }
}