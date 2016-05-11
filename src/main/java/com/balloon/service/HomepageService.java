package com.balloon.service;

import java.util.Map;

public interface HomepageService {
	Map<String, Object> getHomepageData(int pageSize,int currentPage);

}
