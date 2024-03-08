package com.org.altech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.org.altech.entity.Device;
import com.org.altech.repository.DeviceRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class DeviceService {

    @Value("${api.url}") // Inject API URL from application.properties
    private String apiUrl;

    private final RestTemplate restTemplate;
    
    @Autowired
    private final DeviceRepository deviceRepository;

    public DeviceService(RestTemplate restTemplate, DeviceRepository deviceRepository) {
        this.restTemplate = restTemplate;
		this.deviceRepository = deviceRepository;
    }

    public int numDevices(String statusQuery, int threshold, String dateStr) {
        // Make HTTP request to the REST API endpoint
        Device[] devices = restTemplate.getForObject(apiUrl, Device[].class);

        // Filter devices based on status query, threshold, and date
        List<Device> filteredDevices = filterDevices(devices, statusQuery, threshold, dateStr);

        // Return the total count of matching devices
        return filteredDevices.size();
    }

    private List<Device> filterDevices(Device[] devices, String statusQuery, int threshold, String dateStr) {
        // Implement filtering logic based on status query, threshold, and date
        // You can iterate through the devices array and apply the filtering criteria
        // Return the filtered list of devices
        // This is just a placeholder method, you need to implement the actual filtering logic
        return Arrays.asList(devices);
    }
    
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    public Device getDeviceById(Long id) {
        return deviceRepository.findById(id).orElse(null);
    }

    public Device createDevice(Device device) {
        return deviceRepository.save(device);
    }

    public Device updateDevice(Long id, Device newDeviceData) {
        Device existingDevice = deviceRepository.findById(id).orElse(null);
        if (existingDevice != null) {
            // Update existing device with new data
            existingDevice.setStatus(newDeviceData.getStatus());
            existingDevice.setTimestamp(newDeviceData.getTimestamp());
            existingDevice.setOperatingParameters(newDeviceData.getOperatingParameters());
            existingDevice.setAsset(newDeviceData.getAsset());
            existingDevice.setParent(newDeviceData.getParent());
            return deviceRepository.save(existingDevice);
        }
        return null; // Handle error - Device not found
    }

    public void deleteDevice(Long id) {
        deviceRepository.deleteById(id);
    }
    
}

