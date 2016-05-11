package com.balloon.controller.app;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.balloon.bean.Page;
import com.balloon.controller.AppController;
import com.balloon.service.HomepageService;
import com.balloon.service.LoginService;

@Controller
public class HomeController extends AppController {
	private Page page;
	@Resource
	private HomepageService homepageService;
	@RequestMapping(value = "/getHomepageData", method = RequestMethod.GET)
	public @ResponseBody String getHomepageData(@RequestParam(value = "pageSize", required = false) String pageSize,
			@RequestParam(value = "currentPage", required = false) String currentPage) {
		if (pageSize != null && currentPage != null) {
			page = new Page(Integer.parseInt(currentPage), Integer.parseInt(pageSize), 0);
		} else {
			page = new Page(1, 15, 0);
		}
		System.out.println("page:" + page.toString());
		homepageService.getHomepageData(page.pageSize, page.currentPage);
		return "1";

	}

}
