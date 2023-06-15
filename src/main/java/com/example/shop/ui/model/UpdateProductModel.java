package com.example.shop.ui.model;

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

    private Integer productPrice;
}
