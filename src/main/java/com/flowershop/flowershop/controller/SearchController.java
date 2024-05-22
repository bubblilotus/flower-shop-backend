package com.flowershop.flowershop.controller;

import com.flowershop.flowershop.dao.ProductRepository;
import com.flowershop.flowershop.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("https://localhost:4200")
@RestController
@RequestMapping("/api/search")
public class SearchController {
    private ProductRepository productRepository;

    @GetMapping
    public Page<Product> search(@Param("keyword") String keyword, Pageable pageable){
        Page<Product> byName = productRepository.findByNameContaining(keyword, pageable);
        Page<Product> byDescription = productRepository.findByNameContaining(keyword, pageable);
        Page<Product> byComposition = productRepository.findByNameContaining(keyword, pageable);
        Page<Product> byMeaning = productRepository.findByNameContaining(keyword, pageable);
        return null;
    }
}
