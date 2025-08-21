<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Uploaded Files List</title>
</head>
<body>

<a href="<c:url value='/files/upload' />">Upload New File</a>
<br/><br/>

<h2>Uploaded Files</h2>

<c:choose>
    <c:when test="${empty files}">
        <p>No files uploaded yet.</p>
    </c:when>
    <c:otherwise>
        <table border="1" cellpadding="6" cellspacing="0">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Original Filename</th>
                    <th>Stored Path</th>
                    <th>File Type</th>
                    <th>File Size (bytes)</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="file" items="${files}">
                    <tr>
                        <td>${file.id}</td>
                        <td>${file.originalFileName}</td>
                        <td>${file.storedFilePath}</td>
                        <td>${file.fileType}</td>
                        <td>${file.fileSize}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>

</body>
</html>
