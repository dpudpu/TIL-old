<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<br>

<c:forEach items="${boards}" var="board">
    ${board.title}<br>
</c:forEach>
<br>

<a href="/boards/writeform">±€¿€º∫</a>

</body>
</html>
