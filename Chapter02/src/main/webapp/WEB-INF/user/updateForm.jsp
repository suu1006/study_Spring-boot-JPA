<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<title>Insert title here</title>
</head>
<body>
<!-- <form method = "post" action = "">
	<label for="text">수정할 아이디 입력 :</label>
		<div id = "updateDiv" ></div> 이 부분이 아이디가 있는지 없는지 검사를 해
		<input type = "text" id="id">
	<button>검색</button>
 </form> 내가 작성해본거~~~ -->
<img src = "../image/jeongsu.gif" alt = "토끼" width = "300" height = "300" 
onclick = "location.href='/'" style = "cursor:pointer;">
 <p>
 	수정할 아이디 입력 <input type ="text" id = "searchId">
 	<input type ="button" id = "searchIdBtn" value = "검색">
 </p>
 
 <div id = "resultDiv"></div>
 <!-- 동적 처리 -->
 
 <div id = "updateDiv">
 <!-- 여기는 동적처리가 아니다 -->
	 <form id="updateForm" method="post" action="" >
	  <table border="1" >
	     <tr>
	        <td>이름</td>
	        <td>
	           <input type="text" name="name" id="name" value="" > <!-- readonly 로 수정 못하게 막는다. -->
	           <div id="nameDiv"></div>
	        </td>
	     </tr>
	     <tr>
	        <td>아이디</td>
	     <td>
	         <input type="text" name="id" id="id" value=""readonly>
	         <div id="idDiv"></div>
	     </td>
	      </tr>
	     <tr>
	         <td>비밀번호</td>
	        <td>
	            <input type="password" name="pwd" id="pwd">
	            <div id="pwdDiv"></div>
	        </td>
	      </tr>
	     <tr>
	        <td colspan="2" align="center">
	           <input type="button" value="회원정보수정" id="updateBtn">
	           <input type="reset" value="다시작성" id = "resetBtn" ><!-- reload하면 테이블 자체를 없애버린다. -->
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
		if ($('#searchId').val() == '')
			$('#resultDiv').text('아이디입력')
		else 
			$.ajax({
				type : 'post',
				url : '/user/getUser',
				data :'id=' + $('#searchId').val(),
				//dataType : 'json',
				/* 
				getUser에서 데이터 id를 찾으면 제대로 json으로 오지만, 
				id가 없으면 json으로 오지 못한다. 
				그래서 데이터 타입을 생략한다.
				
				-> dataType 을 생략하면 자료에 맞게 자동으로 형식이 지정된다. 
				
				*/
				success : function(data){
					// alert(JSON.stringify(data)); --> 값이 넘어오거나 또는 "" 라고 뜬다.(이거는 )
					
					/* $('#updateDiv').show();
					$('#name').val(data.name);
					$('#id').val(data.id);
					$('#pwd').val(data.pwd); */
					
					if(data == ''){
						$('#updateDiv').hide();
						$('#resultDiv').text('찾고자하는 아이디가 없습니다.');
					}else {
						$('#updateDiv').show();
						
						$('#name').val(data.name);
						$('#id').val(data.id);
						$('#pwd').val(data.pwd);
					}
				},
				error : function(err) {
			  		console.log(err);
					}
			  });
		});
	});
	
//다시작성
$('#reset').click(function(){
	$('#searchIdBtn').trigger('click'); //강제 이벤트 발생
	
});

//회원정보수정

$('#updateBtn').click(function(){
	
	 $('#nameDiv').empty(); // 초기화
      $('#pwdDiv').empty();
      
      if(!$('#name').val()) {
          $('#nameDiv').html('이름 입력');
      } else if(!$('#pwd').val()) {
          $('#pwdDiv').html('비밀번호 입력');
      } else {
    	  $.ajax({
    		  type: 'post',
    		  url : '/user/update', // /는 디스패처 서블릿 불러달라는 것
    		  data : $('#updateForm').serialize(), // 폼안의 모든 데이터 보내자
    		  success : function(){
    			  alert('회원님의 정보를 수정하였습니다.');
    			  location.href = '/user/list';
    		  },
    		  error : function(err) {
    			  console.log(err);
    		  }
    	  });
      }
});
</script>
</body>
</html>