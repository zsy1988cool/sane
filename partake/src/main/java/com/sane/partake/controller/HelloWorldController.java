package com.sane.partake.controller;

import com.sane.partake.core.result.ResultModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="hello")
public class HelloWorldController {

    @RequestMapping(value="show")
    public String showHello() {
        return "Hello";
    }

    @ResponseBody
    @RequestMapping(value = "getResult")
    public ResultModel getResult() {
        ResultModel model = new ResultModel();
        model.setMessage("success");
        model.setCode(ResultModel.SUCCESS_CODE);

        return model;
    }
}
