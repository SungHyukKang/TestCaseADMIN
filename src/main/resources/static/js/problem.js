let index = {
	init: function() {
	},
	deleteProblem: function(pid){
		$.ajax({
			type: "POST",
			url: "/deleteProblem/"+pid,
			dataType: "json" //요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열(생긴게 Json이라면) => javascript 
		}).done(function(resp){
			alert("삭제 완료");
			location.reload();
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); //ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청
	},
}
index.init();