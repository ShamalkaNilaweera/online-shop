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

    @Column(name = "Product_Price")
    private Integer productPrice;

    @Column(name = "Color_Name")
    private String colorName;

    @Column(name = "Quantity")
    private Integer quantity;
}
