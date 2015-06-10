package net.mnknowledge.designpatterns.creational.homework;

public class LotusDominoVendor extends AbstractVendor {
	private static String NAME = "Lotus Domino";
	private LotusDominoVendor() {
		super(NAME);
	}
	
	private volatile static LotusDominoVendor UNIQUE_INSTANCE = new LotusDominoVendor();
	
	public static LotusDominoVendor getInstance(){
		return UNIQUE_INSTANCE;
	}
	
	@Override
	public void sendEmail(Email email) {
		System.out.println("Sending email using Lotus Domino " + email.toString());
		System.out.println("Lotus Domino doing some stuff");
		System.out.println("Successful sending");
	}

}
