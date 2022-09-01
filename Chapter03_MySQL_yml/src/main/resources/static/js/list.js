$(function(){
	$.ajax({
		type: 'post',
		url : '/user/getUserList',
		dataType: 'json',
		 success : function(data){ // 데이터 받아야함
			 // alert(JSON.stringify(data)); // 
			 
			 $.each(data, function(index, items){
				 $('<tr/>').append($('<td/>', {
					 align:'center',
					 text:items.name
				 })).append($('<td/>', {
					 align:'center',
					 text:items.id
				 })).append($('<td/>', {
					 align:'center',
					 text:items.pwd
				 })).appendTo($('#userListTable')); // tr 밑으로 자식이 생긴다.
			 });
		  },
		  	error : function(err) {
		  		console.log(err);
		 }
	 });
});

// 검색
$('#SearchBtn').click(function(){
	if ($('#keyword').val() == '') alert('검색어를 입력하세요');
	else
		$.ajax({
			type : 'post',
			url : '/user/getUserSearchList',
			data : $('#searchForm').serialize(), //pg, searchOption, keyword 이렇게 세개가 넘어옴 / name속성을 걸어야 submit으로 넘어옴 
			dataType : 'json',
			success : function(data) {
				alert(JSON.stringify(data));
				
				$('userListTable tr :gt(0)').remove(); // 검색할떄마다 아래에 달라붙게되버림... 타이틀만 놔두고 달라붙는거 제거하라는것 
				
				 $.each(data, function(index, items){
					 $('<tr/>').append($('<td/>', {
						 align:'center',
						 text:items.name
					 })).append($('<td/>', {
						 align:'center',
						 text:items.id
					 })).append($('<td/>', {
						 align:'center',
						 text:items.pwd
					 })).appendTo($('#userListTable')); // tr 밑으로 자식이 생긴다.
				 });  // $.each
		  	},
			error : function(err) {
				cosole.log(err);
		}
	});
});
