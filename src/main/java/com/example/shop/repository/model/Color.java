package com.example.shop.repository.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "color")
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Color_Id")
    private Integer colorId;

    @Column(name = "Color_Name")
    @Basic(optional = false)
    private String color;

    public Color(String colorName){
        this.color=colorName;
    }
}
