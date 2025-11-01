package com.team404.visualwith.dto;

public class LoginRequest {
    private String userId;
    private String password;

    public LoginRequest() {}

    public String getUserId() {return userId;}
    public String getPassword() {return password;}

    public void setUserId(String userId) {this.userId = userId;}
    public void setPassword(String password) {this.password = password;}
}
