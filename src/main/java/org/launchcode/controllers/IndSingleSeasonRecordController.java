package org.launchcode.controllers;

import org.launchcode.models.IndSingleSeasonRecord;
import org.launchcode.models.data.IndSingleSeasonRecordDao;
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
 * Created by lynnstrauss on 8/28/17.
 */

@Controller
@RequestMapping("indSingleSeasonRecord")
public class IndSingleSeasonRecordController {

    @Autowired
    private IndSingleSeasonRecordDao indSingleSeasonRecordDao;

    //    Request path: /indSingleSeasonRecord
    @RequestMapping(value = "")
    public String indSingleSeasonRecord(Model model){
        model.addAttribute("indSingleSeasonRecords", indSingleSeasonRecordDao.findAll());
        model.addAttribute("title", "Individual Single Season Records");
        return "indSingleSeasonRecord/index";
    }


    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddIndSingleSeasonRecordForm(Model model) {
        model.addAttribute("title", "Add Individual Single Season Record");
        model.addAttribute(new IndSingleSeasonRecord());
        return "indSingleSeasonRecord/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddIndSingleSeasonRecordForm(@ModelAttribute @Valid IndSingleSeasonRecord newIndSingleSeasonRecord,
                                                    Errors errors,
                                                    Model model) {


        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Individual Single Season Record");
            return "indSingleSeasonRecord/add";
        }

        indSingleSeasonRecordDao.save(newIndSingleSeasonRecord);

        return "redirect:";
    }


    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveIndSingleSeasonRecordForm(Model model) {
        model.addAttribute("indSingleSeasonRecords", indSingleSeasonRecordDao.findAll());
        model.addAttribute("title", "Remove Individual Single Season Record");
        return "indSingleSeasonRecord/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveIndSingleSeasonRecordForm(@RequestParam int[] indSingleSeasonRecordIds) {

        for (int indSingleSeasonRecordId : indSingleSeasonRecordIds) {
            indSingleSeasonRecordDao.delete(indSingleSeasonRecordId);
        }

        return "redirect:";
    }


}



