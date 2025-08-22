<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>File Upload</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 400px;
            margin: 40px auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 6px;
            background-color: #f9f9f9;
            color: #333;
        }
        a {
            text-decoration: none;
            color: #0066cc;
            font-weight: bold;
        }
        a:hover {
            text-decoration: underline;
        }
        h2 {
            margin-top: 30px;
            font-size: 1.5em;
        }
        form {
            margin-top: 15px;
        }
        label {
            display: block;
            margin-bottom: 8px;
            font-weight: 600;
        }
        input[type="file"] {
            display: block;
            margin-bottom: 15px;
        }
        button {
            background-color: #0066cc;
            color: white;
            padding: 8px 14px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-weight: bold;
        }
        button:hover {
            background-color: #004999;
        }
        .message {
            margin-top: 15px;
            padding: 10px;
            border-radius: 4px;
            font-weight: 600;
        }
        .success {
            background-color: #e0f6e9;
            color: #2c662d;
            border: 1px solid #2c662d;
        }
        .error {
            background-color: #fdecea;
            color: #a94442;
            border: 1px solid #a94442;
        }
    </style>
</head>
<body>

<a href="<c:url value='/files/list' />">View Uploaded Files</a>

<h2>Upload a File</h2>

<c:if test="${not empty message}">
    <div class="message ${message.toLowerCase().contains('success') ? 'success' : 'error'}">
        ${message}
    </div>
</c:if>

<form action="<c:url value='/files/upload' />" method="post" enctype="multipart/form-data">
    <label for="file">Choose file:</label>
    <input type="file" id="file" name="file" required />
    <button type="submit">Upload</button>
</form>

</body>
</html>
