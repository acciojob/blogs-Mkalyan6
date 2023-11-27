package com.driver.models;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
 public class Blog{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer blogId;
    private  String blogTitle;
    private String blogContent;
    private Date pubDate;

    @ManyToOne
    @JoinColumn
    private User user;

    @OneToMany(mappedBy = "blog",cascade = CascadeType.ALL)
    private List<Image> imageList=new ArrayList<>();

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    public Blog(Integer blogId, String blogTitle, String blogContent, Date pubDate, User user, List<Image> imageList) {
        this.blogId = blogId;
        this.blogTitle = blogTitle;
        this.blogContent = blogContent;
        this.pubDate = pubDate;
        this.user = user;
        this.imageList = imageList;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Blog() {
    }



    public Blog(String blogTitle, String blogContent,Date pubDate) {
//        this.blogId = blogId;
        this.blogTitle = blogTitle;
        this.blogContent = blogContent;
        this.pubDate=pubDate;
    }

    public Integer getBlogId() {
        return blogId;
    }
    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }
}

