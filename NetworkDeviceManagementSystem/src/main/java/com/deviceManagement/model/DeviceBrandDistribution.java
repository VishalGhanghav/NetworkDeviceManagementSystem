package com.deviceManagement.model;

import java.util.Map;

public class DeviceBrandDistribution {
    private Map<String, Integer> deviceBrandDistribution;
    
	public Map<String, Integer> getDeviceBrandDistribution() {
		return deviceBrandDistribution;
	}
	public void setDeviceBrandDistribution(Map<String, Integer> deviceBrandDistribution) {
		this.deviceBrandDistribution = deviceBrandDistribution;
	}
	public DeviceBrandDistribution(Map<String, Integer> deviceBrandDistribution) {
		super();
		this.deviceBrandDistribution = deviceBrandDistribution;
	}
	
	public DeviceBrandDistribution() {
		
	}

    
}
