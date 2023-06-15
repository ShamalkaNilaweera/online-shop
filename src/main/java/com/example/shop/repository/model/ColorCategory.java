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
@Table(name = "color_category")
public class ColorCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Color_Id")
    private Integer colorId;

    @JoinColumn(name = "Product_Id", referencedColumnName = "Product_Id")
    @ManyToOne(optional = false)
    private Product productId;

    @Column(name = "Color_Name")
    @Basic(optional = false)
    private Integer colorName;

    @Column(name = "Quantity")
    @Basic(optional = false)
    private Integer quantity;
}
