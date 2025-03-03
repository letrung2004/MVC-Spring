package com.lqt.mvcspring.pojo;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tag")
public class Tag implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String tagcol;


    public Tag(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Tag() { }

    @Override
    public String toString() {
        return "Tag [id=" + id + ", name=" + name + ", tagcol=" + tagcol + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagcol() {
        return tagcol;
    }

    public void setTagcol(String tagcol) {
        this.tagcol = tagcol;
    }
}

