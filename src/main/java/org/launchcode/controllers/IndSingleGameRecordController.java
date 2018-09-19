package org.launchcode.controllers;

import org.launchcode.models.IndSingleGameRecord;
import org.launchcode.models.data.IndSingleGameRecordDao;
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
 * Created by lynnstrauss on 8/25/17.
 */

@Controller
@RequestMapping("indSingleGameRecord")
public class IndSingleGameRecordController {

    @Autowired
    private IndSingleGameRecordDao indSingleGameRecordDao;


    //    Request path: /indSingleGameRecord
    @RequestMapping(value = "")
    public String indSingleGameRecord(Model model){
        model.addAttribute("indSingleGameRecords", indSingleGameRecordDao.findAll());
        model.addAttribute("title", "Individual Single Game Records");
        return "indSingleGameRecord/index";
    }


    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddIndSingleGameRecordForm(Model model) {
        model.addAttribute("title", "Add Individual Single Game Record");
        model.addAttribute(new IndSingleGameRecord());
        return "indSingleGameRecord/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddIndSingleGameRecordForm(@ModelAttribute @Valid IndSingleGameRecord newIndSingleGameRecord,
                                             Errors errors,
                                             Model model) {


        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Individual Single Game Record");
            return "indSingleGameRecord/add";
        }

        indSingleGameRecordDao.save(newIndSingleGameRecord);

        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveIndSingleGameRecordForm(Model model) {
        model.addAttribute("indSingleGameRecords", indSingleGameRecordDao.findAll());
        model.addAttribute("title", "Remove Individual Single Game Record");
        return "indSingleGameRecord/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveIndSingleGameRecordForm(@RequestParam int[] indSingleGameRecordIds) {

        for (int indSingleGameRecordId : indSingleGameRecordIds) {
            indSingleGameRecordDao.delete(indSingleGameRecordId);
           }

        return "redirect:";
    }

    @RequestMapping(value = "edit_choice", method = RequestMethod.GET)
    public String displayEditIndSingleGameRecordChoice(Model model) {
        model.addAttribute("indSingleGameRecords", indSingleGameRecordDao.findAll());
        model.addAttribute("title", "Edit Individual Single Game Record");
        return "indSingleGameRecord/edit_choice";

    }

    @RequestMapping(value = "edit_choice", method = RequestMethod.POST)
    public String processEditIndSingleGameRecordChoice(Model model, @RequestParam int id,
                                                       int[] indSingleGameRecordId) {
  {
            IndSingleGameRecord indSingleGameRecord = indSingleGameRecordDao.findOne(id);
        }
        return "redirect:indSingleGameRecord/edit?id="+id;

    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String displayEditIndSingleGameRecordForm(Model model){
        model.addAttribute("title", "Edit Individual Single Game Record");
        model.addAttribute(new IndSingleGameRecord());
        return "indSingleGameRecord/edit";
    }

}

