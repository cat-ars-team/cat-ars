package com.cat.bean;


public class Test {
    private Integer id;

    private String name;

    private Integer parid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getParid() {
        return parid;
    }

    public void setParid(Integer parid) {
        this.parid = parid;
    }
}