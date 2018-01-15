<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="JSTL_tag.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Librarian</title>
<%@ include file="style.css"%>
<%@ include file="BootstrapTag.jsp"%>
</head>
<body
	background="https://www.sciencenewsforstudents.org/sites/default/files/2017/05/main/blogposts/860_main_library_bacteria.png">
	<%@ include file="NavBar.jsp"%>

	<div class="container">
		<div class="row">

			<div class="col-sm-3"></div>
			<div class="col-md-6">
				<h2>List Of Librarians</h2>
				<form action="LibrarianInfo" method="get"
					style="background-color: #B2BEB5; padding: 10px">
					<table>
						<tr>
							<th></th>
							<th>Name</th>
							<th>Email</th>
							<th>Password</th>
							<th>Phone</th>
							<th></th>
							<th></th>
						</tr>
						<c:forEach var="list" items="${librarianList}">
							<tr>
								<td><input type="hidden" name="id" value="${list.id}">
								<td><c:out value="${list.name}" /></td>
								<td><c:out value="${list.email}" /></td>
								<td><c:out value="${list.password}" /></td>
								<td><c:out value="${list.number}" /></td>
								<td><a href="DeleteLibrarian?id=${list.id}">Delete</a></td>
								<td><a href="EditLibrarians?id=${list.id}">Edit</a></td>
							</tr>
						</c:forEach>
					</table>
				</form>
			</div>
			<div class="col-sm-3"></div>
		</div>
	</div>
</body>
</html>