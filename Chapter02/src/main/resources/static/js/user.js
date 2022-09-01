
//이름, 아이디, 비밀번호 유효성 검사
$(function(){
	$('#writeBtn').click(function(){
		 $('#nameDiv').empty(); // 초기화
	      $('#idDiv').empty();
	      $('#pwdDiv').empty();
	      
	      if(!$('#name').val()) {
	          $('#nameDiv').html('이름 입력.');
	      } else if(!$('#id').val()) {
	          $('#idDiv').html('아이디 입력.');
	      } else if(!$('#pwd').val()) {
	          $('#pwdDiv').html('비밀번호 입력.');
	      } else {
	    	  $.ajax({
	    		  type: 'post',
	    		  url : '/user/write', // /는 디스패처 서블릿 불러달라는 것
	    		  data : $('#writeForm').serialize(), // 폼안의 모든 데이터 보내자
	    		  success : function(){
	    			  alert('회원가입을 축하합니다.');
	    			  location.href = '/user/list';
	    		  },
	    		  error : function(err) {
	    			  console.log(err);
	    		  }
	    	  });
	      }
	});

	//아이디중복 체크 -> 포커스가 들어갔다가 나오면 중복처리될 수 있게
	$('#id').focusout(function(){
		  $('#idDiv').empty();
		  if ($('#id').val() == '')
			  $('#idDiv').text('필수 정보입니다.');
		  else 
			  $.ajax({
				  type : 'post',
				  url : '/user/checkId',
				  data : 'id=' + $('#id').val(), // 아이디값을 보내줘야지
				  dataType : 'text',
				  success : function(data) {
					 if (data == 'exist')
						 $('#idDiv').text('사용불가능');
					 else {
						 $('#idDiv').text('사용가능');
						 $('#idDiv').css('color', 'blue');// 이렇게 작성해주면 우선권은 나 ! 작성해주지 않으면 writeform css부분이 빨간색이어서 빨간색으로 뜰것이다! 
					 }
				  },
				  error : function(err) {
		   			  console.log(err);
				  }
			 });
	});
	
	 
});
	