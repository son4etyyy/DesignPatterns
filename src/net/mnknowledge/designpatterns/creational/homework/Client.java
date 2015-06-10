package net.mnknowledge.designpatterns.creational.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Client {
	private static EmailSender emailSender = new EmailSender();
	
	private static boolean isNothing(String word) {
		if(word.equals("nothing")) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		System.out.println("Enter the information for te email you want to send. If you don't want to give specifications for any of the parameters write \"nothing\".");
		System.out.println("Obligotory write the vendor name!A NullPointerException can occur when the vendor is not set correctly.");
		String line;
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Write \"SendEmail\" to send an email and press enter!");
		while((line = input.readLine()) != null && line.equals("SendEmail")) {
			EmailBuilder emailBuilder = new EmailBuilder();
			System.out.println("vendor = ");
			line = input.readLine();
			if(!isNothing(line)) {
				emailBuilder.withVendor(line);
			}
			System.out.println("from = ");
			line = input.readLine();
			if(!isNothing(line)) {
				emailBuilder.withFrom(line);
			}
			System.out.println("to = ");
			line = input.readLine();
			if(!isNothing(line)) {
				emailBuilder.withTo(line);
			}
			System.out.println("cc = ");
			line = input.readLine();
			if(!isNothing(line)) {
				emailBuilder.withCc(line);
			}
			System.out.println("subject = ");
			line = input.readLine();
			if(!isNothing(line)) {
				emailBuilder.withSubject(line);
			}
			System.out.println("content = ");
			line = input.readLine();
			if(!isNothing(line)) {
				emailBuilder.withContent(line);
			}
			System.out.println("attachments = ");
			line = input.readLine();
			if(!isNothing(line)) {
				emailBuilder.withAttachments(line);
			}
			
			Email email = emailBuilder.build();
			try {
				emailSender.sendEmail(email.getVendorName(), email);
			} catch (InterruptedException e) {
				System.err.println("Some error occured");
				e.printStackTrace();
			}
			
			System.out.println("Write \"SendEmail\" to send an email!");
		}

	}

}
