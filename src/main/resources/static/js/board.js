let index = {
	init: function() {
		$("#board-delete").on("click",()=>{
			this.deleteById();
		});
	},
	save: function(){
		let data={
			title:$("#title").val(),
			content: $("#content").val(),
		}
		$.ajax({
			type: "POST",
			url: "/api/board",
			data: JSON.stringify(data), //http body 데이터 
			contentType: "application/json; charset=utf-8", //body 데이터가 어떤 타입인지(MIME)
			dataType: "json" //요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열(생긴게 Json이라면) => javascript 
		}).done(function(resp){
			alert("글쓰기 완료");
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); //ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청
	},
	deleteById: function(){
		let id = $("#boardId").val();
		$.ajax({
			type: "POST",
			url: "/board/delete/"+id,
			dataType: "json" //요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열(생긴게 Json이라면) => javascript 
		}).done(function(resp){
			alert("삭제 완료");
			location.href="/board/boardList";
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); //ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청
	},
	
	deleteProblem: function(id){
		$.ajax({
			type: "POST",
			url: "/deleteProblem/"+id,
			dataType: "json" //요청dd을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열(생긴게 Json이라면) => javascript 
		}).done(function(resp){
			alert("삭제 완료");
			location.reload();
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); //ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청
	},
	
	
}

index.init();