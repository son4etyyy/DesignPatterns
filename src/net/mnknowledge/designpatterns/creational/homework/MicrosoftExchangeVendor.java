package net.mnknowledge.designpatterns.creational.homework;

public class MicrosoftExchangeVendor extends AbstractVendor {
	private static String NAME = "Microsoft exchange";
	private MicrosoftExchangeVendor() {
		super(NAME);
	}
	
	private volatile static MicrosoftExchangeVendor UNIQUE_INSTANCE = new MicrosoftExchangeVendor();
	
	public static MicrosoftExchangeVendor getInstance(){
		return UNIQUE_INSTANCE;
	}

	@Override
	public void sendEmail(Email email) {
		System.out.println("Sending email using Microsoft exchange " + email.toString());
		System.out.println("Doing some Microsoft stuff");
		System.out.println("Successful sending");
	}
	
}
