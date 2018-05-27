package org.launchcode.controllers;

import org.launchcode.models.Schedule;
import org.launchcode.models.Season;
import org.launchcode.models.data.ScheduleDao;
import org.launchcode.models.data.SeasonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String index(Model model, @RequestParam int id){
        model.addAttribute("schedules", scheduleDao.findAll());
        model.addAttribute("title", "SCW Football Schedule");
        model.addAttribute("seasons", seasonDao.findAll());
        model.addAttribute("seasonId", id);
        return "schedule/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddScheduleForm(Model model,
                                         @RequestParam int id) {
//        model.addAttribute("title", "Add Game");
        Season sea = seasonDao.findOne(id);
        model.addAttribute(new Schedule());
//        model.addAttribute("seasons", seasonDao.findAll());
        model.addAttribute("title", sea.getYear() + " Schedule");
        model.addAttribute("seasonId", id);
        return "schedule/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddScheduleForm(@ModelAttribute @Valid Schedule newSchedule,
                                       Errors errors, @RequestParam int id,
                                       Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Schedule");
            model.addAttribute("seasons", seasonDao.findAll());
            model.addAttribute("seasonId", id);
            return "schedule/add";
        }

        Season sea = seasonDao.findOne(id);
        newSchedule.setSeason(sea);
        scheduleDao.save(newSchedule);

//        return "redirect:/query?q=Thymeleaf+Is+Great!";
        return "redirect:/schedule/season?id="+id;
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveScheduleForm(Model model,
                                            @RequestParam int id) {
        model.addAttribute("seasons", seasonDao.findAll());
        model.addAttribute("schedules", scheduleDao.findAll());
        Season sea = seasonDao.findOne(id);
        model.addAttribute("title", sea.getYear() + " Remove Game");

        model.addAttribute("seasonId", id);
        return "schedule/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveScheduleForm(@RequestParam int[] scheduleIds, int id) {

        for (int scheduleId : scheduleIds) {
            scheduleDao.delete(scheduleId);
        }

        return "redirect:/schedule/season?id="+id;
    }

    @RequestMapping(value = "season", method = RequestMethod.GET)
    public String season(Model model, @RequestParam int id) {

        Season sea = seasonDao.findOne(id);
        List<Schedule> schedules = sea.getSchedules();
        model.addAttribute("schedules", schedules);
        model.addAttribute("title", sea.getYear() + " Schedule");
        model.addAttribute("seasonId", id);
        return "schedule/index";
    }

}
