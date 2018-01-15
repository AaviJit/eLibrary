<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="BootstrapTag.jsp"%>
</head>
<body
	background="https://courtauld.ac.uk/wp-content/uploads/2015/02/book-library-Courtauld-Institute-2013-110.jpg">

	<%@ include file="NavBar.jsp"%>
	<div class="container">

		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-md-6">
				<form action="ReturnBook" method="post"
					style="background-color: #B2BEB5; padding: 30px">
					<table>
						<tr>
							<td>Call No</td>
						</tr>
						<tr>
							<td><input type="text" name="callNo" /></td>
						</tr>

						<tr>
							<td>Student ID</td>
						</tr>
						<tr>
							<td><input type="text" name="studentID" /></td>
						</tr>
						<tr>
							<td><br /></td>
						</tr>
						<tr>
							<td><input type="submit" value="Return Book"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>