package com.flowershop.flowershop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="recipient")
@Getter
@Setter
public class Recipient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="full_name")
    private String fullName;

    @OneToMany(mappedBy = "recipient", cascade = CascadeType.ALL)
    private Set<Order> orders = new HashSet<>();

    public void add(Order order) {

        if (order != null) {

            if (orders == null) {
                orders = new HashSet<>();
            }

            orders.add(order);
            order.setRecipient(this);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}









