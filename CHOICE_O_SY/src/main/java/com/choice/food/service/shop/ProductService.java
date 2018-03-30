package com.choice.food.service.shop;

import java.util.List;

import com.choice.food.model.food.dto.FoodVO;
import com.choice.food.model.shop.dto.ProductVO;

public interface ProductService {
	// 01. 음식점목록
	public List<ProductVO> listProduct(String searchOption, String keyword) throws Exception;
	public List<FoodVO> listFood(int productId) throws Exception;
	// 02. 음식점상세
	public ProductVO detailProduct(int productId);
	// 03. 음식점수정
	public void updateProduct(ProductVO vo);
	// 04. 음식점삭제
	public void deleteProduct(int productId);
	// 05. 음식점추가
	public void insertProduct(ProductVO vo);
	// 06. 음식점이미지 삭제를 위한 이미지파일 정보
	public String fileInfo(int productId);
	
}
