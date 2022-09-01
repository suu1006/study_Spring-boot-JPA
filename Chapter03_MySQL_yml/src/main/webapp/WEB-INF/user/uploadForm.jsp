<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#img{
	visibility:hidden;
}
</style>
</head>
<body>
<!-- 1번.단순 submit -->
<!--  <form id="uploadForm" method="post" enctype="multipart/form-data" 
			action = "/chapter06_SpringWebMaven/user/upload"> <!--  method="post" enctype="multitype/form-data" 필수!! 꼭 필요하다! -->

<!-- 2번. Ajax(비동기통신- 요청이 올때까지 기다리지 않고 할일을 하겠다!) -->
<form id = "uploadForm">

<h3>파일을 1개씩 선택 업로드하자</h3>
<br>

<h3>파일을 여러 개 선택 업로드하자</h3>
<img src="../image/camera.svg" id="camera"> <!-- 카메라 아이콘을 누르면 파일 선택과 똑같은 효과를 내야한다. 강제 이벤트 발생 시켜야함. >> trigger -->
<input type = "file" name = "img[]" id = "img" multiple> <!-- 여러개니까 배열로 잡힌다. -->

<br><br>
<input type="button" id="uploadBtn" value="이미지등록">
</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
	
	$('#camera').click(function(){ // 카메라를 클릭하면 
		$('#img').trigger('click'); // 강제 이벤트 발생
	}); 
	
	$('#uploadBtn').click(function(){
		// 1. 단순 submit -> 페이지를 이동해라
		// $('#uploadForm').submit();
		
		// 2. Ajax 통신 
		
		var formData = new FormData($('#uploadForm')[0]); //<form> 폼안에 있는 모든 것들을 의미
		
		
		$.ajax({
			//반드시 post 전송해야함.
			type: 'post',
			url : '/user/upload',
			enctype: "multipart/form-data", // 인코딩 방법
			processData:false,
			contentType : false,
			data:formData,
			success : function(){
				 alert('업로드 완료!')
			},
			error : function(err) {
				console.log(err);
			}
		});
	});
})
</script>
</body>
</html>

<!-- 
processData
 - 기본값은 true
 - 기본적으로 Query String으로 변환해서 보내진다('변수=값&변수=값')
 - 파일 전송시에는 반드시 false로 해야 한다.(formData를 문자열로 변환하지 않는다)
 
contentType
  - 기본적으로 "application/x-www-form-urlencoded; charset=UTF-8"
  - 파일 전송시에는 'multipart/form-data'로 전송이 될 수 있도록 false로 설정한다
 -->