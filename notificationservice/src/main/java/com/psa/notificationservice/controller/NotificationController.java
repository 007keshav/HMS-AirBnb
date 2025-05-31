package com.psa.notificationservice.controller;

import com.psa.notificationservice.dto.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class NotificationController {
    @Autowired
    private KafkaTemplate<String, EmailRequest> kafkaTemplate;

    private static final String TOPIC = "send_email";

    @PostMapping("/sendEmail")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request) {
        kafkaTemplate.send(TOPIC, request);
        return ResponseEntity.ok("Email send request sent to Kafka");
    }
}

