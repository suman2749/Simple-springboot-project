package com.account.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "city")
    private String city;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "branch", nullable = false)
    private String branch;

    @Column(name = "mobile", nullable = false, unique = true, length = 10)
    private String mobile;


    @Column(name = "email", nullable = false, unique = true)
    private String email;


}