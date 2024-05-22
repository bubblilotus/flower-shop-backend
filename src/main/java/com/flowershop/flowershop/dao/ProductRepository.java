package com.flowershop.flowershop.dao;

import com.flowershop.flowershop.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

//@CrossOrigin("http://ng-vera-flowers.s3-website.us-east-2.amazonaws.com")
@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "product")

public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findByCategoryId(@Param("id") Long id, Pageable pageable);
    Page<Product> findByOccasionId(@Param("id") Long id, Pageable pageable);

    Page<Product> findByNameContaining(@Param("keyword") String keyword, Pageable pageable);
    Page<Product> findByDescriptionContaining(@Param("keyword") String keyword, Pageable pageable);
    Page<Product> findByCompositionContaining(@Param("keyword") String keyword, Pageable pageable);
    Page<Product> findByMeaningContaining(@Param("keyword") String keyword, Pageable pageable);

}
