<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="mytag" uri="http://sample.webapp.co.in/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Date tag</title>
</head>
<body>
	<form action="fetch" method="post">
		<mytag:date-of-birth monthFieldName="month" yearFieldName="year"
			dayFieldName="day" endingYear="2000" startingYear="1950"></mytag:date-of-birth>
		<input type="submit" />
	</form> 

</body>
</html>