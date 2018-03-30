package com.choice.food.model.shop.dto;

import java.util.Date;

public class CartVO {
	private int cartId; 		// 식사기록 번호
	private String userId; 		// 사용자 아이디
	private String userName; 	// 사용자 이름
	private String foodName;
	private int foodPrice;
	private Date choiceDt;
	public int getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(int foodPrice) {
		this.foodPrice = foodPrice;
	}
	public Date getChoiceDt() {
		return choiceDt;
	}
	public void setChoiceDt(Date choiceDt) {
		this.choiceDt = choiceDt;
	}
	private int productId; 		// 식사기록 번호
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	private String productName; // 식사기록 이름
	private int productPrice; 	// 식사기록 단가
	private int amount; 		// 구매 수량
	private int money; 			// 음식 가격

	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
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
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "CartVO [cartId=" + cartId + ", userId=" + userId + ", userName=" + userName + ", productId=" + productId
				+ ", productName=" + productName + ", productPrice=" + productPrice + ", amount=" + amount + ", money="
				+ money + "]";
	}
	
	
}
