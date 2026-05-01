package com.team404.visualwith.dto.todo;

public class TodoAddResponse {
    private Long id;

    public TodoAddResponse() {}

    public TodoAddResponse(Long id) {
        this.id = id;
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}
}
