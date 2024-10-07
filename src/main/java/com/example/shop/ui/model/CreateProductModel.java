package com.example.shop.ui.model;

import com.example.shop.enums.Size;
import com.example.shop.repository.model.Color;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateProductModel {

    private String productName;

    private Double price;

    private String material;

    private Size size;

    private Integer quantity;

    private Color color;
}
