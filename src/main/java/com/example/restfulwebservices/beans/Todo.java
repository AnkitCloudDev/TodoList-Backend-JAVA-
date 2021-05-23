package com.example.restfulwebservices.beans;

import java.util.Date;

public class Todo {

    private long id;
    private String descrition, username;
    private Date targetDate;
    private boolean isDone;

    public Todo(long id, String descrition, String username, Date targetDate, boolean isDone) {
        this.id = id;
        this.descrition = descrition;
        this.username = username;
        this.targetDate = targetDate;
        this.isDone = isDone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }


}
