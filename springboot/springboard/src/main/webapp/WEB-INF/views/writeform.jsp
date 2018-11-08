
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>글작성</title>
</head>
<body>
<h1>글작성</h1>
<form method="post" action="/boards" enctype="multipart/form-data">
    name : <input type="text" name="name"><br>
    title : <input type="text" name="title"><br>
    content : <textarea name="content" cols="50" rows="6"></textarea><br>
    <input type="file" name="file"/>
    <br>
    <input type="submit">
</form>
</body>
</html>
