package com.example.employee.dto;

public class ApiResponse<T> {
    private String message;
    private T data;
    private Integer status;
    
    // Private constructor for builder pattern
    private ApiResponse(Builder<T> builder) {
        this.message = builder.message;
        this.data = builder.data;
        this.status = builder.status;
    }
    
    // Constructor cho tương thích ngược
    public ApiResponse(String message, T data, Integer status) {
        this.message = message;
        this.data = data;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    // Utility methods for creating common responses
    public static <T> ApiResponse<T> success(String message, T data) {
        return new Builder<T>()
                .message(message)
                .data(data)
                .status(200)
                .build();
    }
    
    public static <T> ApiResponse<T> error(String message, Integer status) {
        return new Builder<T>()
                .message(message)
                .status(status)
                .build();
    }
    
    public static <T> ApiResponse<T> notFound(String message) {
        return new Builder<T>()
                .message(message)
                .status(404)
                .build();
    }
    
    // Builder class
    public static class Builder<T> {
        private String message;
        private T data;
        private Integer status;
        
        public Builder<T> message(String message) {
            this.message = message;
            return this;
        }
        
        public Builder<T> data(T data) {
            this.data = data;
            return this;
        }
        
        public Builder<T> status(Integer status) {
            this.status = status;
            return this;
        }
        
        public ApiResponse<T> build() {
            return new ApiResponse<>(this);
        }
    }
}
