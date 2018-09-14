package org.launchcode.controllers;

import org.launchcode.models.data.HomeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lynnstrauss on 8/21/18.
 */

@Controller
@RequestMapping("home")

public class HomeController {

    @Autowired
    private HomeDao homeDao;

    //    Request path: /
    @RequestMapping(value = "")
    public String blog(Model model) {
        model.addAttribute("", homeDao.findAll());
        model.addAttribute("title", "SCW Football Home Page");
        return "home/index";
    }

}



