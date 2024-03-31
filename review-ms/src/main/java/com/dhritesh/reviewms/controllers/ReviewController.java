package com.dhritesh.reviewms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dhritesh.reviewms.dtos.ApiResponse;
import com.dhritesh.reviewms.dtos.ReviewDto;
import com.dhritesh.reviewms.services.ReviewService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;
    
    @GetMapping
    public ResponseEntity<ApiResponse> getAllReviewsByProductId(@RequestParam(name = "productId", required = true) long productId){
        var reviews = this.reviewService.getAllReviewByProductId(productId);
        return ResponseEntity.ok().body(new ApiResponse(true, "reviews fetched successfully",reviews));
    }
    
    @GetMapping("/reviewId")
    public ResponseEntity<ApiResponse> getReviewsById(@PathVariable(name="reviewId", required = true) long reviewId){
        var review = this.reviewService.getReviewById(reviewId);
        return ResponseEntity.ok().body(new ApiResponse(true, "review fetched successfully",review));
    }
    
    @PostMapping
    public ResponseEntity<ApiResponse> createReview(@RequestBody @Valid ReviewDto reviewDto){
        var review = this.reviewService.createReview(reviewDto);
        return ResponseEntity.ok().body(new ApiResponse(true, "review created successfully",review));
    }
    
    @PutMapping("/reviewId")
    public ResponseEntity<ApiResponse> createReview(@RequestBody @Valid ReviewDto reviewDto, @PathVariable(name="reviewId", required = true) long reviewId){
        var review = this.reviewService.updateReview(reviewDto,reviewId);
        return ResponseEntity.ok().body(new ApiResponse(true, "review updated successfully",review));
    }
    
    @DeleteMapping("/reviewId")
    public ResponseEntity<ApiResponse> createReview(@PathVariable(name="reviewId", required = true) long reviewId){
        var review = this.reviewService.deleteReview(reviewId);
        String msg = review ? "review deleted successfully" : "unable to delete review";
        return ResponseEntity.ok().body(new ApiResponse(true, msg,review));
    }
}
