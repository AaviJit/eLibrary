<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="JSTL_tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="BootstrapTag.jsp"%>
</head>

<body
	background="https://lidenz.ru/wp-content/uploads/2015/04/376152628_249e3630c0_o.jpg">
	<%@ include file="NavBar.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-md-6">
				<form action="AddBook" method="post"
					style="background-color: #B2BEB5; padding: 30px">
					<h2>Add Book Here </h2>
					<table>
						<tr>
							<td>
								<h3>${BookEdition}${BookEditionError}</h3>
							</td>
						</tr>
						<tr>
							<td>Call No</td>
						</tr>
						<tr>
							<td><input type="text" name="collNo" /></td>
						</tr>

						<tr>
							<td>Name</td>
						</tr>
						<tr>
							<td><input type="text" name="name" /></td>
						</tr>

						<tr>
							<td>Author</td>
						</tr>
						<tr>
							<td><input type="text" name="author" /></td>
						</tr>

						<tr>
							<td>Publisher</td>
						</tr>
						<tr>
							<td><input type="text" name="publisher" /></td>
						</tr>

						<tr>
							<td>Quantity</td>
						</tr>
						<tr>
							<td><input type="text" name="quantity" /></td>
						</tr>

						<tr>
							<td><br /></td>
						</tr>
						<tr>
							<td><input type="submit" name="submit" Value="Save Book" /></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>