<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<div class="table_list">
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">제목</th>
					<th scope="col">1번</th>
					<th scope="col">2번</th>
					<th scope="col">3번</th>
					<th scope="col">4번</th>
					<th scope="col">정답</th>
					<th scope="col">글 번호</th>
					<th scope="col">작성자</th>
					<th scope="col">삭제</th>
				</tr>
			</thead>
			<tbody id="tbody">
				<c:forEach var="problem" items="${problems.content}">
					<tr>
						<td>${problem.id}</td>
						<td>${problem.title}</td>
						<td>${problem.num1}</td>
						<td>${problem.num2}</td>
						<td>${problem.num3}</td>
						<td>${problem.num4}</td>
						<td>${problem.answer}</td>
						<td>${problem.board.id}</td>
						<td>${problem.board.username}</td>
						<td align="center"><input type = "button" class="btn btn-danger" value="문제 삭제"onclick="index.deleteProblem(${problem.id});"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<ul class="pagination justify-content-center">
		<c:choose>
			<c:when test="${problems.first}">
				<li class="page-item disabled"><a class="page-link" href="?page=${problems.number-1}">Previous</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item "><a class="page-link" href="?page=${problems.number-1}">Previous</a></li>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${problems.last}">
				<li class="page-item disabled"><a class="page-link" href="?page=${problems.number+1}">Next</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item "><a class="page-link" href="?page=${problems.number+1}">Next</a></li>
			</c:otherwise>
		</c:choose>


	</ul>
</div>
<script type="text/javascript" src="/js/problem.js"></script>
<%@ include file="../layout/footer.jsp"%>