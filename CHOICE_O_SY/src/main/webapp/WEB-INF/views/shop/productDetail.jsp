<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>음식점 상세정보</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
	<h2>음식점 상세정보</h2>
	<table border="1">
	
		<tr>
			<td>
				<img src="${path}/images/${vo.productUrl}" width="340" height="300">
			</td>
			<td>
				<table border="1" style="height: 300px; width: 400px;">
					<tr align="center">
						<td>음식점명</td>
						<td>${vo.productName}</td>
					</tr>
					<tr align="center">
						<td>가격</td>
						<td><fmt:formatNumber value="${vo.productPrice}" pattern="###,###,###"/></td>
					</tr>
					<tr align="center">
						<td>음식점소개</td>
						<td>${vo.productDesc}</td>
					</tr>
					<tr align="center">
						<td>분류</td>
						<td>${vo.productCategory}</td>
					</tr>
					<tr align="center">
						<td>거리</td>
						<td>${vo.productDistance}</td>
					</tr>
					<tr align="center">
						<td>음식점 번호</td>
						<td>${vo.productTel}</td>
					</tr>
					
					<tr align="center">
						<td colspan="2">
							<form name="form1" method="post" action="${path}/shop/cart/insert.do">							
							<table border="1">
								<tr>
									<th>음식 이름</th>
									<th>가격</th>
									<th>정보</th>
									<th>선택</th>
								</tr>
								
							
								<c:forEach var="row" items="${map.list}" varStatus="num">
								<tr>

								<td>
									${row.product_name}
								</td>
								<td>
									${row.product_price}
								</td>
								<td>
									${row.product_desc}
								</td>
								<td>
									<input type="hidden" name="productId" value="${vo.productId}">
									<input type="hidden" name="foodName" value="${row.product_name}">
									<input type="hidden" name="foodPrice" value="${row.product_price}">
										<select name="amount">
										<c:forEach begin="1" end="10" var="i">
											<option value="${i}">${i}</option>
										</c:forEach>
									</select>&nbsp;개
								</td>
								</tr>
								</c:forEach>

							</table>
							
					
									<input type="submit" value="식사기록에 추가">
									</form>
							
							
							
							<a href="${path}/shop/product/list.do?before=${vo.productId}">음식점 목록</a>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>