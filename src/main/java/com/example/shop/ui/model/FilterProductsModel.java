package com.example.shop.ui.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FilterProductsModel {
    private String productName;

    private Integer productPriceMoreThan;

    private Integer productPriceLessThan;

    private String colorName;
}
