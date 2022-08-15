<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: eugen
  Date: 15.08.2022
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Artists</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <jsp:useBean id="ab" class="ua.mk.berkut.p1508.beans.ArtistBean" scope="request"/>
    <form action="artists" method="post">
        <label for="artist">Новый исполнитель</label>
        <input id="artist" type="text" name="artistname">
        <input type="submit" value="Add">
    </form>
    <table>
        <thead>
        <tr>
            <th>#</th>
            <th>Artist</th>
            <th>delete</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${ab.artists}" var="a">
                <tr>
                    <td>${a.id}</td>
                    <td>${a.name}</td>
                    <td><a href="deleteartist?id=${a.id}">delete</a> </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
