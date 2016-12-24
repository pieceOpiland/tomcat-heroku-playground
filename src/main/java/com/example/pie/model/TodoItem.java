package com.example.pie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;
import java.util.Date;

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
    @Column(name = "created",
            insertable = false,
            updatable = false)
    private Date timestamp;

    @JsonIgnore
    @Column(name = "visible")
    private boolean visible = true;

    public void complete() {
        this.done = true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
