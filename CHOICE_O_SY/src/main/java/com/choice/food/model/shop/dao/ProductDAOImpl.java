package com.choice.food.model.shop.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.choice.food.model.food.dto.FoodVO;
import com.choice.food.model.shop.dto.ProductVO;

@Repository
public class ProductDAOImpl implements ProductDAO {
		
	@Inject
	SqlSession sqlSession;

	@Override
	public List<ProductVO> listProduct(String searchOption, String keyword) throws Exception{
			   // 검색옵션, 키워드 맵에 저장
		    Map<String, String> map = new HashMap<String, String>();
		    map.put("searchOption", searchOption);
		    map.put("keyword", keyword);
		    return sqlSession.selectList("product.listProduct", map);
	}
	@Override
	public List<FoodVO> listFood(int productId) throws Exception{
	return sqlSession.selectList("product.listFood", productId);	
	}

	@Override
	public ProductVO detailProduct(int productId) {
		
		return sqlSession.selectOne("product.detailProduct", productId);
	}

	@Override
	public void updateProduct(ProductVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertProduct(ProductVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String fileInfo(int productId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
