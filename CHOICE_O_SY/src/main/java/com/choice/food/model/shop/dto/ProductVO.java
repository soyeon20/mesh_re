package com.choice.food.model.shop.dto;

import org.springframework.web.multipart.MultipartFile;

public class ProductVO {
	private int productId; // 음식점번호
	private String productName; // 음식점이름
	private int productPrice; // 음식점가격
	private String productDesc; // 음식점 상세정보
	private String productUrl; // 음식점이미지 경로
	private String productDistance;//음식점과의 거리
	private String productCategory;//음식점 분류
	private String productTel;
	public String getProductTel() {
		return productTel;
	}
	public void setProductTel(String productTel) {
		this.productTel = productTel;
	}
	private MultipartFile productPhoto; // 음식점이미지파일
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductDistance() {
		return productDistance;
	}
	public void setProductDistance(String productDistance) {
		this.productDistance = productDistance;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public String getProductUrl() {
		return productUrl;
	}
	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}
	public MultipartFile getProductPhoto() {
		return productPhoto;
	}
	public void setProductPhoto(MultipartFile productPhoto) {
		this.productPhoto = productPhoto;
	}
	@Override
	public String toString() {
		return "ProductVO [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productDesc=" + productDesc + ", productUrl=" + productUrl + ", productPhoto=" + productPhoto
				+ "]";
	}
	
}
