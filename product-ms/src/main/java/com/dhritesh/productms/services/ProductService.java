package com.dhritesh.productms.services;

import java.util.List;

import com.dhritesh.productms.dtos.ProductDto;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);
    ProductDto updateProduct(ProductDto productDto, long productId);
    boolean deleteProduct(long productId);
    ProductDto getProductById(long productId);
    List<ProductDto> getAllProduct();
}
