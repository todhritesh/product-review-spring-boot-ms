package com.dhritesh.reviewms.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhritesh.reviewms.dtos.ApiResponse;
import com.dhritesh.reviewms.dtos.ReviewDto;
import com.dhritesh.reviewms.entities.Review;
import com.dhritesh.reviewms.exceptions.ResourceNotFoundException;
import com.dhritesh.reviewms.repositories.ReviewRepository;
import com.dhritesh.reviewms.services.ReviewService;
import com.dhritesh.reviewms.services.feingClients.ProductServiceClient;

@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductServiceClient productServiceClient;

    @Override
    public ReviewDto createReview(ReviewDto reviewDto) {
        System.out.println("ln31");
        ApiResponse apiResponse = (this.productServiceClient.getProductById(reviewDto.getProductId())).getBody();
        System.out.println(apiResponse.isStatus());
        var review = this.reviewRepository.save(this.modelMapper.map(reviewDto, Review.class));
        return this.modelMapper.map(review, ReviewDto.class);
    }

    @Override
    public ReviewDto updateReview(ReviewDto reviewDto, long reviewId) {
        var r = this.reviewRepository.findById(reviewId).orElseThrow(()->new ResourceNotFoundException("Review", "id", String.valueOf(reviewId)));
        r.setContent(reviewDto.getContent());
        var review = this.reviewRepository.save(r);
        return this.modelMapper.map(review, ReviewDto.class);
    }

    @Override
    public boolean deleteReview(long reviewId) {
        try{
            var r = this.reviewRepository.findById(reviewId).orElseThrow(()->new ResourceNotFoundException("Review", "id", String.valueOf(reviewId)));
            this.reviewRepository.delete(r);
            return true;
        } catch(Exception e){
            return false;
        }

    }

    @Override
    public ReviewDto getReviewById(long reviewId) {
        var r = this.reviewRepository.findById(reviewId).orElseThrow(()->new ResourceNotFoundException("Review", "id", String.valueOf(reviewId)));
        return this.modelMapper.map(r, ReviewDto.class);
    }

    @Override
    public List<ReviewDto> getAllReviewByProductId(long productId) {
        var reviews = this.reviewRepository.findByProductId(productId).orElseThrow(()->new ResourceNotFoundException("Review", "id", String.valueOf(productId)));
        return reviews.stream().map(review->this.modelMapper.map(review, ReviewDto.class)).collect(Collectors.toList());
    }
    
}
