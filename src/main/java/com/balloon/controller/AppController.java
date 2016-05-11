package com.balloon.controller;

import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.balloon.bean.AppData;
import com.balloon.constant.Constants;
import com.balloon.utils.BigDecimalEditor;
import com.balloon.utils.helper.JsonHelper;




public class AppController extends BaseController {
	private static final int fail=0; 
//	protected static final Logger log = LogManager.getLogger(BackendBaseController.class);

	/**
	 * 返回默认的基本参数 Description: <br/>
	 */
	@ModelAttribute
	public void getBaseParam(HttpServletRequest request, Model model) {
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
				+ "/";
		model.addAttribute("domain", basePath);
//		model.addAttribute("theme", Constants.THEME);
//		model.addAttribute("siteName", Constants.SITE_NAME);
		// model.addAttribute("domainImg",
		// BlueMobiConstants.getImgDomain(request));
	}

	/**
	 * 如果发生异常，将默认返回错误页面 Description: <br/>
	 */
	@ExceptionHandler(Throwable.class)
	protected String handleException(HttpServletRequest request, HttpServletResponse response, Exception ex) {
//		log.error(ExceptionUtils.getStackTrace(ex));

		String requestType = request.getHeader("X-Requested-With");
		if (StringUtils.equals(requestType, "XMLHttpRequest")) {
			// 是ajax请求
			AppData data = new AppData();
			data.setStatus(fail);
			data.setMsg(ExceptionUtils.getStackTrace(ex));
			PrintWriter out = null;
			try {
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/json;charset=UTF-8");
				out = response.getWriter();
				out.print(JsonHelper.toJson(data));
			} catch (Exception e) {
			} finally {
				if (out != null) {
					out.flush();
					out.close();
				}
			}
			return null;
		} else {
			return "error/500";
		}
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		BigDecimalEditor bigDecimalEditor = new BigDecimalEditor();
		binder.registerCustomEditor(BigDecimal.class, bigDecimalEditor);
	}
}
