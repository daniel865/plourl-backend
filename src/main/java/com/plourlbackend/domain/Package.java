package com.plourlbackend.domain;

import javax.persistence.*;

@Entity
@Table(name = "packages")
public class Package {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_package", unique = true, nullable = false)
    private Long id;

    @Column(name = "height")
    private Float height;

    @Column(name = "width")
    private Float width;

    @Column(name = "depth")
    private Float depth;

    @Column(name = "content")
    private String content;

    @Column(name = "recommendations")
    private String recommendations;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_service_request", nullable = false)
    private ServiceRequest serviceRequest;

    public Package() {
        super();
    }

    public Package(Float height, Float width, Float depth, String content, String recommendations, ServiceRequest serviceRequest) {
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.content = content;
        this.recommendations = recommendations;
        this.serviceRequest = serviceRequest;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }

    public ServiceRequest getServiceRequest() {
        return serviceRequest;
    }

    public void setServiceRequest(ServiceRequest serviceRequest) {
        this.serviceRequest = serviceRequest;
    }

    @Override
    public String toString() {
        return "Package{" +
                "id=" + id +
                ", height=" + height +
                ", width=" + width +
                ", depth=" + depth +
                ", content='" + content + '\'' +
                ", recommendations='" + recommendations + '\'' +
                ", serviceRequest=" + serviceRequest +
                '}';
    }
}
