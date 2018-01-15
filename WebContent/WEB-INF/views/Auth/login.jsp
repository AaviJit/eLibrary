<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body
	background="http://thethingsilearnedfrom.com/wp-content/uploads/2015/09/shutterstock_74085415small.jpg">
	<div class="container">
		<h1>eLibrary</h1>

		<div class="row">

			<div class="col-sm-4">
				<h3>Librarian Login</h3>
				<form action="CheckLibrarianLogin" method="post"
					style="background-color: #B2BEB5; padding: 30px">
					<table>
						<tr style="color: red;">
							<td><h3>${LibrarianErrorMessage}</h3></td>
						</tr>

						<tr>
							<td>Email Address</td>
							<td><input type="text" name="librarian_email" /></td>
						</tr>

						<tr>
							<td><br /></td>
						</tr>

						<tr>
							<td>Password</td>
							<td><input type="password" name="librarian_password" /></td>
						</tr>

						<tr>
							<td><br /></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" name="submit" value="Login" /></td>
						</tr>
					</table>
				</form>
				<a href="CheckAdminLogin">Admin Login</a>
			</div>
		</div>
	</div>
</body>
</html>