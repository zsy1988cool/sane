package com.sane.partake.controller.user;

import com.sane.partake.core.result.ResultModel;
import com.sane.partake.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "user")
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping(value="getUser")
    ResultModel getUserByNo(@RequestParam(defaultValue = "1502") String userNo) {
        try {
            return ResultModel.success("获取用户信息成功", userService.getUserByNo(userNo));
        } catch (Exception e) {
            return ResultModel.fail("获取用户信息失败", "错误");
        }
    }
}
