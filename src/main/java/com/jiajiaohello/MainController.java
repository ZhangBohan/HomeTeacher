package com.jiajiaohello;

import com.jiajiaohello.core.account.model.RecommendType;
import com.jiajiaohello.core.account.model.TeacherAccount;
import com.jiajiaohello.core.account.service.TeacherAccountService;
import com.jiajiaohello.support.core.IpData;
import com.jiajiaohello.support.web.MessageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jiajiaohello.support.core.CommonHelper;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    private TeacherAccountService teacherAccountService;

    @RequestMapping
    public String index(Model model) {
        // set recommend teachers list
        List<TeacherAccount> list = teacherAccountService.getRecommendTeacherAccounts(RecommendType.top, 0, 4);
        model.addAttribute("topList", list);
        list = teacherAccountService.getRecommendTeacherAccounts(RecommendType.row1, 0, 3);
        model.addAttribute("row1List", list);
        list = teacherAccountService.getRecommendTeacherAccounts(RecommendType.row2, 0, 3);
        model.addAttribute("row2List", list);
        list = teacherAccountService.getRecommendTeacherAccounts(RecommendType.row3, 0, 3);
        model.addAttribute("row3List", list);
        return "index";
    }

    @RequestMapping(value = "/teachers/{teacherId}")
    public String teachers(@PathVariable("teacherId") Integer teacherId, Model model) {
        TeacherAccount teacherAccount = teacherAccountService.get(teacherId);
        model.addAttribute("teacher", teacherAccount);
        return "teachers";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String printWelcome(Model model, HttpServletRequest request) {
        CommonHelper.LOG.info("welcome init");
        model.addAttribute("msg", "你好，世界!");
        String ip = CommonHelper.getIP(request);
        IpData ipData = CommonHelper.analyzeIP(ip);
        model.addAttribute("ip", ip);
        model.addAttribute("ipData", ipData);
        MessageHelper.addSuccessAttribute(model, "你好，%s", "伯函1");
        return "hello";
    }

    @RequestMapping(value = "/ticket", method = RequestMethod.GET)
    public String getTicket(Integer teacherId, Model model) {
        if(teacherId != null) {
            TeacherAccount teacherAccount = teacherAccountService.get(teacherId);
            model.addAttribute("teacher", teacherAccount);
        }

        return "ticket";
    }

    @RequestMapping(value = "error",method = RequestMethod.GET)
    public void error() throws Exception {
        CommonHelper.LOG.error("exception test");
        throw new Exception("exception test");
    }

    @RequestMapping(value = "ali/index",method = RequestMethod.GET)
    public String aliIndex() {
        return "ali/index";
    }

    @RequestMapping(value = "ali/api",method = RequestMethod.GET)
    public String aliAPI() {
        return "ali/alipayapi";
    }
}