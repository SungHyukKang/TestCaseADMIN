<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp"%>
<div class="container">

	<div class="table_list">
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">회원상태</th>
					<th scope="col">가입일</th>
				</tr>
			</thead>
			<tbody id="tbody">
				<c:forEach var="user" items="${users.content}">
					<tr onclick="location.href='/userDetail/${user.id}'">
						<td>${ user.username}</td>
						<c:choose>
						<c:when test="${user.roles=='ROLE_USER'}">
						<td>회원</td>
						</c:when>
						<c:otherwise>
						<td>관리자</td>
						</c:otherwise>
						</c:choose>
						<td>${user.createDate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<ul class="pagination justify-content-center">
		<c:choose>
			<c:when test="${users.first}">
				<li class="page-item disabled"><a class="page-link" href="?page=${users.number-1}">Previous</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item "><a class="page-link" href="?page=${users.number-1}">Previous</a></li>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${users.last}">
				<li class="page-item disabled"><a class="page-link" href="?page=${users.number+1}">Next</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item "><a class="page-link" href="?page=${users.number+1}">Next</a></li>
			</c:otherwise>
		</c:choose>


	</ul>
</div>
<%@ include file="layout/footer.jsp"%>