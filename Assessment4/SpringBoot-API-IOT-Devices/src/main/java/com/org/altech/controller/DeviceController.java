package com.org.altech.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.org.altech.entity.Device;
import com.org.altech.service.DeviceService;

@RestController
public class DeviceController {

    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("/devices/count")
    public int countDevices(
            @RequestParam String statusQuery,
            @RequestParam int threshold,
            @RequestParam String dateStr
    ) {
        return deviceService.numDevices(statusQuery, threshold, dateStr);
    }
    
    @GetMapping("/devices")
    public List<Device> getAllDevices() {
        return deviceService.getAllDevices();
    }

    @GetMapping("/devices/{id}")
    public Device getDeviceById(@PathVariable Long id) {
        return deviceService.getDeviceById(id);
    }

    @PostMapping("/devices")
    public Device createDevice(@RequestBody Device device) {
        return deviceService.createDevice(device);
    }

    @PutMapping("/devices/{id}")
    public Device updateDevice(@PathVariable Long id, @RequestBody Device device) {
        return deviceService.updateDevice(id, device);
    }

    @DeleteMapping("/devices/{id}")
    public void deleteDevice(@PathVariable Long id) {
        deviceService.deleteDevice(id);
    }
    
}

