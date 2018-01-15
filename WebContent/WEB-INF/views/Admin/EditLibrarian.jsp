<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="JSTL_tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Librarian</title>
<%@ include file="BootstrapTag.jsp"%>
</head>
<body
	background="https://www.falmouth.ac.uk/sites/default/files/respimg/course_slideshow_full/normal/public/image/1p5b8588.jpg?itok=0SHNDtHv">

	<%@ include file="NavBar.jsp"%>
	<div class="contailer">
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">

				<form action="EditLibrarians" method="post"
					style="background-color: #B2BEB5; padding: 30px">
					<table>
						<tr>
							<td>Name</td>
						</tr>
						<tr>
							<td><input type="text" value="${librarianObject.name}"
								name="name" /></td>
						</tr>

						<tr>
							<td>Email</td>
						</tr>
						<tr>
							<td><input type="text" value="${librarianObject.email}"
								name="email" /></td>
						</tr>

						<tr>
							<td>Password</td>
						</tr>
						<tr>
							<td><input type="password"
								value="${librarianObject.password}" name="password" /></td>
						</tr>

						<tr>
							<td>Number</td>
						</tr>
						<tr>
							<td><input type="text" value="${librarianObject.number}"
								name="number" /></td>
						</tr>

						<tr>
							<td><br /> <input type="hidden" name="id"
								value="${librarianObject.id }"></td>
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