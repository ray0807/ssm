package com.balloon.service.impl;

import javax.annotation.Resource;

import com.balloon.mapper.AuthKeyMapper;
import com.balloon.service.AuthService;

public class AuthServiceImpl implements AuthService {
	@Resource
	private AuthKeyMapper authKeyMapper;

	@Override
	public boolean checkAuthKey(String auth_key) {
		System.err.println("authKeyMapper==null:" + (authKeyMapper == null));
		return false;
	}

}
