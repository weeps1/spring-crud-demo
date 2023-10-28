package com.luv2code.cruddemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "milk")
public class Milk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "milk_type")
    private String milkType;

    @Column(name = "restaurant")
    private String restaurant;

    @Column(name = "email")
    private String email;

    public Milk(String milkType, String restaurant, String email) {
        this.milkType = milkType;
        this.restaurant = restaurant;
        this.email = email;
    }
}
