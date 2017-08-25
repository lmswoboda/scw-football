package org.launchcode.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


/**
 * Created by lynnstrauss on 8/25/17.
 */
@Entity
public class IndSingleGameRecord {
    @Id
    @GeneratedValue
    private int id;

    private String title;

    private int record;

    private String opponent;

    private String player;

    private int year;

    public IndSingleGameRecord() {
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

    public int getRecord() {
        return record;
    }

    public void setRecord(int record) {
        this.record = record;
    }

    public String getOpponent() {
        return opponent;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public IndSingleGameRecord(int id, String title, int record, String opponent, String player, int year) {
        this.id = id;
        this.title = title;
        this.record = record;
        this.opponent = opponent;
        this.player = player;
        this.year = year;
    }
}
