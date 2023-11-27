package com.driver.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Blog> blogList=new ArrayList<>();

    public List<Blog> getBlogList() {
        return blogList;
    }


    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.firstName ="test";
        this.lastName = "test";
    }

    public User() {
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }

    public User(Integer userId, String username, String password, String firstName, String lastName, List<Blog> blogList) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.blogList = blogList;
    }

    public Integer getUserId() {
        return userId;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}