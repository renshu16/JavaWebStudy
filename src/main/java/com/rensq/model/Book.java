package com.rensq.model;

/**
 * Created by toothbond on 16/7/7.
 */
public class Book {

    private String name;
    private String id;

    public Book(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
