package net.mnknowledge.designpatterns.creational.homework;

public class Email {
	private String vendorName;
	private String from;
	private String to;
	private String cc;
	private String subject;
	private String content;
	private String attachments;

	public Email(String vendorName, String from, String to, String cc,
			String subject, String content, String attachments) {
		this.vendorName = vendorName;
		this.from = from;
		this.to = to;
		this.cc = cc;
		this.subject = subject;
		this.content = content;
		this.attachments = attachments;
	}

	public String getVendorName() {
		return vendorName;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public String getCc() {
		return cc;
	}

	public String getSubject() {
		return subject;
	}

	public String getContent() {
		return content;
	}

	public String getAttachments() {
		return attachments;
	}

	@Override
	public String toString() {
		return String
				.format("Email [vendorName=%1$s, from=%2$s, to=%3$s, cc=%4$s, subject=%5$s, content=%6$s, attachments=%7$s]",
						vendorName, from, to, cc, subject, content, attachments);
	}

}
