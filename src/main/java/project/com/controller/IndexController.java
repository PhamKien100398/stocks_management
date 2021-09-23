package project.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import project.com.service.UserService;

@Controller
public class IndexController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView wellcome(Model model) {
		ModelAndView mv = new ModelAndView();
		model.addAttribute("list", userService.getAll());
		mv.setViewName("wellcome");
		return mv;
	}
}
