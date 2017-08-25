package org.launchcode.controllers;

import org.launchcode.models.IndSingleGameRecord;
import org.launchcode.models.data.IndSingleGameRecordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lynnstrauss on 8/25/17.
 */

@Controller
@RequestMapping("IndSingleGameRecord")
public class IndSingleGameRecordController {

    @Autowired
    private IndSingleGameRecordDao indSingleGameRecordDao;


}
