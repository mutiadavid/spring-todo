package com.example.demo.data;


import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Todo {
    @Id
    private UUID id;
    private  String name;
    private  String description;
    private Date date;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
