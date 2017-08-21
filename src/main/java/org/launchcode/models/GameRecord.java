package org.launchcode.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


/**
 * Created by lynnstrauss on 8/21/17.
 */
@Entity
public class GameRecord {

    @Id
    @GeneratedValue
    private int id;

    private String rushingYards;

    private String passReceptions;

    private String passingYards;

    private String yardsPerCarry;

    private String receivingYards;

    private String touchdowns;

    private String tackles;

    private String interceptions;

    private String puntingAverage;

    private String quarterbackSacks;

    private String fumbleRecoveries;

    private String fieldGoals;

    public GameRecord(int id, String rushingYards, String passReceptions, String passingYards,
                      String yardsPerCarry, String receivingYards, String touchdowns,
                      String tackles, String interceptions, String puntingAverage,
                      String quarterbackSacks, String fumbleRecoveries, String fieldGoals) {

        this.id = id;
        this.rushingYards = rushingYards;
        this.passReceptions = passReceptions;
        this.passingYards = passingYards;
        this.yardsPerCarry = yardsPerCarry;
        this.receivingYards = receivingYards;
        this.touchdowns = touchdowns;
        this.tackles = tackles;
        this.interceptions = interceptions;
        this.puntingAverage = puntingAverage;
        this.quarterbackSacks = quarterbackSacks;
        this.fumbleRecoveries = fumbleRecoveries;
        this.fieldGoals = fieldGoals;
    }

    public GameRecord() {
    }

    public int getId() {
        return id;
    }

    public String getRushingYards() {
        return rushingYards;
    }

    public void setRushingYards(String rushingYards) {
        this.rushingYards = rushingYards;
    }

    public String getPassReceptions() {
        return passReceptions;
    }

    public void setPassReceptions(String passReceptions) {
        this.passReceptions = passReceptions;
    }

    public String getPassingYards() {
        return passingYards;
    }

    public void setPassingYards(String passingYards) {
        this.passingYards = passingYards;
    }

    public String getYardsPerCarry() {
        return yardsPerCarry;
    }

    public void setYardsPerCarry(String yardsPerCarry) {
        this.yardsPerCarry = yardsPerCarry;
    }

    public String getReceivingYards() {
        return receivingYards;
    }

    public void setReceivingYards(String receivingYards) {
        this.receivingYards = receivingYards;
    }

    public String getTouchdowns() {
        return touchdowns;
    }

    public void setTouchdowns(String touchdowns) {
        this.touchdowns = touchdowns;
    }

    public String getTackles() {
        return tackles;
    }

    public void setTackles(String tackles) {
        this.tackles = tackles;
    }

    public String getInterceptions() {
        return interceptions;
    }

    public void setInterceptions(String interceptions) {
        this.interceptions = interceptions;
    }

    public String getPuntingAverage() {
        return puntingAverage;
    }

    public void setPuntingAverage(String puntingAverage) {
        this.puntingAverage = puntingAverage;
    }

    public String getQuarterbackSacks() {
        return quarterbackSacks;
    }

    public void setQuarterbackSacks(String quarterbackSacks) {
        this.quarterbackSacks = quarterbackSacks;
    }

    public String getFumbleRecoveries() {
        return fumbleRecoveries;
    }

    public void setFumbleRecoveries(String fumbleRecoveries) {
        this.fumbleRecoveries = fumbleRecoveries;
    }

    public String getFieldGoals() {
        return fieldGoals;
    }

    public void setFieldGoals(String fieldGoals) {
        this.fieldGoals = fieldGoals;
    }
}
