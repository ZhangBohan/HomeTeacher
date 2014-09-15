package com.jiajiaohello;

import static com.jiajiaohello.support.core.Utils.LOG;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class HelloController {

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
        LOG.info("welcome init");
		model.addAttribute("message", "你好，世界!");
		return "hello";
	}
}