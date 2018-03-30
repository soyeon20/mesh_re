<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>음식점 등록 페이지</title>
<%@ include file="../include/header.jsp" %>
<script>
	$(document).ready(function(){
		$("#addBtn").click(function(){
			var productName = $("#productName").val();
			var productPrice = $("#productPrice").val();
			var productDesc = $("#productDesc").val();
			var productPhoto = $("#productPhoto").val();
			
			if(productName == "") {
				alert("음식점명을 입력해주세요");
				productName.foucs();
			} else if (productPrice == "") {
				alert("음식점 가격을 입력해주세요");
				productPrice.focus();
			} else if (productDesc == "") {
				alert("음식점 설명을 입력해주세요");
				productDesc.focus();
			} else if (productPhoto == "") {
				alert("음식점 사진을 입력해주세요");
				productPhoto.focus();
			}
			document.form1.action = "${path}/shop/product/insert.do";
			document.form1.submit();
		});
	});
	
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
	<h2>음식점 등록</h2>
	<form action="" id="form1" name="form1" enctype="multipart/form-data" method="post">
		<table border="1">
			<tr>
				<td>음식점 명</td>
				<td><input type="text" name="productName" id="productName"></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="text" name="productPrice" id="productPrice"></td>
			</tr>
			<tr>
				<td>음식점 설명</td>
				<td><textarea rows="5" cols="60" name="productDesc" id="productDesc"></textarea></td>
			</tr>
			<tr>
				<td>음식점 이미지</td>
				<td><input type="file" name="productPhoto" id="productPhoto"></td>
			</tr>
			<tr>
				<td>카테고리</td>
				<td><input type="text" name="productCategory" id="productCategory"></td>
			</tr>
			<tr>
				<td>거리</td>
				<td><input type="text" name="productDistance" id="productDistance"></td>
			</tr>
			<tr>
				<td>번호</td>
				<td><input type="text" name="productTel" id="productTel"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="등록" id="addBtn">
					<input type="button" value="목록" onclick="location.href='${path}/shop/product/list.do';">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>