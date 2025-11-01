package com.team404.visualwith.entity;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //사용자 id
    @Column(nullable = false, unique = true)
    private String userId;

    //이메일
    @Column(nullable = false)
    private String email;

    //비밀번호
    @Column(nullable = false)
    private String password;

    //이름
    @Column(nullable = false)
    private String name;

    public User() {}

    public User(String userId, String password, String email, String name) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.name = name;
    }

    //get method
    public Long getId() {return id;}
    public String getUserId() {return userId;}
    public String getEmail() {return email;}
    public String getPassword() {return password;}
    public String getName() {return name;}

    //set method
    //id는 시스템에서 지정이기 때문에 setid는 없음
    public void setUserId(String userId) {this.userId = userId;}
    public void setEmail(String email) {this.email = email;}
    public void setPassword(String password) {this.password = password;}
    public void setName(String name) {this.name = name;}

}
