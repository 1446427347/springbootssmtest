package org.springboot.ssm.test.controller;

import lombok.extern.slf4j.Slf4j;
import org.springboot.ssm.test.service.IUserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class UserInformationController {

    @Autowired
    private IUserInformationService uis;

    @ResponseBody
    @RequestMapping("/users")
    public Object selectAll() {
        log.info("执行到这里了");
        return uis.selectAll();
    }
}
