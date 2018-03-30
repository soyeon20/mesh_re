<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 작성</title>
<%@ include file="../include/header.jsp" %>
<script>
    $(document).ready(function(){
    	
    	listReply("1");
    	
    	$("#btnRplWrite").click(function(){
      	  replyJson();           
      });   
    	
    	
        $("#btnDelete").click(function(){
            if(confirm("삭제하시겠습니까?")){
                document.form1.action = "${path}/board/delete.do";
                document.form1.submit();
            }
        });
        
        $("#btnUpdete").click(function(){
            //var title = document.form1.title.value; ==> name속성으로 처리할 경우
            //var content = document.form1.content.value;
            //var writer = document.form1.writer.value;
            var title = $("#title").val();
            var content = $("#content").val();
            var writer = $("#writer").val();
            if(title == ""){
                alert("제목을 입력하세요");
                document.form1.title.focus();
                return;
            }
            if(content == ""){
                alert("내용을 입력하세요");
                document.form1.content.focus();
                return;
            }
            if(writer == ""){
                alert("이름을 입력하세요");
                document.form1.writer.focus();
                return;
            }
            document.form1.action="${path}/board/update.do"
            // 폼에 입력한 데이터를 서버로 전송
            document.form1.submit();
        });        
                  
    }); 
    
    
   /*  
    var bno = '${dto.bno}'; */    
    
    function replyJson(){
        var replytext=$("#replytext").val();
        var bno="${dto.bno}"
        // ** 비밀댓글 체크여부
        var secretReply = "n";
        // 태그.is(":속성") 체크여부 true/false
        if( $("#secretReply").is(":checked") ){
            secretReply = "y";
        }
        $.ajax({                
            type: "post",
            url: "${path}/reply/insertRest.do",
            headers: {
                "Content-Type" : "application/json"
            },
            dateType: "text",
            // param형식보다 편하다.
            data: JSON.stringify({
                bno : bno,
                replytext : replytext,
                secretReply : secretReply
            }),
            success: function(){
                alert("댓글이 등록되었습니다.");
                //listReply2();
                listReply("1");
            }
        });
    }
        
    function changeDate(date){
        date = new Date(parseInt(date));
        year = date.getFullYear();
        month = date.getMonth();
        day = date.getDate();
        hour = date.getHours();
        minute = date.getMinutes();
        second = date.getSeconds();
        strDate = year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;
        return strDate;
    }

    
    function listReply(num){
        $.ajax({
            type: "get",
            url: "${path}/reply/list.do?bno=${dto.bno}&curPage="+num,
            success: function(result){
            // responseText가 result에 저장됨.
                $("#listReply").html(result);
            }
        });
    }    
    
    function listReply2(){
        $.ajax({
            type: "get",
            //contentType: "application/json", ==> 생략가능(RestController이기때문에 가능)
            url: "${path}/reply/listJson.do?bno=${dto.bno}",
            success: function(result){
                console.log(result);
                var output = "<table>";
                for(var i in result){
                    output += "<tr>";
                    output += "<td>"+result[i].userName;
                    output += "("+changeDate(result[i].regdate)+")<br>";
                    output += result[i].replytext+"</td>";
                    output += "<tr>";
                }
                output += "</table>";
                $("#listReply").html(output);
            }
        });
    }
    
 // 2_3. 댓글 목록 - Rest방식
    function listReplyRest(num){
        $.ajax({
            type: "get",
            url: "${path}/reply/list/${dto.bno}/"+num,
            success: function(result){
            // responseText가 result에 저장됨.
                $("#listReply").html(result);
            }
        });
    }    
    
    // **댓글 수정화면 생성 함수
    function showReplyModify(rno){
        $.ajax({
            type: "get",
            url: "${path}/reply/detail/"+rno,
            success: function(result){
                $("#modifyReply").html(result);
                // 태그.css("속성", "값")
                $("#modifyReply").css("visibility", "visible");
            }
        })
    }
    
    $.getJSON("/replie")
    
 /*  //댓글 목록 
    function commentList(){
        $.ajax({
            url : '/reply/list.do',
            type : 'get',
            data : {'bno':bno},
            success : function(data){
                var a =''; 
                $.each(data, function(key, value){ 
                    a += '<div class="commentArea" style="border-bottom:1px solid darkgray; margin-bottom: 15px;">';
                    a += '<div class="commentInfo'+value.rno+'">'+'댓글번호 : '+value.rno+' / 작성자 : '+value.replyer;
                    a += '<a onclick="commentUpdate('+value.rno+',\''+value.content+'\');"> 수정 </a>';
                    a += '<a onclick="commentDelete('+value.rno+');"> 삭제 </a> </div>';
                    a += '<div class="commentContent'+value.rno+'"> <p> 내용 : '+value.content +'</p>';
                    a += '</div></div>';
                });
                
                $(".commentList").html(a);
            }
        });
    }
     
    //댓글 등록
    function commentInsert(insertData){
        $.ajax({
            url : '/reply/insert.do',
            type : 'post',
            data : insertData,
            success : function(data){
                if(data == 1) {
                    commentList(); //댓글 작성 후 댓글 목록 reload
                    $('[name=content]').val('');
                }
            }
        });
    }
 */
    
</script>
<style>
#modifyReply {
        width: 600px;
        height: 130px;
        background-color: gray;
        padding: 10px;
        z-index: 10;
        visibility: hidden;
    }

</style>

</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>게시글 보기</h2>
<form name="form1" method="post">
    <div>        <!-- 원하는 날짜형식으로 출력하기 위해 fmt태그 사용 -->
        작성일자 : <fmt:formatDate value="${dto.regdate}" pattern="yyyy-MM-dd a HH:mm:ss"/>
                <!-- 날짜 형식 => yyyy 4자리연도, MM 월, dd 일, a 오전/오후, HH 24시간제, hh 12시간제, mm 분, ss 초 -->
    </div>
    <div>
        조회수 : ${dto.viewcnt}
    </div>
    <div>
        제목
        <input name="title" id="title" size="80" value="${dto.title}" placeholder="제목을 입력해주세요">
    </div>
    <div>
        내용
        <textarea name="content" id="content" rows="7" cols="80" placeholder="내용을 입력해주세요">${dto.content}</textarea>
    </div>
    <div>
        이름
        <input name="writer" id="writer" value="${dto.writer}" placeholder="이름을 입력해주세요">
    </div>
    <div style="width:650px; text-align: center;">
        <!-- 게시물번호를 hidden으로 처리 -->
        <input type="hidden" name="bno" value="${dto.bno}">
        <button type="button" id="btnUpdete">수정</button>
        <button type="button" id="btnDelete">삭제</button>
    </div>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${sessionScope.userId == null}">
		login해야보임
	</c:when>
	<c:otherwise>
		<div style="width: 650px; text-align: center;">
			<textarea name="replytext" id="replytext" rows="4" cols="80"
				placeholder="댓글을 입력해주세요"></textarea>
				
			<button type="button" id="btnRplWrite" name="btnRplWrite">댓귿등록</button>
		</div>
	</c:otherwise>
</c:choose>	
	</form>
	  <div id="listReply"></div>
</body>
</html>
