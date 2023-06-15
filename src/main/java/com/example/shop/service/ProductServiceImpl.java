package com.example.shop.service;

import com.example.shop.exception.ResourceNotFoundException;
import com.example.shop.repository.ProductCatelogueRepository;
import com.example.shop.repository.ProductRepository;
import com.example.shop.repository.model.Product;
import com.example.shop.repository.model.ProductCatalogue;
import com.example.shop.ui.model.CreateProductModel;
import com.example.shop.ui.model.FilterProductsModel;
import com.example.shop.ui.model.UpdateProductModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductCatelogueRepository productCatelogueRepository;
    @Autowired
    ProductCatalogueFilterCriteria productCatalogueCriteria;
    ModelMapper modelMapper;

    public ProductServiceImpl(){
        modelMapper =  new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT).setSkipNullEnabled(true);
    }

    @Override
    public Product insertProduct(CreateProductModel createProductModel) {
        Product newProduct = productRepository.save(modelMapper.map(createProductModel, Product.class));
        return newProduct;
    }

    @Override
    public List<ProductCatalogue> getProducts() {
        List<ProductCatalogue> products = productCatelogueRepository.findAll();
        if (products.isEmpty()){
            throw new ResourceNotFoundException("No products found");
        }else {
            return products;
        }
    }

    @Override
    public Product deleteProduct(Integer productId) {
        if (!productRepository.findById(productId).isEmpty()){
            Product product = productRepository.findById(productId).get();
            productRepository.delete(product);
            return product;
        }else {
            throw new ResourceNotFoundException("No product found for Id: " + productId);
        }
    }

    @Override
    public Product updateProduct(UpdateProductModel updateProductModel) {
        if (!productRepository.findById(updateProductModel.getProductId()).isEmpty()){
            Product product = productRepository.findById(updateProductModel.getProductId()).get();
            modelMapper.map(updateProductModel , product);
            productRepository.save(product);
            return product;
        }else {
            throw new ResourceNotFoundException("No product found for Id: " + updateProductModel.getProductId());
        }
    }

    @Override
    public List<ProductCatalogue> searchProduct(FilterProductsModel filterProductsModel) {
        List<ProductCatalogue> products = productCatalogueCriteria.filterProducts(filterProductsModel);
        if(products.isEmpty()){
            throw new ResourceNotFoundException("No products found!");
        }else {
            return products;
        }
    }
}
