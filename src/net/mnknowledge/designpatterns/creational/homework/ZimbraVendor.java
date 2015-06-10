package net.mnknowledge.designpatterns.creational.homework;

public class ZimbraVendor extends AbstractVendor {
	private static String NAME = "Zimbra";
	private ZimbraVendor() {
		super(NAME);
	}
	
	private volatile static ZimbraVendor UNIQUE_INSTANCE = new ZimbraVendor();
	
	public static ZimbraVendor getInstance(){
		return UNIQUE_INSTANCE;
	}
	
	@Override
	public void sendEmail(Email email) {
		System.out.println("Sending email using Zimbra " + email.toString());
		System.out.println("Doing some Zimbra stuff");
		System.out.println("Successful sending");
	}

}
