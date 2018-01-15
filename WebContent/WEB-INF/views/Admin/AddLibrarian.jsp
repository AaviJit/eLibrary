<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Librarian</title>
<%@ include file="BootstrapTag.jsp"%>
</head>
<body
	background="https://www.princeton.edu/sites/default/files/styles/1x_full_2x_half_crop/public/images/2017/12/20170509_Eng_Library_DJA_012_3.jpg?itok=-WaXTWX8">
	<%@ include file="NavBar.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<form action="AddLibrarian" method="post"
					style="background-color: #B2BEB5; padding: 30px">
					<table>
						<tr>
							<td><h3>${emptyMessage}</h3></td>
						</tr>
						<tr>
							<td>Name</td>
						</tr>
						<tr>
							<td><input type="text" name="name" /></td>
						</tr>

						<tr>
							<td>Email</td>
						</tr>
						<tr>
							<td><input type="text" name="email" /></td>
						</tr>

						<tr>
							<td>Password</td>
						</tr>
						<tr>
							<td><input type="password" name="password" /></td>
						</tr>

						<tr>
							<td>Number</td>
						</tr>
						<tr>
							<td><input type="text" name="number" /></td>
						</tr>

						<tr>
							<td><br /></td>
						</tr>
						<tr>
							<td><input type="submit" name="submit" Value="Submit" /></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>