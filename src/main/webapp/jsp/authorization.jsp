<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<meta charset="utf-8" />
<link rel="stylesheet" href="<c:url value="/styles/main.css"/>">
<body>

АВТОРИЗАЦИЯ:

<form method="get" action="/authorization">
    <table>
        <tr>
            <td><label for="loginField">Логин</label></td>
            <td><input id="loginField" type="text" name="login"></td>
        </tr>
        <tr>
            <td><label for="passwordField">Пароль</label></td>
            <td><input id="passwordField" type="password" name="password"></td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center"><input type="submit" value="Войти"></td>
        </tr>
    </table>
</form>