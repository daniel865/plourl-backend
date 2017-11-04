package com.plourlbackend.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "requests")
public class ServiceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_service_request", unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @Column(name = "departure")
    private Date departure;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_destination", nullable = false)
    private Destination destination;

    public ServiceRequest() {
        super();
    }

    public ServiceRequest(User user, Date departure, Destination destination) {
        this.user = user;
        this.departure = departure;
        this.destination = destination;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "ServiceRequest{" +
                "id=" + id +
                ", user=" + user +
                ", departure=" + departure +
                ", destination=" + destination +
                '}';
    }
}
