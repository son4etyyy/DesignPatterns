package net.mnknowledge.designpatterns.creational.homework;

public class EmailBuilder {
	private String vendor;
	private String from;
	private String to;
	private String cc;
	private String subject;
	private String content;
	private String attachments;

	public void withVendor(String vendor) {
		this.vendor = vendor;
	}

	public void withFrom(String from) {
		this.from = from;
	}

	public void withTo(String to) {
		this.to = to;
	}

	public void withCc(String cc) {
		this.cc = cc;
	}

	public void withSubject(String subject) {
		this.subject = subject;
	}

	public void withContent(String content) {
		this.content = content;
	}

	public void withAttachments(String attachments) {
		this.attachments = attachments;
	}

	public Email build() {
		return new Email(vendor, from, to, cc, subject, content, attachments);
	}

}
