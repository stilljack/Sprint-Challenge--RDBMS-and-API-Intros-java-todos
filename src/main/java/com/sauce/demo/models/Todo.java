package com.sauce.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="todos")
public class Todo {
    public Todo(String description, Date datetime, boolean completed, User user) {
        this.description = description;
        this.datetime = datetime;
        this.completed = completed;
        this.user = user;
    }

    public Todo(String description, Date datetime, User user) {
        this.description = description;
        this.datetime = datetime;
        this.completed = false;
        this.user = user;
    }
    public Todo() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoid;
    @Column(nullable = false)
    private String description;
    private Date datetime;
    private boolean completed;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid",
            nullable = false)
    @JsonIgnoreProperties({"roles", "hibernateLazyInitializer"})
    private User user; //foriegn key one to many from user



    public long getTodoid() {
        return todoid;
    }

    public void setTodoid(long todoid) {
        this.todoid = todoid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "TODOS{" +
                "todoid=" + todoid +
                ", description='" + description + '\'' +
                ", datetime=" + datetime +
                ", completed=" + completed +
                ", user=" + user +
                '}';
    }
}
