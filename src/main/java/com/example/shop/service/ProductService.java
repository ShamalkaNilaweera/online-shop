package com.example.shop.service;

import com.example.shop.repository.model.Product;
import com.example.shop.repository.model.ProductCatalogue;
import com.example.shop.ui.model.CreateProductModel;
import com.example.shop.ui.model.FilterProductsModel;
import com.example.shop.ui.model.UpdateProductModel;

import java.util.List;

public interface ProductService {
    Product insertProduct(CreateProductModel createProductModel);

    List<ProductCatalogue> getProducts();

    Product deleteProduct(Integer productId);

    Product updateProduct(UpdateProductModel updateProductModel);

    List<ProductCatalogue> searchProduct(FilterProductsModel filterProductsModel);
}
