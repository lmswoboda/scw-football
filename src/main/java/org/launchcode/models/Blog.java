package org.launchcode.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * Created by lynnstrauss on 8/20/17.
 */
@Entity
public class Blog {

    @Id
    @GeneratedValue
    private int id;

    @NotNull(message="Title may not be empty.")
    private String title;

    @NotNull(message="Body may not be empty.")
    private String body;

    public Blog(int id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Blog() {
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Created by lynnstrauss on 8/21/18.
     */
    public static class Home {
    }
}

