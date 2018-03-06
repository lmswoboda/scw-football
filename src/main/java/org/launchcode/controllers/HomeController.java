
package org.launchcode.controllers;

import org.launchcode.models.Blog;
import org.launchcode.models.data.BlogDao;
import org.launchcode.models.data.HomeDao;
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
 * Created by lynnstrauss on 8/20/17.
 */

@Controller
@RequestMapping("home")
public class HomeController {

    @Autowired
    private HomeDao homeDao;

    //    Request path: /home
    @RequestMapping(value = "")
    public String blog(Model model){
        model.addAttribute("homes", homeDao.findAll());
        model.addAttribute("title", "SCW Football Home Page");
        return "home/index";
    }
}
