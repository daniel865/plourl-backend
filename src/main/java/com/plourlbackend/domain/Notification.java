package com.plourlbackend.domain;

import javax.persistence.*;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tracking", unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user", nullable = false, insertable = false, updatable = false)
    private User from;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user", nullable = false, insertable = false, updatable = false)
    private User to;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    @Column(name = "link_details")
    private String link_details;

    public Notification() {
        super();
    }

    public Notification(User from, User to, String type, String description, String link_details) {
        this.from = from;
        this.to = to;
        this.type = type;
        this.description = description;
        this.link_details = link_details;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.to = to;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink_details() {
        return link_details;
    }

    public void setLink_details(String link_details) {
        this.link_details = link_details;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", from=" + from +
                ", to=" + to +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", link_details='" + link_details + '\'' +
                '}';
    }
}
