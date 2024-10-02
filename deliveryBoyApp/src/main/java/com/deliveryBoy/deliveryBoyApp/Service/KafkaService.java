package com.deliveryBoy.deliveryBoyApp.Service;

import com.deliveryBoy.deliveryBoyApp.Config.AppConstants;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class KafkaService {

    private Logger logger = LoggerFactory.getLogger(KafkaService.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public Boolean updateLocation(String location) {
        this.kafkaTemplate.send(AppConstants.LOCATION_TOPIC_NAME, location);
        this.logger.info("Message Produced..");
        return true;
    }
}
