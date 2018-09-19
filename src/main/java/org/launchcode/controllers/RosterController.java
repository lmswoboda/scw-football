package org.launchcode.controllers;

import org.launchcode.models.Roster;
import org.launchcode.models.Schedule;
import org.launchcode.models.data.RosterDao;
import org.launchcode.models.Season;
import org.launchcode.models.data.SeasonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by lynnstrauss on 8/16/17.
 */
@Controller
@RequestMapping("roster")
public class RosterController {

    @Autowired
    RosterDao rosterDao;

    @Autowired
    SeasonDao seasonDao;

    //    Request path: /roster
    @RequestMapping(value = "")
    public String roster(Model model) {
        model.addAttribute("rosters", rosterDao.findAll());
        model.addAttribute("title", "SCW Football Players");
//        model.addAttribute("seasons", seasonDao.findAll());
//        model.addAttribute("seasonId", id);
        return "roster/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddRosterForm(Model model, @RequestParam int id) {
        Season sea = seasonDao.findOne(id);
        model.addAttribute(new Roster());
        model.addAttribute("title", sea.getYear() + " Player");
        model.addAttribute("seasonId", id);
        return "roster/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddRosterForm(@ModelAttribute @Valid Roster newRoster,
                                       Errors errors, @RequestParam int id,
                                       Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Player");
            model.addAttribute("seasons", seasonDao.findAll());
            model.addAttribute("seasonId", id);
            return "roster/add";
        }
        Season sea = seasonDao.findOne(id);
        newRoster.setSeason(sea);
        rosterDao.save(newRoster);
        return "redirect:/roster/season?id="+id;
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveRosterForm(Model model, @RequestParam int id) {
        Season sea = seasonDao.findOne(id);
        List<Roster> rosters = sea.getRosters();
        model.addAttribute("rosters", rosters);
        model.addAttribute("title", sea.getYear() + " Remove Player");
        model.addAttribute("seasonId", id);
        return "roster/remove";
    }


    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveRosterForm(@RequestParam int[] rosterIds, int id) {

        for (int rosterId : rosterIds) {
            rosterDao.delete(rosterId);
        }
        return "redirect:/roster/season?id="+id;
    }

    @RequestMapping(value = "season", method = RequestMethod.GET)
    public String season(Model model, @RequestParam int id) {

        Season sea = seasonDao.findOne(id);
        List<Roster> rosters = sea.getRosters();
        model.addAttribute("rosters", rosters);
        model.addAttribute("title", sea.getYear() + " Roster");
        model.addAttribute("seasonId", id);
        return "roster/index";
    }
}