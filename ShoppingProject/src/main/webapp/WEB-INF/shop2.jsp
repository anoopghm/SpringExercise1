<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Vegetable Shop....</h1>
	<form action="shopping.do" method="post">
		<input type="hidden" name="action" value="shopping"> <input
			type="hidden" name="shopid" value="shop2"> 
			Potato:<input type="checkbox" name="c1" value="Potato"> 
			Garlic:<input type="checkbox" name="c2" value="Garlic"> 
			Capsicum:<input type="checkbox" name="c3" value="Capsicum"> 
			<input type="submit" value="Next Shop">
	</form>
</body>
</html>