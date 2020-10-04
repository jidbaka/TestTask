package com.testtask.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Students {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private  String name;
    private String date;
    private  String numberGroup;

    public Students() {
    }

    public Students(String name, String date, String numberGroup) {
        this.name = name;
        this.date = date;
        this.numberGroup = numberGroup;
    }

    // public Students(String name, String numberGroup , Date date) {
   //     this.name = name;
   //     this.date = date;
   //     this.numberGroup = numberGroup;
   // }


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
        this.name = name;
    }

    public String getNumberGroup() {
        return numberGroup;
    }

    public void setNumberGroup(String numberGroup) {
        this.numberGroup = numberGroup;
    }

    public String getDate() {
        return date;
    }

    public void setData(String date) {
        this.date = date;
    }
}
