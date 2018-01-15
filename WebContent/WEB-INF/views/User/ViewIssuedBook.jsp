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
	background="http://www.sambhajicollegemurudlatur.com/Images/Content/library.jpg">

	<%@ include file="NavBar.jsp"%>

	<div class="container">

		<div class="sm-col-3"></div>
		<div class="md-col-6">
			<h2>Issued Book List</h2>
			<form style="background-color: #B2BEB5; padding: 10px">
				<table>
					<tr>
						<th>Student ID</th>
						<th>Book No</th>
						<th>Student Name</th>
						<th>Student Number</th>
						<th>Date</th>
						<th>Return Status</th>
					</tr>
					<c:forEach var="isuuedBookList" items="${IssuedList}">
						<tr>
							<td><c:out value="${ isuuedBookList.studentId}" /></td>
							<td><c:out value="${ isuuedBookList.callNo}" /></td>
							<td><c:out value="${ isuuedBookList.studentName}" /></td>
							<td><c:out value="${ isuuedBookList.phoneNumber}" /></td>
							<td><c:out value="${ isuuedBookList.date}" /></td>
							<td><c:out value="${ isuuedBookList.returnStatus}" /></td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</div>
	</div>
</body>
</html>