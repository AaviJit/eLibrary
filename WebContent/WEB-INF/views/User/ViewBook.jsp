<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="JSTL_tag.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="style.css"%>
<%@ include file="BootstrapTag.jsp"%>
</head>
<body
	background=" https://www.thehagueuniversity.com/images/default-source/studievoorzieningen/bibliotheek/over-de-bibliotheek.jpg?sfvrsn=335152ee_4">

	<%@ include file="NavBar.jsp"%>

	<div class="container">
		<div class="row">
			<h2 style="color:white">List of Books</h2>
			<form action="ViewBook" method="get"
				style="background-color: #B2BEB5; padding: 10px">
				<table>
					<tr>
						<th>Book No</th>
						<th>Book Name</th>
						<th>Author Name</th>
						<th>Publisher</th>
						<th>Quantity</th>
						<th>Issued</th>
					</tr>
					<c:forEach var="booklist" items="${bookList}">
						<tr>
							<td><c:out value="${booklist.callNo}" /></td>
							<td><c:out value="${booklist.name}" /></td>
							<td><c:out value="${booklist.author}" /></td>
							<td><c:out value="${booklist.publisher}" /></td>
							<td><c:out value="${booklist.quantity}" /></td>
							<td><c:out value="${booklist.issued}" /></td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</div>
	</div>
</body>
</html>