package org.launchcode.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by lynnstrauss on 8/21/18.
 */
@Entity
public class Home {

    @Id
    @GeneratedValue
    private int id;

    @NotNull(message = "Title may not be empty.")
    private String title;


    public Home(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Home() {
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}