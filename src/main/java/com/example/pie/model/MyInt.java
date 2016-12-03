package com.example.pie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "myint")
public class MyInt {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "myint_id_seq")
    @SequenceGenerator(name = "myint_id_seq", sequenceName = "myint_id_seq")
    @Column(name = "id")
    private int id;

    @Column(name = "value")
    private Integer value;

    public Integer getValue() {
        return value;
    }
    public void setValue(Integer value) {
        this.value = value;
    }
}
