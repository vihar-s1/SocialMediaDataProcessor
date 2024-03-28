package com.VersatileDataProcessor.ElasticsearchWriter.controller;

import com.VersatileDataProcessor.ElasticsearchWriter.models.MessageType;
import com.VersatileDataProcessor.ElasticsearchWriter.models.MyResponseBody;
import com.VersatileDataProcessor.ElasticsearchWriter.models.processedMessages.MessageInterface;
import com.VersatileDataProcessor.ElasticsearchWriter.repositories.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.RefreshPolicy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class ElasticsearchController {

    @Autowired
    private MessageRepository messageRepository;

    @PostMapping("/add")
    public ResponseEntity<MyResponseBody<Object>> addMessage(@RequestBody MessageInterface message) {
        try {
            if (message == null || message.getId() == null) {
                log.info(
                        "[POST /api/add] failed with error-code=[{}] : id was either empty or null : dataType=[{}]",
                        HttpStatus.BAD_REQUEST,
                        message == null ? "null" : message.getMessageType()
                );
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                        new MyResponseBody<>("Validation Failed. Id cannot be empty or null", false, message)
                );
            }

            if (messageRepository.findById(message.getId()).isPresent()) {
                log.info(
                        "[POST /api/add] failed with error-code=[{}] : resource already exists : dataType=[{}]",
                        HttpStatus.CONFLICT,
                        message.getMessageType()
                );
                return ResponseEntity.status(HttpStatus.CONFLICT).body(
                        new MyResponseBody<>("The resource you are trying to create already exists", false, message)
                );
            }

            MessageInterface savedMessage = messageRepository.save(message);
            log.info(
                    "[POST /api/add] Successful with return-code=[{}] : dataType=[{}]",
                    HttpStatus.OK,
                    message.getMessageType()
            );
            return ResponseEntity.status(HttpStatus.OK).body(
                    new MyResponseBody<>("The resource was created successfully", true, savedMessage)
            );
        } catch (Exception exception) {
            log.error(
                    "Error Processing [POST /api/add] : Exception=[{}] : Message=[{}] : dataType=[{}]",
                    exception.getClass().getSimpleName(),
                    exception.getMessage(),
                    message == null ? "null" : message.getMessageType()
            );
            log.debug(
                    "Error Occurred for Object=[{}]", message
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new MyResponseBody<>("Internal Server Error !", false, null)
            );
        }
    }
}