<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- varは自分で指定できる変数名 --%>
<c:forEach var="ac" items="${sd}" varStatus="status">
名前：<c:out value="${ac.name}"/><br>
age：<c:out value="${ac.age}"/><br>
</c:forEach>

</body>
</html>