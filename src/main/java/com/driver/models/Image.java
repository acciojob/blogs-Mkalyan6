package com.driver.models;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
public class Image{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer imageId;
    private String imageDescrip;
    private String imageDimen;

    @ManyToOne
    @JoinColumn
    Blog blog;

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public Image(String imageDescrip, String imageDimen) {
        this.imageDescrip = imageDescrip;
        this.imageDimen = imageDimen;
    }

    public Image() {
    }

    public Integer getImageId() {
        return imageId;
    }
    public String getImageDescrip() {
        return imageDescrip;
    }

    public void setImageDescrip(String imageDescrip) {
        this.imageDescrip = imageDescrip;
    }

    public String getImageDimen() {
        return imageDimen;
    }

    public void setImageDimen(String imageDimen) {
        this.imageDimen = imageDimen;
    }
}