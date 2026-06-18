package com.team404.visualwith.dto;

public class LoginResponse {
    private String userId;
    private String userName;
    private String userEmail;
    private String token;
    private String message;

    public LoginResponse(String userId, String userName, String userEmail, String token, String message) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.token = token;
        this.message = message;
    }

    public String getUserId() {return userId;}
    public String getToken() {return token;}
    public String getMessage() {return message;}
    public String getName() {return userName;}
    public String getUserEmail() {return userEmail;}
}
