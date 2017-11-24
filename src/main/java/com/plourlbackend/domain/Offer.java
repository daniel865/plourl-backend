package com.plourlbackend.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "offers")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_offer", unique = true, nullable = false)
    private Long id;

    @Column(name = "status")
    private String status;

    @Column(name = "value")
    private BigDecimal value;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_service_request", nullable = false)
    private ServiceRequest request;


    public Offer() {
        super();
    }

    public Offer(String status, BigDecimal value, User user, ServiceRequest request) {
        this.status = status;
        this.value = value;
        this.user = user;
        this.request = request;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ServiceRequest getRequest() {
        return request;
    }

    public void setRequest(ServiceRequest request) {
        this.request = request;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", value=" + value +
                ", user=" + user +
                ", request=" + request +
                '}';
    }
}
