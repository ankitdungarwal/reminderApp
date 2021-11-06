package com.neelkanth.reminder.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "reminder")
public class Reminder {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @CreatedDate
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @CreatedDate
    @Temporal(TemporalType.DATE)
    private Date updateDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date triggerDate;
    @Column(name = "value", nullable = false)
    private String name;
    @CreatedBy
    private String author;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getTriggerDate() {
        return triggerDate;
    }

    public void setTriggerDate(Date triggerDate) {
        this.triggerDate = triggerDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Remind{" +
                "id=" + id +
                ", CreationDate=" + creationDate +
                ", updateDate=" + updateDate +
                ", triggerDate=" + triggerDate +
                ", name='" + name + '\'' +
                '}';
    }

    @PrePersist
    private void updateDate()
    {
        creationDate = new Date();
        updateDate = new Date();
    }
}
