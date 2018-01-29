<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index page</title>
</head>
<body>
	<%
		int scriptletvariable = 100;
		out.println("From the scriptlet:" + scriptletvariable);
	%>
	<%-- This is a jsp comment --%>
	<%!private int instancevariable = 500;

	private int getInstancevariable() {
		return instancevariable;
	}%>
	<p>
		<%=getInstancevariable()%>
	</p>
	<table>
		<%
			for (int x = 1; x <= scriptletvariable; x++) {
		%>
		<tr>
			<td>
				<%
					x = x;
				%>
			</td>
		</tr>
		<%
			}
		%>
	</table>
	
</body>
</html>