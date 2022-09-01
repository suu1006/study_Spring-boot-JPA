<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<img src = "../image/jeongsu.gif" alt = "토끼" width = "300" height = "300" 
onclick = "location.href='/'" style = "cursor:pointer;">
<table id="userListTable" border="1" frame="hsides" rules="rows"> <!-- frame="hsides"가로선만 그릴거에요   rules="rows"행단위로요!-->
	<tr>
		<th width ="150">이름</th> <!-- th는 굵게 나온다. th = 테이블의 이름 -->
		<th width ="150">아이디</th>
		<th width ="150">비밀번호</th>
	</tr>
	
	<!-- 동적으로 처리한다. 동적으로 처리해서 디비를 여기에 가져다 붙이겠다. -->
	
</table>

	<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="../js/list.js"></script>
	
</body>
</html>
