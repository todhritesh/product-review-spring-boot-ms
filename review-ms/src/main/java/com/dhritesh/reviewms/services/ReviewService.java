package com.dhritesh.reviewms.services;

import java.util.List;

import com.dhritesh.reviewms.dtos.ReviewDto;

public interface ReviewService {
    ReviewDto createReview(ReviewDto reviewDto);
    ReviewDto updateReview(ReviewDto reviewDto, long reviewId);
    boolean deleteReview(long reviewId);
    ReviewDto getReviewById(long reviewId);
    List<ReviewDto> getAllReviewByProductId(long productId);
}
