package com.example.shop.repository.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "product_catalogue")
public class ProductCatalogue {
    @Id
    @Column(name = "Product_Id")
    private Integer productId;

    @Column(name = "Product_Name")
    private String productName;

    @Column(name = "Price")
    private Double productPrice;

    @Column(name = "Color")
    private String color;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "Size")
    private String size;
}
