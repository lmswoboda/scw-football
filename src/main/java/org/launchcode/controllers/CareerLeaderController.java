
package org.launchcode.controllers;

import org.launchcode.models.CareerLeader;
import org.launchcode.models.data.CareerLeaderDao;
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
 * Created by lynnstrauss on 8/21/17.
 */

@Controller
@RequestMapping("careerLeader")
public class CareerLeaderController {

    @Autowired
    private CareerLeaderDao careerLeaderDao;

    //    Request path: /careerLeader
    @RequestMapping(value = "")
    public String careerLeader(Model model){
        model.addAttribute("careerLeaders", careerLeaderDao.findAll());
        model.addAttribute("title", "Individual Career Leaders");
        return "careerLeader/index";
    }


    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddcareerLeaderForm(Model model) {
        model.addAttribute("title", "Add Individual Career Leader");
        model.addAttribute(new CareerLeader());
        return "careerLeader/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCareerLeaderForm(@ModelAttribute @Valid CareerLeader newCareerLeader,
                                     Errors errors,
                                     Model model) {


        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Career Leader");
            return "careerLeader/add";
        }

        careerLeaderDao.save(newCareerLeader);

        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCareerLeaderForm(Model model) {
        model.addAttribute("careerLeaders", careerLeaderDao.findAll());
        model.addAttribute("title", "Remove Career Leader");
        return "careerLeader/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCareerLeaderForm(@RequestParam int[] careerLeaderIds) {

        for (int careerLeaderId : careerLeaderIds) {
            careerLeaderDao.delete(careerLeaderId);
        }

        return "redirect:";
    }


}
