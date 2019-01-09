package com.sun.jsp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @
 * @Author:lvxiaoke
 * @Date: 2018/12/18
 * @
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/login_view",method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    Logger logger= LoggerFactory.getLogger(IndexController.class);
    @RequestMapping(value = "/log")
    @ResponseBody
    public String log(){
        if(logger.isInfoEnabled()){
            logger.info("IndexController.log.info....");
        }
        logger.debug("IndexController.log.debug....");
        logger.warn("IndexController.log.warn....");
        logger.error("IndexController.log.error....");
        return "";
    }

}
