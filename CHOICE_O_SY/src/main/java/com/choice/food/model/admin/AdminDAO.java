package com.choice.food.model.admin;

import com.choice.food.model.member.dto.MemberVO;

public interface AdminDAO {
	// 관리자 로그인체크
	public String loginCheck(MemberVO vo);
}
