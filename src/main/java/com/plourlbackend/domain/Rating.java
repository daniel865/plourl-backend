package com.plourlbackend.domain;

import javax.persistence.*;

@Entity
@Table(name = "ratings")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rating", unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user", nullable = false)
    private User who;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user", nullable = false)
    private User whom;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_service", nullable = false)
    private Service service;

    @Column(name = "value")
    private Integer value;

    @Column(name = "comment")
    private String comment;

    public Rating() {
        super();
    }

    public Rating(User who, User whom, Service service, Integer value, String comment) {
        this.who = who;
        this.whom = whom;
        this.service = service;
        this.value = value;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getWho() {
        return who;
    }

    public void setWho(User who) {
        this.who = who;
    }

    public User getWhom() {
        return whom;
    }

    public void setWhom(User whom) {
        this.whom = whom;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", who=" + who +
                ", whom=" + whom +
                ", service=" + service +
                ", value=" + value +
                ", comment='" + comment + '\'' +
                '}';
    }
}
