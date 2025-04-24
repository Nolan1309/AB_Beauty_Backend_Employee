package com.example.employee.dto.auth;

import java.io.Serializable;
import java.util.Date;

public class LoginResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private int status;
    private String message;
    private Data data;
    private Date timestamp;

    public LoginResponse(int status, String message, Data data, Date timestamp) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public static class Data {
        private String accessToken;
        private String refreshToken;
        private String roles;
        private String userName;
        private String email;

        public Data(String accessToken, String refreshToken, String roles, String userName, String email) {
            this.accessToken = accessToken;
            this.refreshToken = refreshToken;
            this.roles = roles;
            this.userName = userName;
            this.email = email;
        }

        public Data(String accessToken, String refreshToken, String roles) {
            this.accessToken = accessToken;
            this.refreshToken = refreshToken;
            this.roles = roles;
        }

        // Getters and Setters
        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public String getRefreshToken() {
            return refreshToken;
        }

        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }

        public String getRoles() {
            return roles;
        }

        public void setRoles(String roles) {
            this.roles = roles;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}