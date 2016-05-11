package com.balloon.controller.app;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.balloon.bean.BaseData;
import com.balloon.constant.Constants;
import com.balloon.controller.AppController;
import com.balloon.service.LoginService;

@Controller
public class AuthController extends AppController {
	@Resource
	private LoginService loginService;

	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public @ResponseBody BaseData<?> checkAuthKey(@RequestParam("authkey") String defaultAuthKey,
			@RequestParam("authkey_tag") String authkeyTag) {
		BaseData<?> data = new BaseData<Object>();

		if (Constants.AUTH_KEY_DEFAULT.equals(defaultAuthKey) && Constants.AUTH_KEY_TOKEN.equals(authkeyTag)) {
			data.errorCode = 99;
			data.msg = "认证失败";

		} else {
			data.errorCode = 98;
			data.msg = "非法请求";
		}

		return data;

	}
}
