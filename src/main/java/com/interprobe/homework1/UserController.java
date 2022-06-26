package com.interprobe.homework1;

import com.interprobe.homework1.dao.ProductDao;
import com.interprobe.homework1.dao.ProductReviewDao;
import com.interprobe.homework1.entity.Product;
import com.interprobe.homework1.entity.ProductReview;
import com.interprobe.homework1.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final ProductReviewDao productReviewDao;
    private final ProductDao productDao;

    @GetMapping("/{id}")
    public List<ProductReview> findAllById(@PathVariable Long id) {
        return productReviewDao.findAllById(id);
    }

    @GetMapping("/{id}{greater}{less}")
    public List<ProductReview> findAllByIdBetweenDate(@PathVariable Long id, @PathVariable Date greater, @PathVariable Date less) {
        return productReviewDao.findAllByIdAndReviewDateIsGreaterThanAndReviewDateIsLessThan(id, greater, less);
    }

    @GetMapping("/{user}")
    public List<ProductReview> findAllByUser(@PathVariable User user) {
        return productReviewDao.findAllByUser(user);
    }

    @GetMapping("/{user}{greater}{less}")
    public List<ProductReview> findAllByUserBetweenDate(@PathVariable User user, @PathVariable Date greater, @PathVariable Date less) {
        return productReviewDao.findAllByUserAndReviewDateIsGreaterThanAndReviewDateIsLessThan(user, greater, less);
    }

    @GetMapping("/{date}")
    public List<Product> findAllByIdAndExpirationDate(@PathVariable Date date) {
        return productDao.findAllByExpirationDateIsGreaterThan(date);
    }

    @GetMapping("/{date}")
    public List<Product> findAllByExpirationDateOrNull(@PathVariable  Date date){
        return productDao.findAllByExpirationDateIsLessThanOrExpirationDateIsNull(date);
    }

}
