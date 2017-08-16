package org.launchcode.controllers;

import org.launchcode.models.Roster;
import org.launchcode.models.data.RosterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by lynnstrauss on 8/16/17.
 */
@Controller
@RequestMapping("roster")
public class RosterController {

    @Autowired
    private RosterDao rosterDao;

    //    Request path: /roster
    @RequestMapping(value = "")
    public String roster(Model model){
        model.addAttribute("rosters", rosterDao.findAll());
        model.addAttribute("title", "SCW Football Roster");
        return "roster/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddRosterForm(Model model) {
        model.addAttribute("title", "Add Roster");
        model.addAttribute(new Roster());
        return "roster/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddRosterForm(@ModelAttribute @Valid Roster newRoster,
                                         Errors errors,
                                         Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Roster");
            return "roster/add";
        }

        rosterDao.save(newRoster);

        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveRosterForm(Model model) {
        model.addAttribute("rosters", rosterDao.findAll());
        model.addAttribute("title", "Remove Roster");
        return "roster/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveRosterForm(@RequestParam int[] rosterIds) {

        for (int rosterId : rosterIds) {
            rosterDao.delete(rosterId);
        }

        return "redirect:";
    }

}
