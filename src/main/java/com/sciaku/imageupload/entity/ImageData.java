package com.sciaku.imageupload.entity;

import javax.persistence.*;

@Entity
@Table (name = "ImageData")
public class ImageData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String url;
    private String type;

    public ImageData() {
    }

    public ImageData( String name, String url, String type) {
//        Id = id;
        this.name = name;
        this.url = url;
        this.type = type;

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
