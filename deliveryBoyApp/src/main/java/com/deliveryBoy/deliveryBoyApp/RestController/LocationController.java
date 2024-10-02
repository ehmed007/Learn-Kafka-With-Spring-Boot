package com.deliveryBoy.deliveryBoyApp.RestController;


import com.deliveryBoy.deliveryBoyApp.Service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/update")
    public ResponseEntity<?> updateLocation() {
        this.kafkaService.updateLocation("( "+Math.round(Math.random()*100)+" , " + Math.round(Math.random()*100) + ")");
        return new ResponseEntity<>(Map.of("message","Location Updated"), HttpStatus.OK);
    }
}
