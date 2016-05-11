package com.balloon.controller;

import javax.servlet.http.HttpServletRequest;




/**
 * baseController »ù´¡controller
 * @author ray
 *
 */
public class BaseController {
	
    public static final String SESSION_USER = "demo_login_user";

    public static final String SESSION_IDENTIFY_CODE = "auth_code";

    protected String getRemortIP(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null) {
            return request.getRemoteAddr();
        }
        return ip;
    }

    protected String getDomain(HttpServletRequest request) {
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
                + "/";
        return basePath;
    }
}
