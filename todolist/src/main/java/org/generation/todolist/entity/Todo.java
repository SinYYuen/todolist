package org.generation.todolist.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.generations.springBootPractice.controller.dto.CustomerDTO;


@Entity
public class Todo {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String description;

    private String title;
    private String Targetdate;

    public Todo(){

    }


    public Todo(){

        this.description = getdescription();
        this.Targetdate = getTargetdate();

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTargetdate() {
        return Targetdate;
    }

    public void setTargetdate(String targetdate) {
        Targetdate = targetdate;
    }

    @Override
    public String toString()
    {
        return "Customer{" + "description=" + description + ", title='" + title + '\'' + ", Targetdate='" +
                Targetdate + '}';
    }



}
