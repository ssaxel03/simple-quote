package com.ssaxel03.simplequote.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
@Entity
@Table(name = "item")
public class Item extends AbstractModel {

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private BigDecimal unitPrice;

    private String unit;

    @NotNull
    @NotBlank
    private BigDecimal taxRate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + getId() +
                ", creationTime=" + getCreationTime() +
                ", updateTime=" + getUpdateTime() +
                ", name=" + name +
                ", unitPrice=" + unitPrice +
                ", unit=" + unit +
                ", taxRate=" + taxRate +
                ", user=" + user +
                '}';
    }
}
