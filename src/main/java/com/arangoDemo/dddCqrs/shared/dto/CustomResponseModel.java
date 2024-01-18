package com.arangoDemo.dddCqrs.shared.dto;

import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Builder
public class CustomResponseModel<T> {
    private T data;
    private boolean isSuccess = false;
    private String message = "";
    private int statusCode = 404;

    @Override
    public String toString() {
        return "CustomResponseModel{" +
                "data=" + data +
                ", isSuccess=" + isSuccess +
                ", errorMessage='" + message + '\'' +
                ", statusCode=" + statusCode +
                '}';
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public static <T> ResponseEntity<CustomResponseModel<T>> wrapWithData(T data) {
        CustomResponseModel<T> customResponseModel = CustomResponseModel.<T>builder()
                .data(data)
                .isSuccess(true)
                .message("Success!")
                .statusCode(HttpStatus.OK.value())
                .build();

        return ResponseEntity.ok(customResponseModel);
    }

    public static <T> ResponseEntity<CustomResponseModel<T>> wrapSuccessWithData(T data, String operation) {
        CustomResponseModel<T> customResponseModel = CustomResponseModel.<T>builder()
                .data(data)
                .isSuccess(true)
                .message(operation + " operation successful!")
                .statusCode(HttpStatus.OK.value())
                .build();

        return ResponseEntity.ok(customResponseModel);
    }

    public static <T> ResponseEntity<CustomResponseModel<T>> wrapCreateSuccess(T data) {
        CustomResponseModel<T> customResponseModel = CustomResponseModel.<T>builder()
                .data(data)
                .isSuccess(true)
                .message("Create operation successful!")
                .statusCode(HttpStatus.CREATED.value())
                .build();

        return ResponseEntity.ok(customResponseModel);
    }

    public static <T> ResponseEntity<CustomResponseModel<T>> wrapUpdateSuccess(T data) {
        return wrapSuccessWithData(data, "Update");
    }

    public static <T> ResponseEntity<CustomResponseModel<T>> wrapDeleteSuccess() {
        CustomResponseModel<T> customResponseModel = CustomResponseModel.<T>builder()
                .isSuccess(true)
                .message("Delete operation successful!")
                .statusCode(HttpStatus.OK.value())
                .build();

        return ResponseEntity.ok(customResponseModel);
    }

    public static <T> ResponseEntity<CustomResponseModel<T>> wrapReadSuccess(T data) {
        return wrapSuccessWithData(data, "Read");
    }
}
