package com.garden.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_info")
@Getter
@Setter
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long userId;

    @Column(nullable = false,length = 25)
    private String firstname;
    
    @Column(nullable = false,length = 25)
    private String lastname;
    
    @Column(nullable = false,length = 25)
    private String house;
    
    @Column(nullable = false,length = 25)
    private String street;
    
    

    @Column( nullable = false,length = 25)
    private String dist;

    @Column(nullable = false,unique = true)
    private String email;

    

    @Column(nullable = false,length = 6)
    private String pin;

    @Column(nullable = false,unique = true)
    private String phone;

    @Column(name = "CreateAt",nullable = false)
    private Date date;

    private boolean active;

//    @OneToOne(mappedBy = "user")
//    private Cart cart;
//
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Role> role = new HashSet<>();
    
    

 
    
}