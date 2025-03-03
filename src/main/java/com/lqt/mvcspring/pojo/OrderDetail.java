package com.lqt.mvcspring.pojo;

import jakarta.persistence.*;

import java.math.BigDecimal;

import java.io.Serializable;

@Entity
@Table(name = "order_detail")
public class OrderDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private SaleOrder saleOrder;


    public OrderDetail(int id, BigDecimal unitPrice, int quantity, Product product, SaleOrder saleOrder) {
        this.id = id;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.product = product;
        this.saleOrder = saleOrder;
    }

    public OrderDetail() {
    }

    @Override
    public String toString() {
        return "OrderDetail [id=" + id + ", unitPrice=" + unitPrice + ", quantity=" + quantity + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public SaleOrder getSaleOrder() {
        return saleOrder;
    }

    public void setSaleOrder(SaleOrder saleOrder) {
        this.saleOrder = saleOrder;
    }
}

