package com.kit.cgv.jpa.domain.review;

import com.kit.cgv.jpa.domain.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
