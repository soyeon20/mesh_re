package com.choice.food.model.shop.dao;

import java.util.List;

import com.choice.food.model.shop.dto.CartVO;

public interface CartDAO {
	// 1. 식사기록 추가
	public void insert(CartVO vo);
	// 2. 식사기록 리스트
	public List<CartVO> listCart(String userId);
	// 3. 식사기록 삭제
	public void delete(int cartId);
	// 4. 식사기록 수정
	public void modifyCart(CartVO vo);
	// 5. 식사기록 금액 합계
	public int sumMoney(String userId);
	// 6. 식사기록 확인
	public int countCart(int productId, String userId);
	// 7. 식사기록 수량 변경
	public void updateCart(CartVO vo);
}
