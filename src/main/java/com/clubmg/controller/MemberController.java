package com.clubmg.controller;

import com.clubmg.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class MemberController {

    @Resource(name = "memberService")
    private MemberService memberService;

    @ResponseBody
    @RequestMapping(value = "/join_club",method = RequestMethod.POST)
    public int joinClub(Long cid, HttpSession session) {
        Long uid = (Long) session.getAttribute("uid");
        if(uid==null)return -1;
        memberService.joinClub(uid, cid);
        return 0;
    }


    @ResponseBody
    @RequestMapping(value = "/quit_club",method = RequestMethod.POST)
    public int quitClub(Long cid,HttpSession session) {
        Long uid = (Long) session.getAttribute("uid");
        return memberService.quitClub(uid,cid);
    }


    @ResponseBody
    @RequestMapping(value = "/apply_position",method = RequestMethod.POST)
    public int applyPosition(Long cid,String position,HttpSession session) {
        Long uid = (Long) session.getAttribute("uid");
        memberService.applyPosition(uid,cid,position);
        return 0;
    }

    @ResponseBody
    @RequestMapping(value = "/resign",method = RequestMethod.POST)//辞职
    public int resign(Long cid,String position,HttpSession session) {
        Long uid = (Long) session.getAttribute("uid");
        memberService.resign(uid,cid,position);
        return 0;
    }

    @ResponseBody
    @RequestMapping(value = "/attend_activity",method = RequestMethod.POST)
    public int attendActivity(Long aid,HttpSession session) {
        Long uid = (Long) session.getAttribute("uid");
        memberService.attendActivity(aid,uid);
        return 0;
    }


    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    public int exceptionHandler() {
        System.out.println("\n\n");
        System.out.println("-----------------------------");
        System.out.println("In Member ExceptionHandler");
        return -1;
    }


}
