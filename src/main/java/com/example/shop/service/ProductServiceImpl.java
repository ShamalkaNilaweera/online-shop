package com.example.shop.service;

import com.example.shop.exception.ResourceNotFoundException;
import com.example.shop.repository.*;
import com.example.shop.repository.model.Product;
import com.example.shop.repository.model.ProductCatalogue;
import com.example.shop.ui.model.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductCatelogueRepository productCatelogueRepository;

    @Autowired
    ColorRepository colorRepository;
    @Autowired
    ProductCatalogueFilterCriteria productCatalogueCriteria;
    ModelMapper modelMapper;

    private String uploadDir = "C:/Users/User1/Desktop/C8Img";

    public ProductServiceImpl(){
        modelMapper =  new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT).setSkipNullEnabled(true);
        modelMapper.typeMap(CreateProductModel.class, Product.class)
                .addMappings(mapper -> mapper.skip(Product::setColor));
    }

    @Override
    public Product insertProduct(CreateProductModel createProductModel) {
        Product newProduct = modelMapper.map(createProductModel, Product.class);
        newProduct.setColor(colorRepository.findById(createProductModel.getColorId()).get());
        productRepository.save(newProduct);
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
        if (productRepository.findById(productId).isPresent()){
            Product product = productRepository.findById(productId).get();
            productRepository.delete(product);
            return product;
        }else {
            throw new ResourceNotFoundException("No product found for Id: " + productId);
        }
    }

    @Override
    public Product updateProduct(UpdateProductModel updateProductModel) {
        if (productRepository.findById(updateProductModel.getProductId()).isPresent()){
            Product product = productRepository.findById(updateProductModel.getProductId()).get();
            modelMapper.map(updateProductModel , product);
            product.setColor(colorRepository.findById(updateProductModel.getColor()).get());
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

    @Override
    public Product getProduct(Integer productId) {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()){
            return product.get();
        }else {
            //TODO
            return null;
        }
    }

    @Override
    public String uploadImg(Integer productId, MultipartFile file) throws IOException {
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String fileName = file.getOriginalFilename();
        Path filePath = uploadPath.resolve(fileName);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return filePath.toString();
    }

    @Override
    public Resource getProductImage(Integer productId) throws MalformedURLException {
        Path path = Paths.get(uploadDir +"/"+ productId + "-img.png");
        Resource resource = new UrlResource(path.toUri());
        return resource;
    }
}
