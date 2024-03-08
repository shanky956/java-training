package com.org.altech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.altech.entity.Device;

public interface DeviceRepository extends JpaRepository<Device, Long> {

}
