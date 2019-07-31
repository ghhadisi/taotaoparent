package com.taotao.sso.controller;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.impl.Log4JLogger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Log4j
public class PageController {



    @RequestMapping("/page/{page}")
    @ResponseBody
    public String  showPage(@PathVariable String page){
        log.error("page = "+page);
        return page;
    }
}
