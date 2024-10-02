package com.endUser.endUserApp.Config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConfig {

    private Logger logger = LoggerFactory.getLogger(KafkaConfig.class);

    @KafkaListener(topics = AppConstants.LOCATION_TOPIC_NAME, groupId = AppConstants.GROUP_ID)
    public void updateLocation(String value) {
        System.out.println("Value : "+ value);
        logger.info(value);
    }
}
