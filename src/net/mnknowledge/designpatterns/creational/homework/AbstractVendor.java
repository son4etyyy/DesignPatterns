package net.mnknowledge.designpatterns.creational.homework;

public abstract class AbstractVendor {
	private String name;

	public AbstractVendor(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public abstract void sendEmail(Email email);
}
