package org.launchcode.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


/**
 * Created by lynnstrauss on 8/16/17.
 */
@Entity
public class Roster {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=50, message = "Name must be at least 3 characters and not more than 50.")
    private String player;

    private int number;

    private String playerClass;

    public enum ClassManYear{Senior, Junior, Sophmore, Freshman}

    private int feet;

    private int inches;

    private int weight;

    private String offensivePosition;

    private String defensivePosition;

    private String specialTeams;

    private String playerNote;

    @ManyToOne
    private Season season;

    public Roster(int id, String player, int number, String playerClass, int feet,
                  int inches, int weight, String offensivePosition, String defensivePosition,
                  String specialTeams, String playerNote, Season season) {

        this.id = id;
        this.player = player;
        this.number = number;
        this.playerClass = playerClass;
        this.feet = feet;
        this.inches = inches;
        this.weight = weight;
        this.offensivePosition = offensivePosition;
        this.defensivePosition = defensivePosition;
        this.specialTeams = specialTeams;
        this.playerNote = playerNote;
        this.season = season;
    }

    public Roster() {
    }

    public int getId() {
        return id;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getFeet() {
        return feet;
    }

    public void setFeet(int feet) {
        this.feet = feet;
    }

    public int getInches() {
        return inches;
    }

    public void setInches(int inches) {
        this.inches = inches;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getOffensivePosition() {
        return offensivePosition;
    }

    public void setOffensivePosition(String offensivePosition) {
        this.offensivePosition = offensivePosition;
    }

    public String getDefensivePosition() {
        return defensivePosition;
    }

    public void setDefensivePosition(String defensivePosition) {
        this.defensivePosition = defensivePosition;
    }

    public String getSpecialTeams() {
        return specialTeams;
    }

    public void setSpecialTeams(String specialTeams) {
        this.specialTeams = specialTeams;
    }

    public String getPlayerNote() {
        return playerNote;
    }

    public void setPlayerNote(String playerNote) {
        this.playerNote = playerNote;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }
}
