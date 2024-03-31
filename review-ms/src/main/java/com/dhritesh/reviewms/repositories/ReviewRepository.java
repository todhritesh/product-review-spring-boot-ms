package com.dhritesh.reviewms.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhritesh.reviewms.entities.Review;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    Optional<List<Review>> findByProductId(long productId);
}
