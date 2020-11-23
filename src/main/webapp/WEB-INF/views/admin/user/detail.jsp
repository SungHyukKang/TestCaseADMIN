<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<form>
	<input type="hidden" name="userid" id="userid" value="${user.id }">
	<div class="container" style="width: 30%">
		<table class="table table-striped">
			<thead>
				<tr>
					<th colspan="3" style="text-align: center">회원 상세</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>회원 번호</td>
					<td>${user.id}</td>
				</tr>
				<tr>
					<td>회원 아이디</td>
					<td>${user.username }</td>
				</tr>
				<tr>
					<td>맞은 문제</td>
					<td>${user.solved }</td>
				</tr>
				<tr>
					<td>틀린 문제</td>
					<td>${user.wrong }</td>
				</tr>
				<tr>
					<td>즐겨찾기</td>
					<td>${user.favorite }</td>
				</tr>
			</tbody>
		</table>
	</div>
	<p align="center">
		<button id="btn-delete" class="btn btn-danger" >회원 탈퇴</button>
	</p>
	<div class="container">
		<h2 align="center">작성한 게시글</h2>
		<table class="table table-striped">
			<thead>
				<tr align="center">
					<th>글 번호</th>
					<th>글 제목</th>
					<th>글 내용</th>
					<th>문제 번호</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="board" items="${boards}">
					<tr onclick="location.href='/boardDetail/${board.id}'">
						<td align="center">${board.id}</td>
						<td align="center">${board.title}</td>
						<td align="center">${board.content}</td>
						<td align="center"><c:forEach var="problem" items="${board.problems}">
					${problem.id }&nbsp;
					</c:forEach></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</form>

<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>