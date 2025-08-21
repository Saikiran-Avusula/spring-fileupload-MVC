<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>File Upload</title>
</head>
<body>

<a href="<c:url value='/files/list' />">View Uploaded Files</a>
<br/><br/>

<h2>Upload a File</h2>

<c:if test="${not empty message}">
    <div style="color: ${message.toLowerCase().contains('success') ? 'green' : 'red'};">
        ${message}
    </div>
</c:if>

<form action="<c:url value='/files/upload' />" method="post" enctype="multipart/form-data">
    <label for="file">Choose file:</label>
    <input type="file" id="file" name="file" required/>
    <button type="submit">Upload</button>
</form>

</body>
</html>
