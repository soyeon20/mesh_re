package com.choice.food.service.admin;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.choice.food.model.admin.AdminDAO;
import com.choice.food.model.member.dto.MemberVO;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Inject
	AdminDAO adminDao;
	
	// 관리자 로그인체크
	@Override
	public String loginCheck(MemberVO vo) {
		return adminDao.loginCheck(vo);
	}

}
