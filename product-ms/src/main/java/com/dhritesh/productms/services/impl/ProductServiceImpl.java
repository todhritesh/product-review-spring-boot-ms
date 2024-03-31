package com.dhritesh.productms.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhritesh.productms.dtos.ProductDto;
import com.dhritesh.productms.entities.Product;
import com.dhritesh.productms.exceptions.ResourceNotFoundException;
import com.dhritesh.productms.repositories.ProductRepository;
import com.dhritesh.productms.services.ProductService;


@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        var product = this.productRepository.save(this.modelMapper.map(productDto,Product.class));
        return this.modelMapper.map(product, ProductDto.class);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, long productId) {
        Product p = this.productRepository.findById(productId).orElseThrow(()->new ResourceNotFoundException("Product", "id", String.valueOf(productId)));
        p.setDescription(productDto.getDescription());
        p.setName(productDto.getName());
        p.setPrice(productDto.getPrice());
        p.setDiscountPercentage(productDto.getDiscountPercentage());
        Product product = this.productRepository.save(p);
        return this.modelMapper.map(product, ProductDto.class);
    }

    @Override
    public boolean deleteProduct(long productId) {
        try{
            Product p = this.productRepository.findById(productId).orElseThrow(()->new ResourceNotFoundException("Product", "id", String.valueOf(productId)));
            this.productRepository.delete(p);
            return true;
        } catch (Exception e){
            return false;
        }
        
    }

    @Override
    public ProductDto getProductById(long productId) {
        Product p = this.productRepository.findById(productId).orElseThrow(()->new ResourceNotFoundException("Product", "id", String.valueOf(productId)));
        return this.modelMapper.map(p, ProductDto.class);
    }

    @Override
    public List<ProductDto> getAllProduct() {
        List<Product> products = this.productRepository.findAll();
        return products.stream().map(product->this.modelMapper.map(product, ProductDto.class)).collect(Collectors.toList());
    }
    
}
