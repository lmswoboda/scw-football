package org.launchcode.controllers;

import org.launchcode.models.Schedule;
import org.launchcode.models.data.ScheduleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by lynnstrauss on 8/4/17.
 */
@Controller
@RequestMapping("schedule")
public class ScheduleController {

    @Autowired
    private ScheduleDao scheduleDao;



//    Request path: /schedule
    @RequestMapping(value = "")
    public String schedule(Model model){
        model.addAttribute("schedules", scheduleDao.findAll());
        model.addAttribute("title", "SCW Football Schedules");
        return "schedule/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddScheduleForm(Model model) {
        model.addAttribute("title", "Add Schedule");
        model.addAttribute(new Schedule());
        return "schedule/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddScheduleForm(@ModelAttribute @Valid Schedule newSchedule,
                                       Errors errors,
                                       Model model) {


        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Schedule");
            return "schedule/add";
        }

        scheduleDao.save(newSchedule);

        scheduleDao.save(newSchedule);
        return "redirect:";
    }




}
