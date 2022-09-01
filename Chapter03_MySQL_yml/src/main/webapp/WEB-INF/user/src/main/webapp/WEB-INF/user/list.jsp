<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<img src="../image/망상토끼.gif" alt="망상토끼" width="100" height="100" 
onclick="location.href='/'" style="cursor: pointer;">

<table id="userListTable" border="1" frame="hsides" rules="rows">
	<tr>
		<th width="150">이름</th>
		<th width="150">아이디</th>
		<th width="150">비밀번호</th>
	</tr>
	
	<!-- 동적 처리 -->
</table>

<div id = "pagingDiv"></div>
 <br><br>
 <div>
	 <!-- 글 검색 -->
	 <div style = "text-align : center; width: 450px;">
	 <form id = "SearchForm"> 
		 <input type="hidden" name="pg" id ="searchPg" value="1"><!--검색결과:  나는 무조건 1페이지에 뿌려줘야해 !  -->
		 <div style= "margin-left:200px; text-align:left;">
		 <select name = "searchOption">
		 	<option value="name">이름</option>
		 	<option value="id">아이디</option>
		 	</select>
		 	<input type="search" name="keyword" id="keyword" value="${keyword}">
		 	<input type="button" value="검색" id="SearchBtn">
		 </div>
	</form>
</div>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="../js/list.js"></script>
</body>
</html>










