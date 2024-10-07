package com.example.shop.repository.model;

import com.example.shop.enums.Size;
import javax.persistence.*;

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

    @Column(name = "Price")
    @Basic(optional = false)
    private Integer price;

    @Column(name = "Material")
    @Basic(optional = false)
    private String material;

    @Column(name = "Size")
    @Basic(optional = false)
    @Enumerated
    private Size size;

    @ManyToOne
    @Basic(optional = false)
    private Color color;
}
