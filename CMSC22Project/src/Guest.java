
public class Guest {

	private boolean isMember;
	private boolean willMassage;
	public boolean isWillMassage() {
		return willMassage;
	}
	public void setWillMassage(boolean willMassage) {
		this.willMassage = willMassage;
	}
	public Guest(boolean isMember, boolean willMassage) {
		super();
		this.isMember = isMember;
		this.willMassage = willMassage;
	}
	public static int guestCount;
	public Guest(boolean isMember) {
		super();
		this.isMember = isMember;
	}
	public boolean isMember() {
		return isMember;
	}
	public void setMember(boolean isMember) {
		this.isMember = isMember;
	}
	public static int getGuestCount() {
		return guestCount;
	}
	public static void setGuestCount(int guestCount) {
		Guest.guestCount = guestCount;
	}
	
	
}
