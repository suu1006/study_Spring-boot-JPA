<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#updateForm div {
	color: red;
	font-size: 8pt;
	font-weight: bold;
}

#resultDiv {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
<img src="../image/망상토끼.gif" alt="망상토끼" width="100" height="100" 
onclick="location.href='/'" style="cursor: pointer;">

<p>
	수정 할 아이디 입력 <input type="text" id="searchId">
	<input type="button" id="searchIdBtn" value="검색">
</p>

<div id="resultDiv">
	<!-- 동적 처리 -->
</div>

<div id="updateDiv">
	<form id="updateForm" method="post">
		<table border="1" >
			<tr>
				<td>이름</td>
				<td>
					<input type="text" name="name" id="name" value="">
					<div id="nameDiv"></div>
				</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" name="id" id="id" value="" readonly>
					<div id="idDiv"></div>
				</td>
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="password" name="pwd" id="pwd" value="">
					<div id="pwdDiv"></div>
				</td>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="회원정보수정" id="updateBtn">
					<input type="reset" value="다시작성" id="resetBtn">
				</td>
			</tr>
		</table>
	</form>
</div>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
	$('#updateDiv').hide();
	
	$('#searchIdBtn').click(function(){
		$('#resultDiv').empty();
		
		if($('#searchId').val() == '')
			$('#resultDiv').text('아이디을 입력하세요')
		else
			$.ajax({
				type: 'post',
				url: '/user/getUser',
				data: 'id=' + $('#searchId').val(),
				//dataType: 'json',
				/*
				getUser에서 id를 찾으면 제대로 JSON으로 오지만 id가 없으면 JSON 오지를 못한다.
				그래서 dataType를 생략해야 한다. (dataType를 생략하면 자료에 맞게 자동으로 형식이 지정된다.)
				*/
				success: function(data){
					//id가 있으면 {"name":"홍길동","id":"hong","pwd":"111"} 또는 id가 없으면 ""
					// alert(JSON.stringify(data)); -
					
					if(data == ''){
						$('#updateDiv').hide();
						
						$('#resultDiv').text('찾고자 하는 아이디가 없습니다.');
						
					}else{
						$('#updateDiv').show();
						
						$('#name').val(data.name);
						$('#id').val(data.id);
						$('#pwd').val(data.pwd);
					}
				},
				error: function(err){
					 console.log(err);
				 }
			});
	});
});

//다시작성
$('#resetBtn').click(function(){
	$('#searchIdBtn').trigger('click');//강제 이벤트 발생
});

//회원정보수정
$('#updateBtn').click(function(){
	$('#nameDiv').empty();
	$('#pwdDiv').empty();
      
	 if(!$('#name').val()) {
		 $('#nameDiv').html('이름 입력');
	 }else if(!$('#pwd').val()) {
		 $('#pwdDiv').html('비밀번호 입력');
	 }else{
		 $.ajax({
			 type: 'post',
			 url: '/user/update',
			 data: $('#updateForm').serialize(),
			 success: function(){
				 alert('회원님의 정보를 수정하였습니다.');
				 location.href='/user/list';
			 },
			 error: function(err){
				 console.log(err);
			 }
		 });
	 }	
});
</script>
</body>
</html>












