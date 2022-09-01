<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#img {
	visibility: hidden;
}
</style>
</head>
<body>
<form id="uploadForm">
<img src="../image/camera.svg" id="camera">
<input type="file" name="img" id="img">
<img id="showImg" style="position: absolute; left: 600px; top: 50px; max-width: 300px;">
<br><br>
<input type="button" id="uploadBtn" value="이미지 등록">
</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
function readURL(input){
	console.log("input = " + input);
	if(input.files[0]){
		console.log("input.files[0] = " + input.files[0]);
		var reader = new FileReader();
		reader.onload = function(e){
			console.log("e.target = " + e.target.tagName);
			$("#showImg").attr("src", e.target.result);
		}
		
		reader.readAsDataURL(input.files[0]);
	}
}
	
$(function(){
	$('#img').on('change', function(){
		readURL(this);
	});
	
	$('#camera').click(function(){
		$('#img').trigger('click');
	});
	
	$('#uploadBtn').click(function(){
		var formData = new FormData($('#uploadForm')[0]); //<form /> 안의 모든 것
		
		$.ajax({
			type: 'post',
			url: '/user/upload',
			enctype: 'multipart/form-data',
			processData: false,
			contentType: false,
			data: formData,
			success: function(){
				alert('업로드 완료');
			},
			error: function(err){
				console.log(err);
			}
		});
	});
});
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
 
 
 
 
 
 
 
 
 








