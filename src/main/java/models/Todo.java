package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="todos")
public class Todo {

    public Todo(String description, long datetime, boolean completed) {
        this.description = description;
        this.datetime = datetime;
        this.completed = completed;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoid;
    @Column(nullable = false)
    private String description;
    private long datetime;
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

    public long getDatetime() {
        return datetime;
    }

    public void setDatetime(long datetime) {
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
