package com.kodilla.hibernate.task;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "tasks_financials")
public class TaskFinancialDetails {

    private int id;
    private BigDecimal price;
    private boolean paid;

    public TaskFinancialDetails() {
    }

    public TaskFinancialDetails(BigDecimal price, boolean paid) {
        this.price = price;
        this.paid = paid;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "id", unique = true)
    public int getId() {
        return id;
    }

    @Column(name = "paid")
    public boolean isPaid() {
        return paid;
    }

    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
