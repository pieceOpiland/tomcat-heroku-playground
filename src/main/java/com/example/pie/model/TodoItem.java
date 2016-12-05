package com.example.pie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "todo_item")
public class TodoItem {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "is_done")
    private boolean done;

    @Column(name = "task")
    private String task;

    @JsonIgnore
    @Column(name = "visible")
    private boolean visible;

    public void setDone(boolean done) {
        this.done = done;
    }
}
