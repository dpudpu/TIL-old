<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>list</h1>
<c:if test="${sessionScope.admin != 'true'}">
    <a href="/guestbook/login">관리자 로그인</a>
</c:if>
<c:if test="${sessionScope.admin == 'true'}">
    <a href="/guestbook/logout">관리자 로그아웃</a>
</c:if>
<br><br>

방명록 건수 : ${requestScope.guestbookSize}<br>

<form method="post" action="/guestbook/write">
    이름 : <input type="text" name="name"><br>
    내용 : <br>
    <textarea name="content" id="content" cols="30" rows="10"></textarea>
    <input type="submit">
</form>

<!-- 방명록 목록을 출력한다. -->
<c:forEach items="${requestScope.guestbookList}" var="guestbook">
    이름 : ${guestbook.name} <br>
    내용 : ${guestbook.content} <br>
    <c:if test="${sessionScope.admin == 'true'}">
        <a href="/guestbook/delete?id=${guestbook.id}">삭제</a><br><br>
    </c:if>
</c:forEach>


</body>
</html>