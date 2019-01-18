package com.sane.partake.controller.intellisense;

import com.sane.partake.core.result.ResultModel;
import com.sane.partake.entity.intellisense.Thesaurus;
import com.sane.partake.service.intellisense.ThesaurusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "thea")
public class ThesaurusController {

    @Autowired
    ThesaurusService thesaurusService;

    @ResponseBody
    @RequestMapping(value = "findAll")
    public ResultModel findAll() {
        List<Thesaurus> dataList = thesaurusService.findAll(50);
        return ResultModel.success("success", dataList);
    }
}
