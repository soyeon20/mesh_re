<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>식사 기록</title>
<%@ include file="../include/header.jsp" %>
<script>
	$(document).ready(function(){
		// 리스트 페이지로 이동
		$("#btnList").click(function(){
			location.href="${path}/shop/product/list.do";
		});
	});
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
	<h2>식사기록 확인</h2>
	<c:choose>
		<c:when test="${map.count == 0}">
			식사기록이 없습니다.
		</c:when>
		<c:otherwise>
		<form name="form1" id="form1" method="post" action="${path}/shop/cart/update.do">
			<table border="1">
				<tr>
					<th>음식점 명</th>
					<th>음식 명</th>
					<th>단가</th>
					<th>수량</th>
					<th>금액</th>
					<th>시간</th>
					<th>취소</th>
				</tr>
				<c:forEach var="row" items="${map.list}" varStatus="i">
				<tr>
					<td style="width: 100px">
						${row.productName}
					</td>
					<td style="width: 100px">
						${row.foodName}
					</td>
					<td style="width: 80px" align="right">
						<fmt:formatNumber pattern="###,###,###" value="${row.foodPrice}"/>
					</td>
					<td>
						<input type="number" style="width: 40px" name="amount" value="${row.amount}" min="1">
						<input type="hidden" name="productId" value="${row.productId}">
					</td>
					<td style="width: 100px" align="right">
						<fmt:formatNumber pattern="###,###,###" value="${row.money}"/>
					</td>
					
					<td>
					<fmt:formatDate value="${row.choiceDt}" pattern="yyyy-MM-dd HH:mm:ss"/>
					</td>
					<td>
						<a href="${path}/shop/cart/delete.do?cartId=${row.cartId}">삭제</a>
					</td>
				</tr>
				</c:forEach>
				<tr>
					<td colspan="5" align="right">
						식사기록 금액 합계 : <fmt:formatNumber pattern="###,###,###" value="${map.sumMoney}"/><br>

					</td>
				</tr>
			</table>
			<input type="hidden" name="count" value="${map.count}">
			
		</form>	
		</c:otherwise>
	</c:choose>
	<button type="button" id="btnList">음식점목록</button>
</body>
</html>