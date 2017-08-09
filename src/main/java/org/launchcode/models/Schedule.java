package org.launchcode.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by lynnstrauss on 8/6/17.
 */
@Entity
public class Schedule {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String season;

    private String week;

    @NotNull
    private String homeTeam;

    private int homeTeamScore;

    @NotNull
    private String awayTeam;

    private int awayTeamScore;

    public Schedule(String season, String week, String homeTeam, int homeTeamScore,
                    String awayTeam, int awayTeamScore) {
        this.season = season;
        this.week = week;
        this.homeTeam = homeTeam;
        this.homeTeamScore = homeTeamScore;
        this.awayTeam = awayTeam;
        this.awayTeamScore = awayTeamScore;
    }

//    public Schedule(String season, int week, String homeTeam,
//                    String awayTeam) {
//        this(season, week, homeTeam, awayTeam);
//    }

    public Schedule() {
    }

    public int getId() {
        return id;
    }

    public String getSeason() {
        return season;
    }


    public String getHomeTeam() {
        return homeTeam;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public int getAwayTeamScore() {
        return awayTeamScore;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public void setHomeTeamScore(int homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public void setAwayTeamScore(int awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

}




