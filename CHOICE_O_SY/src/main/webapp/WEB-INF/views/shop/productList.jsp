<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>음식점 리스트</title>
<%@ include file="../include/header.jsp" %>

<script>

function parseWeather(s) 
{ 
      loadJSON(function(response) 
      {
          var jsonData = JSON.parse(response);
           document.getElementById("todaysWeather").innerHTML = jsonData["list"][0]["weather"][0]["main"];    
           document.getElementById("todaysWeather2").innerHTML = jsonData["list"][0]["weather"][0]["main"];    
      });
}

function loadJSON(callback) //url의 json 데이터 불러오는 함수
{   
  var url = "http://api.openweathermap.org/data/2.5/forecast/daily?q=Busan,KR&cnt=7&APPID=047ea91a02e19c4e493ceb04d81879f6";
  var request = new XMLHttpRequest();
  request.overrideMimeType("application/json");
  request.open('GET', url, true);
  request.onreadystatechange = function () 
  {
    if (request.readyState == 4 && request.status == "200") 
    {
      callback(request.responseText);
    }
  };
  request.send(null);  
} 
window.onload = function()
{
parseWeather();
}


	$(document).ready(function(){
		var beFore = $("#before").val();
		$("#btnRandom").click(function(){
			var ranDom = Math.round(Math.random()*${map.size()}+1);
			var num = parseInt(beFore);
			while(num==ranDom)
			{ranDom = Math.round(Math.random()*${map.size()}+1);}
			
			location.href="${path}/shop/product/detail/"+ranDom;
		});
		$("#btnAdd").click(function(){
			location.href="${path}/shop/product/write.do";
		});
		$("#btnEdit").click(function(){
			location.href="${path}/shop/product/edit.do";
		});
	});
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>

 현재 판교 날씨는 <span id ="todaysWeather"></span>

	<h2>음식점 목록</h2>

	 <form name="form1" method="post" action="${path}/shop/product/list.do">
	 
	 	
        <select name="searchOption">
            <!-- 검색조건을 검색처리후 결과화면에 보여주기위해  c:out 출력태그 사용, 삼항연산자 -->
            <option value="all" <c:out value="${map.searchOption == 'all'?'selected':''}"/> > 전체 조회</option>
            <option value="PRICE_RANGE" <c:out value="${map.searchOption == 'PRICE_RANGE'?'selected':''}"/> >가격</option>
            <option value="RESTAURANT_CATEGORY" <c:out value="${map.searchOption == 'RESTAURANT_CATEGORY'?'selected':''}"/> >분류</option>
            <option value="RESTAURANT_DISTANCE" <c:out value="${map.searchOption == 'RESTAURANT_DISTANCE'?'selected':''}"/> >거리</option>
        </select>
        <input name="keyword" value="${map.keyword}">
        <input type="submit" value="조회">
       
    </form>
    
    
  
    <button type="button" id="btnRandom">랜덤 선택</button><br>
    
	<c:if test="${sessionScope.adminId != null}">
		<button type="button" id="btnAdd">음식점 등록</button><br>
	</c:if>
	<table border="1">
		<tr>
			<th>음식점ID</th>
			<th>음식점 이미지</th>
			<th>음식점 명</th>
			<th>가격</th>
			<th>분류</th>
			<th>거리</th>
			<th>전화번호</th>
		</tr>
		<c:forEach var="row" items="${map.list}">
		<tr>
			<td>
				${row.productId}
			</td>
			<td>
				<a href="${path}/shop/product/detail/${row.productId}">
					<img src="${path}/images/${row.productUrl}" width="150ox" height="130px">
				</a>
			</td>
			<td align="center">
				<a href="${path}/shop/product/detail/${row.productId}">${row.productName}</a><br>
			</td>
			<td>
				<fmt:formatNumber value="${row.productPrice}" pattern="###,###,###"/>
			</td>
			<td>
				${row.productCategory}
			</td>
			<td>
				${row.productDistance}
			</td>
			<td>
				${row.productTel}
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>