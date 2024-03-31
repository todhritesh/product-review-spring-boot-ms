package com.dhritesh.productms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhritesh.productms.dtos.ApiResponse;
import com.dhritesh.productms.dtos.ProductDto;
import com.dhritesh.productms.services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired 
    private ProductService productService;
    
    @GetMapping("")
    public ResponseEntity<ApiResponse> getAllProducts(){
        var products = this.productService.getAllProduct();
        return ResponseEntity.ok().body(new ApiResponse(true, "Products fetched successfully",products));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ApiResponse> getProductById(@PathVariable long productId){
        var product = this.productService.getProductById(productId);
        return ResponseEntity.ok().body(new ApiResponse(true, "Products fetched successfully",product));
    }

    @PostMapping("")
    public ResponseEntity<ApiResponse> createProduct(@RequestBody @Valid ProductDto productDto){
        System.out.println("checkproduct");
        ProductDto product = this.productService.createProduct(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(true, "Product created successfully",product));
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ApiResponse> updateProduct(@RequestBody @Valid ProductDto productDto, @PathVariable long productId){
        ProductDto product = this.productService.updateProduct(productDto,productId);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(true, "Products updated successfully",product));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable long productId){
        boolean isDeleted = this.productService.deleteProduct(productId);
        String msg = isDeleted ? "Product deleted successfully" : "Product was unable to delete";
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(isDeleted, msg));
    }
}
