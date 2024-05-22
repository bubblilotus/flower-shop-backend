package com.flowershop.flowershop.dao;

import com.flowershop.flowershop.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
