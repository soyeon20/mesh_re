package com.choice.food.service.shop;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.choice.food.model.food.dto.FoodVO;
import com.choice.food.model.shop.dao.ProductDAO;
import com.choice.food.model.shop.dto.ProductVO;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Inject
	ProductDAO productDao;
	

	// 01. 음식점목록
	@Override
	public List<ProductVO> listProduct(String searchOption, String keyword) throws Exception{
		return productDao.listProduct(searchOption, keyword);
	}
	// 01-1  음식목록
	@Override
	public List<FoodVO> listFood(int productId) throws Exception{
		return productDao.listFood(productId);
	}
	// 02. 음식점상세
	@Override
	public ProductVO detailProduct(int productId) {
		return productDao.detailProduct(productId);
	}
	// 03. 음식점수정
	@Override
	public void updateProduct(ProductVO vo) {
		productDao.updateProduct(vo);
	}
	// 04. 음식점삭제
	@Override
	public void deleteProduct(int productId) {
		productDao.deleteProduct(productId);
	}
	// 05. 음식점추가
	@Override
	public void insertProduct(ProductVO vo) {
		productDao.insertProduct(vo);	
	}
	// 06. 음식점이미지 삭제를 위한 이미지파일 정보
	@Override
	public String fileInfo(int productId) {
		return productDao.fileInfo(productId);
	}

}
