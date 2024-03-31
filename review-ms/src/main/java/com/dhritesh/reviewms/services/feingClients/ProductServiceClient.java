package com.dhritesh.reviewms.services.feingClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dhritesh.reviewms.dtos.ApiResponse;

@FeignClient(name = "testing",url = "http://localhost:9091",path = "/api/products" )
public interface ProductServiceClient {
    @GetMapping("/{productId}")
    public ResponseEntity<ApiResponse> getProductById(@PathVariable long productId);
}
