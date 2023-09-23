package com.deviceManagement.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deviceManagement.model.Device;
/*
 parameters: model class name and primary key return value
 return value:
 */
@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer> {

}
