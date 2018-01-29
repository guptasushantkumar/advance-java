<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert item</title>
</head>
<body>

	<form method="post" action="insert-item.do">
		Item name: <input type="text" name="itemName" /> <br /> 
		Price: <input type="text" name="price" /> <br /> 
		Description: <textarea rows="5" cols="20" name="itemName"></textarea><br />
		<input type="submit" value="Save item..."/>
	</form>

</body>
</html>