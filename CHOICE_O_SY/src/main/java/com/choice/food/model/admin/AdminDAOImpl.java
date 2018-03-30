package com.choice.food.model.admin;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.choice.food.model.member.dto.MemberVO;

@Repository
public class AdminDAOImpl implements AdminDAO {
	@Inject
	SqlSession sqlSession;
	@Override
	public String loginCheck(MemberVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("admin.loginCheck", vo);
	}

}
