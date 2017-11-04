package com.plourlbackend.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;

    @Column(name = "name_user", unique = true)
    private String nameUser;

    @Column(name = "names")
    private String names;

    @Column(name = "lastname")
    private String lastname;

    @Column(nullable = true, name = "phone")
    private String phone;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "type")
    private String type;

    public User() {
        super();
    }

    public User(Long id){
        this.id = id;
    }

    public User(String nameUser, String names, String lastname, String phone, String mobile, String type) {
        this.nameUser = nameUser;
        this.names = names;
        this.lastname = lastname;
        this.phone = phone;
        this.mobile = mobile;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nameUser='" + nameUser + '\'' +
                ", names='" + names + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phone='" + phone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
