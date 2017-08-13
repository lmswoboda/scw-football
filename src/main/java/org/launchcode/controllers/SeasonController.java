package org.launchcode.controllers;

import org.launchcode.models.Schedule;
import org.launchcode.models.Season;
import org.launchcode.models.data.ScheduleDao;
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


/**
 * Created by lynnstrauss on 8/13/17.
 */

@Controller
@RequestMapping("season")
public class SeasonController {

    @Autowired
    private SeasonDao seasonDao;

    //    Request path: /season
    @RequestMapping(value = "")
    public String season(Model model){
        model.addAttribute("seasons", seasonDao.findAll());
        model.addAttribute("title", "SCW Football Seasons");
        return "season/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddSeasonForm(Model model) {
        model.addAttribute("title", "Add Season");
        model.addAttribute(new Season());
        return "season/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddSeasonForm(@ModelAttribute @Valid Season newSeason,
                                         Errors errors,
                                         Model model) {


        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Season");
            return "season/add";
        }

        seasonDao.save(newSeason);

        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveSeasonForm(Model model) {
        model.addAttribute("seasons", seasonDao.findAll());
        model.addAttribute("title", "Remove Season");
        return "season/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveSeasonForm(@RequestParam int[] seasonIds) {

        for (int seasonId : seasonIds) {
            seasonDao.delete(seasonId);
        }

        return "redirect:";
    }



}
