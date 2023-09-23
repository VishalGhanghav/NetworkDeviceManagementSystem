package com.deviceManagement.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deviceManagement.model.Device;
import com.deviceManagement.model.DeviceBrandDistribution;
import com.deviceManagement.repository.DeviceRepository;

@RestController
@RequestMapping("/api")
public class DeviceController {

	@Autowired
	DeviceRepository deviceRepository;
	
	//Create new Devices
	@PostMapping("/device")
	public String createNewDevice(@RequestBody Device device) {
		deviceRepository.save(device);
		return "Device created in database";
	}
	
	//Get all devices.Using ResponseEntity for json format
	@GetMapping("/device")
	public ResponseEntity<List<Device>>  getAllDevices() {
		List<Device> devicesList=new ArrayList<Device>();
				deviceRepository.findAll().forEach(devicesList::add);
		return new ResponseEntity<List<Device>>(devicesList,HttpStatus.OK);
	}
	
	//Get Complete device info by id
	@GetMapping("/device/{deviceId}")
	public ResponseEntity<Device> getDeviceInfoById(@PathVariable int deviceId){
		Optional<Device> device= deviceRepository.findById(deviceId);
		if(device.isPresent()) {
			return new ResponseEntity<Device>(device.get(),HttpStatus.OK);
		}else {
			return new ResponseEntity<Device>(HttpStatus.NOT_FOUND);
		}
	}
	
	//update existing device information.
	@PutMapping("/device/{deviceId}")
	public String updateExistingDevice(@PathVariable int deviceId,@RequestBody Device device){
		Optional<Device> optionalDevice= deviceRepository.findById(deviceId);
		if(optionalDevice.isPresent()) {
			Device existingDevice=optionalDevice.get();
			existingDevice.setDeviceBrand(device.getDeviceBrand());
			existingDevice.setDeviceName(device.getDeviceName());
			existingDevice.setDeviceVersion(device.getDeviceVersion());
			existingDevice.setDevicePrice(device.getDevicePrice());
			deviceRepository.save(existingDevice);
			return "Device details against deviceId :"+deviceId+" updated";
		}else {
			return "Device details does not exist for :"+deviceId;
		}
	}
	
	//Delete device by id
	@DeleteMapping("/device/{deviceId}")
	public String deleteDeviceInfoById(@PathVariable int deviceId){
		deviceRepository.deleteById(deviceId);
		return "Device deleted successfully";
	}
	
	//Get Total Number of Devices
	@GetMapping("/device/numberOfDevices")
	public long getTotalDevices() {
		return deviceRepository.count();
	}
	
	//Get Number of devices by Brand
	@GetMapping("/device/brand")
    public DeviceBrandDistribution getDeviceBrandDistribution() {
        List<Device> devices = deviceRepository.findAll();
        Map<String, Integer> brandDeviceMap=new HashMap<String, Integer>();
        for(Device device:devices) {
        	if(brandDeviceMap.containsKey(device.getDeviceBrand())) {
        		brandDeviceMap.put(device.getDeviceBrand(), brandDeviceMap.get(device.getDeviceBrand())+1);
        	}else {
        		brandDeviceMap.put(device.getDeviceBrand(), 1);
        	}
        }
        DeviceBrandDistribution deviceBrandDistribution=
        		new DeviceBrandDistribution();
        deviceBrandDistribution.setDeviceBrandDistribution(brandDeviceMap);
        return deviceBrandDistribution;
    }
}
