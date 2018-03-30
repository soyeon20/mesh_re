package com.choice.food.service.admin;

import com.choice.food.model.member.dto.MemberVO;

public interface AdminService {
	// 관리자 로그인체크
	public String loginCheck(MemberVO vo);
}
