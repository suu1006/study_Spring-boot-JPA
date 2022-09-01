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
