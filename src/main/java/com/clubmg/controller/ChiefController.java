package com.clubmg.controller;

import com.clubmg.service.ChiefService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller("chiefController")
public class ChiefController {


    @Resource(name = "chiefService")
    private ChiefService chiefService;


    @ResponseBody
    @RequestMapping(value = "/allow_attend",method = RequestMethod.POST)
    public int allowJoin(Long applyUid, HttpSession session){
        Long currentUit = (Long) session.getAttribute("uid");
        chiefService.allowJoin(applyUid,currentUit);
        return 0;
    }

    @ResponseBody
    @RequestMapping(value = "/refuse_quit",method = RequestMethod.POST)
    public int refuseQuit(Long applyUid,HttpSession session){
        Long currentUit = (Long) session.getAttribute("uid");
        chiefService.refuseQuit(applyUid,currentUit);

        return 0;
    }

}
