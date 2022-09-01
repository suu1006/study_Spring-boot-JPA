<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#resultDiv {
 	color: red;
   font-weight: bold;
}
</style>
</head>
<body>
<img src = "../image/jeongsu.gif" alt = "토끼" width = "300" height = "300" 
onclick = "location.href='../index.jsp'" style = "cursor:pointer;">
<p>
 	삭제할 아이디 입력 <input type ="text" id = "searchId">
 	<input type ="button" id = "searchIdBtn" value = "검색">
</p>
 
<div id = "resultDiv"></div>
<!-- 동적 처리 -->
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

	$('#searchIdBtn').click(function(){
		
		 $('#resultDiv').empty();
	
		if ($('#searchId').val() == '')
			$('#resultDiv').text('아이디를 입력하세요.')
		else 
			$.ajax({
				type : 'post',
				url : '/user/getUser',
				data :'id=' + $('#searchId').val(),
			
				success : function(data){
					
					if(data == ''){
						
						$('#resultDiv').text('찾고자하는 아이디가 없습니다.');
						
					} else {
						if (confirm('정말로 삭제하시겠습니까?')){
							$.ajax({
								type : 'post',
								url : '/user/delete',
								data :'id=' + $('#searchId').val(),
								success : function(){
									 alert('회원님의 정보를 삭제하였습니다.');
					    			  location.href = '/user/list';
									},
								error : function(err) {
							  		console.log(err);
									}
							});
						}
					}
				},
					error : function(err) {
				  		console.log(err);
					}
			  });
		});
</script>
</body>
</html>