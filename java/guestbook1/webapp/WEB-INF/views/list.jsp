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
<table border="1">
    <thead>
    <tr>
        <th valign="middle" >번호</th>
        <th width="50" valign="middle"  >이름</th>
        <th width="500" valign="middle">내용</th>
        <th valign="middle" >삭제</th>
    </tr>
    </thead>
<c:forEach items="${requestScope.guestbookList}" var="guestbook">

        <tr>
            <td valign="middle">${guestbook.id} </td>
            <td valign="middle">${guestbook.name} </td>
            <td valign="middle">${guestbook.content}</td>
            <c:if test="${sessionScope.admin == 'true'}">
            <td valign="middle"><a href="/guestbook/delete?id=${guestbook.id}">삭제</a></td>
            </c:if>
            <c:if test="${sessionScope.admin != 'true'}">
                <td></td>
            </c:if>
        </tr>
</c:forEach>
</table>
<c:forEach items="${requestScope.page}" var="page">
<a href="http://localhost:8080/guestbook/list?pg=${page}">${page}</a>
</c:forEach>


</body>
</html>