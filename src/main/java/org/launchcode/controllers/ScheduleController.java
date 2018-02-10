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
import java.util.List;


/**
 * Created by lynnstrauss on 8/4/17.
 */
@Controller
@RequestMapping("schedule")
public class ScheduleController {

    @Autowired
    ScheduleDao scheduleDao;

    @Autowired
    SeasonDao seasonDao;

//    Request path: /schedule
    @RequestMapping(value = "")
    public String index(Model model){
        model.addAttribute("schedules", scheduleDao.findAll());
        model.addAttribute("title", "SCW Football Schedule");
        return "schedule/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddScheduleForm(Model model) {
        model.addAttribute("title", "Add Game");
        model.addAttribute(new Schedule());
        model.addAttribute("seasons", seasonDao.findAll());
        return "schedule/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddScheduleForm(@ModelAttribute @Valid Schedule newSchedule,
                                       Errors errors, @RequestParam int seasonId,
                                       Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Schedule");
            model.addAttribute("seasons", seasonDao.findAll());
            return "schedule/add";
        }

        Season sea = seasonDao.findOne(seasonId);
        newSchedule.setSeason(sea);
        scheduleDao.save(newSchedule);

        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveScheduleForm(Model model) {
        model.addAttribute("schedules", scheduleDao.findAll());
        model.addAttribute("title", "Remove Schedule");
        return "schedule/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveScheduleForm(@RequestParam int[] scheduleIds) {

        for (int scheduleId : scheduleIds) {
            scheduleDao.delete(scheduleId);
        }

        return "redirect:";
    }

    @RequestMapping(value = "season", method = RequestMethod.GET)
    public String season(Model model, @RequestParam int id) {

        Season sea = seasonDao.findOne(id);
        List<Schedule> schedules = sea.getSchedules();
        model.addAttribute("schedules", schedules);
        model.addAttribute("title", "Games in " + sea.getYear() + " Season");
        return "schedule/index";
    }

}
