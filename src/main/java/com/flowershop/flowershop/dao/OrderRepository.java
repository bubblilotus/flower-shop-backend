package com.flowershop.flowershop.dao;

import com.flowershop.flowershop.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")

@RepositoryRestResource(collectionResourceRel = "order")

public interface OrderRepository extends JpaRepository<Order, Long> {
    Page<Order> findByOrderTrackingNumber(@Param("trackingNumber") String orderTrackingNumber, Pageable pageable);
}
