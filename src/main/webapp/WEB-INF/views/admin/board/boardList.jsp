<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
	<div class="table_list">
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">제목</th>
					<th scope="col">내용</th>
					<th scope="col">문제 번호</th>
				</tr>
			</thead>
			<tbody id="tbody">
				<c:forEach var="board" items="${boards.content}">
					<tr onclick="location.href='/boardDetail/${board.id}'">
						<td>${board.id}</td>
						<td>${board.title}</td>
						<td>${board.content}</td>
						<td><c:forEach var="problem" items="${board.problems}">
						${problem.id }&nbsp;
					</c:forEach></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<ul class="pagination justify-content-center">
		<c:choose>
			<c:when test="${boards.first}">
				<li class="page-item disabled"><a class="page-link" href="?page=${boards.number-1}">Previous</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item "><a class="page-link" href="?page=${boards.number-1}">Previous</a></li>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${boards.last}">
				<li class="page-item disabled"><a class="page-link" href="?page=${boards.number+1}">Next</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item "><a class="page-link" href="?page=${boards.number+1}">Next</a></li>
			</c:otherwise>
		</c:choose>


	</ul>
</div>
<%@ include file="../layout/footer.jsp"%>