package com.example.usersbooking.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document("user")
public class User {

    @Id
    private String id;

    private String name;
    private Boolean active;
    private Date until;
    private Integer age;
    private String email;
    private Long phone;
    private String profession;

    public User(){}

    public User(String name, Boolean active, Date until, Integer age, String email, Long phone, String profession) {
        this.name = name;
        this.active = active;
        this.until = until;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.profession = profession;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getUntil() {
        return until;
    }

    public void setUntil(Date until) {
        this.until = until;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
