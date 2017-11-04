package com.plourlbackend.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "availabilities")
public class Availability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_availability", unique = true, nullable = false)
    private Long id;

    @Column(name = "departure")
    private Date departure;

    @Column(name = "height")
    private Float height;

    @Column(name = "width")
    private Float width;

    @Column(name = "depth")
    private Float depth;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_destination", nullable = false)
    private Destination destination;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    public Availability() {
    }

    public Availability(Date departure, Float height, Float width, Float depth, Destination destination, User user) {
        this.departure = departure;
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.destination = destination;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public Float getDepth() {
        return depth;
    }

    public void setDepth(Float depth) {
        this.depth = depth;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Availability{" +
                "id=" + id +
                ", departure=" + departure +
                ", height=" + height +
                ", width=" + width +
                ", depth=" + depth +
                ", destination=" + destination +
                ", user=" + user +
                '}';
    }
}
