package net.mnknowledge.designpatterns.creational.homework;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VendorsPool {
	private List<AbstractVendor> vendors = (List<AbstractVendor>) Arrays
			.asList(MicrosoftExchangeVendor.getInstance(),
					LotusDominoVendor.getInstance(), ZimbraVendor.getInstance());
	private Map<String, AbstractVendor> vendorNameToVendor = new ConcurrentHashMap<String, AbstractVendor>();
	private Map<String, Integer> vendorNameToUsedConnections = new ConcurrentHashMap<String, Integer>();
	private final int maxSize = 5;
	private final int maxSizeHighTraffic = 10;

	public VendorsPool() {
		init();
	}

	private void init() {
		for (AbstractVendor vendor : vendors) {
			vendorNameToVendor.put(vendor.getName(), vendor);
			vendorNameToUsedConnections.put(vendor.getName(), 0);
		}
	}

	public void releaseConnectionOfVendor(String vendorName) {
		int cnt = vendorNameToUsedConnections.get(vendorName);
		vendorNameToUsedConnections.put(vendorName, cnt - 1);
	}

	public boolean isFreeConnection(String vendorName) {
		int curr = vendorNameToUsedConnections.get(vendorName);
		if (curr < maxSizeHighTraffic) {
			return true;
		}
		return false;
	}

	public AbstractVendor acquireConnectionToVendor(String vendorName) {
		int curr = vendorNameToUsedConnections.get(vendorName);
		if (curr < maxSize) {
			vendorNameToUsedConnections.put(vendorName, curr + 1);
		} else if (curr < maxSizeHighTraffic) {
			System.out.println("There is high traffic!");
			vendorNameToUsedConnections.put(vendorName, curr + 1);
		}
		return vendorNameToVendor.get(vendorName);
	}

}
