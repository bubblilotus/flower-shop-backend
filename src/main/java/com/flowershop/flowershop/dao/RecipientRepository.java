package com.flowershop.flowershop.dao;

import com.flowershop.flowershop.entity.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipientRepository extends JpaRepository<Recipient, Long> {
}
