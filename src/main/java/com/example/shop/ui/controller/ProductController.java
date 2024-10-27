package com.example.shop.ui.controller;

import com.example.shop.repository.model.Product;
import com.example.shop.repository.model.ProductCatalogue;
import com.example.shop.service.ProductService;
import com.example.shop.ui.model.CreateProductModel;
import com.example.shop.ui.model.FilterProductsModel;
import com.example.shop.ui.model.UpdateProductModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.hibernate.annotations.OptimisticLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping(path = "/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Operation(summary = "Create new product")
    @ApiResponse(responseCode = "200", description = "Saved new product successfully")
    @PostMapping
    public ResponseEntity<?> insertProduct (@RequestBody CreateProductModel createProductModel){
        try {
            Product product = productService.insertProduct(createProductModel);
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception);
        }
    }

    @Operation(summary = "Retrieve all products")
    @ApiResponse(responseCode = "200", description = "Retrieved all products successfully")
    @GetMapping(path = "/products")
    public ResponseEntity<?> getProducts (){
        try {
            List<ProductCatalogue> products = productService.getProducts();
            return ResponseEntity.status(HttpStatus.OK).body(products);
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception);
        }
    }

    @Operation(summary = "Delete a product")
    @ApiResponse(responseCode = "200", description = "Deleted a product successfully")
    @DeleteMapping(path = "/deleteProduct/{productId}")
    public ResponseEntity<?> deleteProduct (@PathVariable Integer productId){
        try {
            Product product = productService.deleteProduct(productId);
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception);
        }
    }

    @Operation(summary = "Update a product")
    @ApiResponse(responseCode = "200", description = "Updated product successfully")
    @PutMapping
    public ResponseEntity<?> updateProduct (@RequestBody UpdateProductModel updateProductModel){
        try {
            Product product = productService.updateProduct(updateProductModel);
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception);
        }
    }

    @Operation(summary = "Search products")
    @ApiResponse(responseCode = "200", description = "Searched products successfully")
    @PostMapping(path = "/search")
    public ResponseEntity<?> searchProducts (@RequestBody FilterProductsModel filterProductsModel){
        try {
            List<ProductCatalogue> productResults = productService.searchProduct(filterProductsModel);
            return ResponseEntity.status(HttpStatus.OK).body(productResults);
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception);
        }
    }

    @Operation(summary = "Get a product")
    @ApiResponse(responseCode = "200", description = "Retrieved product successfully")
    @GetMapping(path = "/{productId}")
    public ResponseEntity<?> getProduct (@PathVariable Integer productId){
        try {
            Product product = productService.getProduct(productId);
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception);
        }
    }
}
