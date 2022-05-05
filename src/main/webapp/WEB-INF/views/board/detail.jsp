<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>

	<div class="container">
		
		<button class="btn btn-secondary" onclick="history.back()">뒤로</button>
		<button class="btn btn-warning" id="btn-update">수정</button>
		<button class="btn btn-danger" id="btn-delete">삭제</button>
		<br /><br />
		<div>
			<h3>${ board.title }</h3>
		</div>
		<hr />
		<div>
			<div>${ board.content }</div>
		</div>
		<hr />
		
	</div>

<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp" %>