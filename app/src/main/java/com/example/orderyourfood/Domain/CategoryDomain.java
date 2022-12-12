package com.example.orderyourfood.Domain;

import java.io.Serializable;

public class CategoryDomain implements Serializable {
    private  String title;

    public CategoryDomain(String title, String pic) {
        this.title = title;
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    private String pic;
}
