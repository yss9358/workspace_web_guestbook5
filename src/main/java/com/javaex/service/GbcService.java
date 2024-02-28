package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GbcDao;
import com.javaex.vo.GbcVo;
@Service
public class GbcService {
	@Autowired
	private GbcDao gbcDao;
	
	public List<GbcVo> exeAddlist() {
		List<GbcVo> gbcList = gbcDao.listSelect();
		return gbcList;
	}
	public int exeInsert(GbcVo gbcVo) {
		int count = gbcDao.insert(gbcVo);
		return count;
	}
	public int exeDelete(GbcVo gbcVo) {
		int count = gbcDao.delete(gbcVo);
		return count;
	}
}
