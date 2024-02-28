package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GbcVo;
@Repository
public class GbcDao {

	@Autowired
	private SqlSession sqlSession;
	
	public List<GbcVo> listSelect() {
		List<GbcVo> voList = sqlSession.selectList("guestbook.list");
		return voList;
	}
	
	public int insert(GbcVo gbcVo) {
		int count = sqlSession.insert("guestbook.insert",gbcVo);
		return count;
	}
	public int delete(GbcVo gbcVo) {
		int count = sqlSession.delete("guestbook.delete",gbcVo);
		return count;
	}
	
}
