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

    public enum ClassManYear{Senior, Junior, Sophmore, Freshman}

    private int feet;

    private int inches;

    private int weight;

    private String offensivePosition;

    private String defensivePostion;

    private String specialTeamsPosition;


    public Roster(int id, String player, int feet, int inches, int weight, String offensivePosition, String defensivePostion, String specialTeamsPosition) {
        this.id = id;
        this.player = player;
        this.feet = feet;
        this.inches = inches;
        this.weight = weight;
        this.offensivePosition = offensivePosition;
        this.defensivePostion = defensivePostion;
        this.specialTeamsPosition = specialTeamsPosition;
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

    public String getDefensivePostion() {
        return defensivePostion;
    }

    public void setDefensivePostion(String defensivePostion) {
        this.defensivePostion = defensivePostion;
    }

    public String getSpecialTeamsPosition() {
        return specialTeamsPosition;
    }

    public void setSpecialTeamsPosition(String specialTeamsPosition) {
        this.specialTeamsPosition = specialTeamsPosition;
    }
}
