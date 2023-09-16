package ru.gb.software_architecture.homework.sem6.notes.core.domain;

import java.util.Date;

public class Note {
    
    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", details='" + details + '\'' +
                '}';
    }

    //region Constructors

    public Note(String title, String details) {
        this.title = title;
        this.details = details;
    }

    //endregion

    //region Public Getters And Setters (Properties)


    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getEditDate() {
        return editDate;
    }

    //endregion

    //region Private Fields

    private int id;
    private int userId;
    private String title;
    private String details;
    private Date creationDate;
    private Date editDate;

    //endregion

}
