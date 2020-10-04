package com.testtask.entity;


import javax.persistence.*;

@Entity
public class StudentsGroup {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private  String numberGroup;
    private int count;

    public StudentsGroup() {
    }

    public StudentsGroup(String numberGroup, int count) {
        this.numberGroup = numberGroup;
        this.count = count;
    }

    public String getNumberGroup() {
        return numberGroup;
    }

    public void setNumberGroup(String numberGroup) {
        this.numberGroup = numberGroup;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
