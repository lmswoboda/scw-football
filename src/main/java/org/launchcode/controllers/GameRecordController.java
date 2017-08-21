
package org.launchcode.controllers;

import org.launchcode.models.Blog;
import org.launchcode.models.GameRecord;
import org.launchcode.models.data.GameRecordDao;
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
@RequestMapping("gameRecord")
public class GameRecordController {

    @Autowired
    private GameRecordDao gameRecordDao;

    //    Request path: /gameRecord
    @RequestMapping(value = "")
    public String gameRecord(Model model){
        model.addAttribute("gameRecords", gameRecordDao.findAll());
        model.addAttribute("title", "Individual Single Game Records");
        return "gameRecord/index";
    }


    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddGameRecordForm(Model model) {
        model.addAttribute("title", "Add Game Record");
        model.addAttribute(new GameRecord());
        return "gameRecord/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddGameRecordForm(@ModelAttribute @Valid GameRecord newGameRecord,
                                     Errors errors,
                                     Model model) {


        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Game Record");
            return "gameRecord/add";
        }

        gameRecordDao.save(newGameRecord);

        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveGameRecordForm(Model model) {
        model.addAttribute("gameRecords", gameRecordDao.findAll());
        model.addAttribute("title", "Remove Game Record");
        return "gameRecord/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveGameRecordForm(@RequestParam int[] gameRecordIds) {

        for (int gamerecordId : gameRecordIds) {
            gameRecordDao.delete(gamerecordId);
        }

        return "redirect:";
    }


}
