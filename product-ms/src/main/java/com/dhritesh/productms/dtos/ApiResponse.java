package com.dhritesh.productms.dtos;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
    private boolean status;
    private String message;
    private Object data;
    private Map<String,String> error;
    public ApiResponse(boolean status, String message) {
        this.status = status;
        this.message = message;
    }
    public ApiResponse(boolean status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
    public ApiResponse(boolean status, String message, Map<String,String> error) {
        this.status = status;
        this.message = message;
        this.error = error;
    }
}
