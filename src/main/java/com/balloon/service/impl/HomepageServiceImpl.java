package com.balloon.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.balloon.entity.HomePageData;
import com.balloon.mapper.HomePageDataMapper;
import com.balloon.service.HomepageService;
@Service
@Transactional
public class HomepageServiceImpl implements HomepageService {
	@Resource
	private HomePageDataMapper homePageDataMapper;
	@Override
	public Map<String, Object> getHomepageData(int pageSize, int currentPage) {
		List<HomePageData> data=homePageDataMapper.selectByGroup(10);
		for (HomePageData homePageData : data) {
			System.err.println(homePageData.toString());
		}
		
		return null;
	}

}
