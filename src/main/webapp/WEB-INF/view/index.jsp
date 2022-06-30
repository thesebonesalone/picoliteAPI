<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
        <title>Pico Lite</title>

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="<c:url value="../../resources/style.css" />" type="text/css">
</head>
<body>
    <h1>Welcome to PicoLite!</h1>
    <h2>Your one stop shop for like, three things about Pico 8</h2>
    <c:forEach items="${Articles.articles}" var="article" varStatus="tagStatus">
        <tr>
            <td><a href="http://localhost:8080/picolitemvc/article/${article.id}">${article.title}</a></td>
        </tr>
    </c:forEach>
</body>
</html>