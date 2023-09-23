package com.deviceManagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Device")
public class Device {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int device_id; 
	
	@Column(name="device_name")
	private String deviceName; 
	
	@Column(name="device_version")
	private Float deviceVersion; 
	
	@Column(name="device_brand")
	private String deviceBrand; 
	
	@Column(name="device_price")
	private Float devicePrice;
	
	public int getDevice_id() {
		return device_id;
	}
	public void setDevice_id(int device_id) {
		this.device_id = device_id;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public Float getDeviceVersion() {
		return deviceVersion;
	}
	public void setDeviceVersion(Float deviceVersion) {
		this.deviceVersion = deviceVersion;
	}
	public String getDeviceBrand() {
		return deviceBrand;
	}
	public void setDeviceBrand(String deviceBrand) {
		this.deviceBrand = deviceBrand;
	}
	
	public Float getDevicePrice() {
		return devicePrice;
	}
	public void setDevicePrice(Float devicePrice) {
		this.devicePrice = devicePrice;
	}
	
	public Device(int device_id, String deviceName, Float deviceVersion, String deviceBrand, Float devicePrice) {
		super();
		this.device_id = device_id;
		this.deviceName = deviceName;
		this.deviceVersion = deviceVersion;
		this.deviceBrand = deviceBrand;
		this.devicePrice = devicePrice;
	}
	
	@Override
	public String toString() {
		return "Device [device_id=" + device_id + ", deviceName=" + deviceName + ", deviceVersion=" + deviceVersion
				+ ", deviceBrand=" + deviceBrand + ", devicePrice=" + devicePrice + "]";
	} 
	
	public Device(){
		
	}
	
}
