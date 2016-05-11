package com.balloon.controller.app;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.balloon.bean.BaseData;
import com.balloon.controller.AppController;
import com.balloon.entity.Member;
import com.balloon.entity.UserAccountProxy;
import com.balloon.service.LoginService;

@Controller
public class LoginController extends AppController {
	@Resource
	private LoginService loginService;

	/**
	 * 登陆接口
	 * 
	 * @param account
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody BaseData<?> checkLogin(@RequestParam("account") String account,
			@RequestParam("password") String password) {
		Map<String, Object> result = null;
		UserAccountProxy proxy = new UserAccountProxy();
		result = loginService.login(account, password);
		int errorcode = (Integer) result.get("code");
		if (errorcode == 1) {
			Member member = (Member) result.get("member");
			proxy.setMember(member);
			BaseData<UserAccountProxy> data = new BaseData<UserAccountProxy>();
			data.data = proxy;
			data.errorCode = 1;
			data.msg = "success";
			data.page = null;
			return data;
		} else {

			BaseData<?> data = new BaseData<Object>();
			data.errorCode = errorcode;

			data.msg = (String) result.get("msg");
			return data;
		}
	}

	/**
	 * 注册接口
	 * 
	 * @param account
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	public @ResponseBody BaseData<Member> checkRegister(@RequestParam("account") String account,
			@RequestParam("password") String password, @RequestParam("vCode") String vCode) {
		BaseData<Member> data = new BaseData<Member>();
		if (vCode == null) {
			data.errorCode = 0;
			data.msg = "vCode is null";
			return data;
		}
		Map<String, Object> result = loginService.regitser(account, password);
		if (result == null) {
			data.errorCode = 0;
			data.msg = "未知错误";
			return data;
		}

		data.errorCode = (int) result.get("code");
		if (data.errorCode == 1) {
			Member member = (Member) result.get("member");
			if (member != null) {
				data.data = member;
			}
		}
		data.msg = (String) result.get("msg");

		return data;
	}
}
