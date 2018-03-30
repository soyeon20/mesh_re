package com.choice.food.controller.shop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.choice.food.model.shop.dao.CartDAO;
import com.choice.food.model.shop.dto.CartVO;
import com.choice.food.service.shop.CartService;

@Controller
@RequestMapping("/shop/cart/*")
public class CartController {
	
	@Inject
	CartService cartService;
	
	// 1. 식사기록 추가
	@RequestMapping("update.do")
	public String insert(@ModelAttribute CartVO vo, HttpSession session){
		// UserId session담기
		String userId = (String) session.getAttribute("userId");
		vo.setUserId(userId);

			// 없으면 insert
		cartService.insert(vo);
	
		return "redirect:/shop/cart/list.do";
	}
	
	// 2. 식사기록 목록
	@RequestMapping("list.do")
	public ModelAndView list(HttpSession session, ModelAndView mav){
		Map<String, Object> map = new HashMap<String, Object>();
		String userId = (String) session.getAttribute("userId"); // session에 저장된 userId
		
		List<CartVO> list = cartService.listCart(userId); // 식사기록 정보 
		int sumMoney = cartService.sumMoney(userId); // 식사기록 전체 금액 호출
		// 식사기록 전체 긍액
		
		map.put("list", list);				// 식사기록 정보를 map에 저장
		map.put("count", list.size());		// 식사기록 수의 유무
		map.put("sumMoney", sumMoney);		// 식사기록 전체 금액
		mav.setViewName("shop/cartList");	// view(jsp)의 이름 저장
		mav.addObject("map", map);			// map 변수 저장
		return mav;
	}
	
	// 3. 식사기록 삭제
	@RequestMapping("delete.do")
	public String delete(@RequestParam int cartId){
		cartService.delete(cartId);
		return "redirect:/shop/cart/list.do";
	}
	
	// 4. 식사기록 수정
	@RequestMapping("insert.do")
	public String update(@RequestParam String[] foodName, @RequestParam int[] foodPrice, @RequestParam int[] amount, @RequestParam int[] productId, HttpSession session) {
		// session의 id
		String userId = (String) session.getAttribute("userId");
		// 레코드의 갯수 만큰 반복문 실행
		for(int i=0; i<productId.length; i++){
			CartVO vo = new CartVO();
			vo.setUserId(userId);
			vo.setFoodName(foodName[i]);
			vo.setFoodPrice(foodPrice[i]);
			vo.setAmount(amount[i]);
			vo.setProductId(productId[i]);
			cartService.insert(vo);
		}
		
		return "redirect:/shop/cart/list.do";
	}
}
