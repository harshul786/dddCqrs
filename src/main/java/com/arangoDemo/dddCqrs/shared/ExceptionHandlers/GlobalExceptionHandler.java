package com.arangoDemo.dddCqrs.shared.ExceptionHandlers;

import com.arangoDemo.dddCqrs.shared.dto.CustomResponseModel;
import com.arangodb.ArangoDBException;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.kafka.common.errors.ProducerFencedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.KafkaException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({IllegalArgumentException.class, RuntimeException.class, HttpMediaTypeNotAcceptableException.class})
    public ResponseEntity<CustomResponseModel<?>> handleBadRequestException(Exception ex, HttpServletRequest request) {
        String errorMessage = ex.getMessage();
        Object method = request.getMethod();

        CustomResponseModel<?> errorResponse = CustomResponseModel.<Object>builder()
                .isSuccess(false)
                .message(errorMessage + " " + method)
                .data(null)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(ArangoDBException.class)
    public ResponseEntity<CustomResponseModel<?>> handleArangoDBException(ArangoDBException ex) {
        CustomResponseModel<?> errorResponse = CustomResponseModel.<Object>builder()
                .isSuccess(false)
                .message("ArangoDB Exception: " + ex.getMessage())
                .data(null)
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    @ExceptionHandler(ProducerFencedException.class)
    public ResponseEntity<CustomResponseModel<?>> handleProducerException(ProducerFencedException ex) {
        CustomResponseModel<?> errorResponse = CustomResponseModel.<Object>builder()
                .isSuccess(false)
                .message("Kafka Producer Exception: " + ex.getMessage())
                .data(null)
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    @ExceptionHandler(KafkaException.class)
    public ResponseEntity<CustomResponseModel<?>> handleKafkaException(KafkaException ex) {
        CustomResponseModel<?> errorResponse = CustomResponseModel.<Object>builder()
                .isSuccess(false)
                .message("Kafka Exception: " + ex.getMessage())
                .data(null)
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomResponseModel<?>> handleGenericException(Exception ex) {
        // Handle generic exceptions
        CustomResponseModel<?> errorResponse = CustomResponseModel.<Object>builder()
                .isSuccess(false)
                .message("Internal Server Error: " + ex.getMessage())
                .data(null)
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}