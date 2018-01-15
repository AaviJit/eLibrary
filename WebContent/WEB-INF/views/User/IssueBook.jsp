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
	background="http://blog.hsl.virginia.edu/news/wp-content/uploads/sites/5/2011/08/Library-Service-Desk-1.jpg">

	<%@ include file="NavBar.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-md-6">

				<form action="IssueBook" method="post"
					style="background-color: #B2BEB5; padding: 30px">
					<table>
						<tr>
							<td>Student ID</td>
						</tr>
						<tr>
							<td><input type="text" name="studentID"></td>
						</tr>

						<tr>
							<td>CallNo</td>
						</tr>
						<tr>
							<td><input type="text" name="callNo"></td>
						</tr>

						<tr>
							<td>Student Name</td>
						</tr>
						<tr>
							<td><input type="text" name="studentName"></td>
						</tr>

						<tr>
							<td>Student Mobile</td>
						</tr>
						<tr>
							<td><input type="text" name="studentMobile"></td>
						</tr>

						<tr>
							<td><br /></td>
						</tr>

						<tr>
							<td><input type="submit" name="submit" value="Issue Book"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>