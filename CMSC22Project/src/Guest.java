
public class Guest {

	private boolean isMember;
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
