<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload document</title>
<script type="text/javascript">
	var mimeType;
	var fileSize;
	var fileName;

	function checkFileSize(inputFile) {

		mimeType = inputFile.files[0].type;
		fileSize = inputFile.files[0].size;
		fileName = inputFile.files[0].name;
		document.getElementById("fileSize").value = filesize;
		document.getElementById("fileName").value = fileName;
		document.getElementById("mimeType").value = mimeType;
	}

	function call() {
		window.location = "upload?fileSize=" + fileSize + "&fileName="
				+ fileName + "&mimeType=" + mimeType;
	}
</script>
</head>
<body>
	<!-- enctype="multipart/form-data" -->
	<form method="POST" action="upload" enctype="multipart/form-data">
		Select file to upload: <input type="file" name="select" /> <br>
		<input type="hidden" id="fileSize" name="fileSize" /> <br> <input
			type="hidden" id="fileName" name="fileName" /> <br> <input
			type="hidden" id="mimeType" name="mimeType" /> <br> <input
			type="submit" name="submit" value="Upload" />
	</form>
	
</body>
</html>