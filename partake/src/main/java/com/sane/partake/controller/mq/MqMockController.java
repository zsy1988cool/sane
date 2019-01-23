package com.sane.partake.controller.mq;

import com.sane.partake.service.mq.ActiveMqService;
import com.sane.partake.core.result.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value="mq")
@RestController
public class MqMockController {

    @Autowired
    ActiveMqService activeMqService;

    @RequestMapping(value = "sendMessage")
    public ResultModel sendActiveMessage(@RequestParam(value = "messsage", defaultValue = "Hello World") String message) {
        try {
            activeMqService.sendMessage(message);
        } catch (Exception e) {
            return ResultModel.fail(e.getMessage(), "发送信息错误");
        }

        return ResultModel.success();
    }

    @RequestMapping(value = "getMessage")
    public ResultModel receiveActiveMessage() {
        try {
            List<String> messageList = activeMqService.receiveMessage();
            return ResultModel.success(messageList);
        } catch (Exception e) {
            return ResultModel.fail(e.getMessage(), "发送信息错误");
        }
    }
}
