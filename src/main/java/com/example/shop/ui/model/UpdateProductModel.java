package com.example.shop.ui.model;

import com.example.shop.enums.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateProductModel {
    private Integer productId;

    private String productName;

    private Double price;
    private Size size;

    private Integer quantity;

    private Integer color;

    private String material;
}
