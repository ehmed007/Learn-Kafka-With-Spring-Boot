package com.deliveryBoy.deliveryBoyApp.RestController;


import com.deliveryBoy.deliveryBoyApp.Service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private KafkaService kafkaService;

    @GetMapping("/")
    public String check() {
        return "Server is running on 8080 port";
    }

    @GetMapping("/update/{data}")
    public ResponseEntity<?> updateLocation(@PathVariable String data) {
        this.kafkaService.updateLocation(data);
        return new ResponseEntity<>(Map.of("message","Location Updated"), HttpStatus.OK);
    }
}
