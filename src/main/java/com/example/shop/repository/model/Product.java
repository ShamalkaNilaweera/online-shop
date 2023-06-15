package com.example.shop.repository.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Product_Id")
    private Integer productId;

    @Column(name = "Product_Name")
    @Basic(optional = false)
    private String productName;

    @Column(name = "Product_Price")
    @Basic(optional = false)
    private Integer productPrice;
}
