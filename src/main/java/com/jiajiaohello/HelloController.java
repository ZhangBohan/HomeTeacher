package com.jiajiaohello;

import com.jiajiaohello.support.web.MessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.jiajiaohello.support.core.CommonHelper.LOG;


@Controller
@RequestMapping("/")
public class HelloController {

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(Model model) {
        LOG.info("welcome init");
		model.addAttribute("msg", "你好，世界!");
        MessageHelper.addSuccessAttribute(model, "你好，%s", "伯函");
		return "hello";
	}
}