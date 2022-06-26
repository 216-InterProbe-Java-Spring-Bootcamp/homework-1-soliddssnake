package com.interprobe.homework1.dao;

import com.interprobe.homework1.entity.ProductReview;
import com.interprobe.homework1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProductReviewDao extends JpaRepository<ProductReview, Long> {

    List<ProductReview> findAllById(Long id);

    List<ProductReview> findAllByIdAndReviewDateIsGreaterThanAndReviewDateIsLessThan(Long id, Date greater, Date less);

    List<ProductReview> findAllByUser(User user);

    List<ProductReview> findAllByUserAndReviewDateIsGreaterThanAndReviewDateIsLessThan(User user, Date greater, Date less);


}
