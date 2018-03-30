<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

 -->
<!-- jstl 코어 태그 -->
testtttttttt

 현재 판교 날씨는 <span id ="todaysWeather"></span>
 
 그리고
 <span id ="todaysWeather2"></span>
<hr>

<!-- 
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
</script> -->