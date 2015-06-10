package net.mnknowledge.designpatterns.creational.homework;

public class EmailSender {
	private VendorsPool poolOfVendors = new VendorsPool();
	
	public void sendEmail(String vendorName, Email email) throws InterruptedException {
		if(poolOfVendors.isFreeConnection(vendorName)) {
			AbstractVendor vendor = poolOfVendors.acquireConnectionToVendor(vendorName);
			vendor.sendEmail(email);
			//this is done to have the ability to test the simultaneous behavior of taking connections
			Thread.sleep(10000);
			poolOfVendors.releaseConnectionOfVendor(vendorName);
		}		
	}
}
