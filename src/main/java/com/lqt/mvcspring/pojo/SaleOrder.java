package com.lqt.mvcspring.pojo;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "sale_order")
public class SaleOrder implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "saleOrder")
    private Set<OrderDetail> orderDetails;

    public SaleOrder(User user, Date createdDate, int id) {
        this.user = user;
        this.createdDate = createdDate;
        Id = id;
    }

    public SaleOrder() {}

    @Override
    public String toString() {
        return "SaleOrder [Id=" + Id + ", createdDate=" + createdDate + ", username=" + user.getUsername() + "]";
    }

    public Set<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
