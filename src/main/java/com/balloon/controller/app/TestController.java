package com.balloon.controller.app;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.balloon.controller.AppController;

@Controller
public class TestController extends AppController {

	@RequestMapping("/test")
	public String test(HttpServletRequest request, Model model) {
		
		
		
		model.addAttribute("message", "" + request.getParameter("name"));
		return "Hello";
	}

	@RequestMapping("/test1")
	public String test1(@RequestParam("name") String name, Model model) {
		model.addAttribute("message", name);
		return "Hello";
	}
}
