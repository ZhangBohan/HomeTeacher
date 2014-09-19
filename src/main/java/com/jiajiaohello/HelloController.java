package com.jiajiaohello;

import com.jiajiaohello.support.core.IpData;
import com.jiajiaohello.support.web.MessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jiajiaohello.support.core.CommonHelper;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/")
public class HelloController {

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(Model model, HttpServletRequest request) {
        CommonHelper.LOG.info("welcome init");
		model.addAttribute("msg", "你好，世界!");
        String ip = CommonHelper.getIP(request);
        IpData ipData = CommonHelper.analyzeIP(ip);
        model.addAttribute("ip", ip);
        model.addAttribute("ipData", ipData);
        MessageHelper.addSuccessAttribute(model, "你好，%s", "伯函");
		return "hello";
	}

    @RequestMapping(value = "/ali/index",method = RequestMethod.GET)
    public String aliIndex() {
        return "ali/index";
    }

    @RequestMapping(value = "/ali/api",method = RequestMethod.GET)
    public String aliAPI() {
        return "ali/alipayapi";
    }
}