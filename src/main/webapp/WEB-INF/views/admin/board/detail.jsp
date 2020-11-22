<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<form>
	<div class="container">
		<input type="hidden" name="boardId" id="boardId" value="${board.id }">
		<h2 align="center">작성한 게시글</h2>
		<table class="table table-striped">
			<thead>
				<tr align="center">
					<th>글 번호</th>
					<th>글 제목</th>
					<th>글 내용</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td align="center">${board.id}</td>
					<td align="center">${board.title}</td>
					<td align="center">${board.content}</td>
				</tr>
			</tbody>
		</table>
		<p align="center">
			<button id="board-delete" class="btn btn-danger">글 삭제</button>
		</p>

		<div class="container">
			<h2 align="center">게시글에 등록된 문제</h2>
			<table class="table table-striped">
				<thead>
					<tr align="center">
						<th>문제 번호</th>
						<th>문제 제목</th>
						<th>*</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="problem" items="${board.problems}">
						<tr>
							<td align="center">${problem.id}</td>
							<td align="center">${problem.title}</td>
							<td align="center"><input type = "button" class="btn btn-danger" value="문제 삭제"onclick="index.deleteProblem(${problem.id});"></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</form>
<script type="text/javascript" src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>