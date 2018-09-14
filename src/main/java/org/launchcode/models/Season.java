package org.launchcode.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lynnstrauss on 8/13/17.
 */
@Entity
public class Season {

    @Id
    @GeneratedValue
    private int id;

    private String year;

    private int wins;

    private int losses;

    private String notes;


    @OneToMany
    @JoinColumn(name = "season_id")
    private List<Schedule> schedules = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "season_id")
    private List<Roster> rosters = new ArrayList<>();

    public Season(int id, String year, int wins, int losses, String notes, List<Schedule> schedules, List<Roster> rosters) {
        this.id = id;
        this.year = year;
        this.wins = wins;
        this.losses = losses;
        this.notes = notes;
        this.schedules = schedules;
        this.rosters = rosters;
    }

    public Season() {
    }



    public int getId() {
        return id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public List<Roster> getRosters() {
        return rosters;
    }

    public void setRosters(List<Roster> rosters) {
        this.rosters = rosters;
    }
}
