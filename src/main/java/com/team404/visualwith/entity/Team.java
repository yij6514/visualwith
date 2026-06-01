package com.team404.visualwith.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="teams")
@Getter
@AllArgsConstructor
public class Team {
    @Id
    @Column(nullable = false, unique = true)
    private String id;

    @Setter
    @Column(nullable = false)
    private String teamName;

    @Setter
    @Column(nullable = false, name = "creator_id")
    private String createId;

    @Setter
    @Column(name = "team_url", unique = true)
    private String teamUrl;

    @Setter
    @Column(name="url_create_date")
    private LocalDate urlCreateDate;

    public Team() {}
}
