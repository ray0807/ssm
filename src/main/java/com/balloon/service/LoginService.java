package com.balloon.service;

import java.util.Map;

import com.balloon.entity.Member;

public interface LoginService {

	Map<String, Object> login(String account, String password);

	Map<String, Object> regitser(String account, String password);

	Member getMemberInfo(String member_id);


}
