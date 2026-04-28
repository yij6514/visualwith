package com.team404.visualwith.dto.todo;

public class TodoAddResponse {
    private String id;

    public TodoAddResponse() {}

    public TodoAddResponse(String id) {
        this.id = id;
    }

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}
}
