<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="moc.vonidnikA.neutralesprojekt.Model.* "%>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<html>
    <meta charset="utf-8" />
    <link href="styles/main.css" rel="stylesheet">
    <body>
    <body>
        <%! private int ig = 0;%>
        <%! private int g = 0;%>

        <%! ArrayList<moc.vonidnikA.neutralesprojekt.Model.Cookie> cookiesView = new ArrayList<moc.vonidnikA.neutralesprojekt.Model.Cookie>();%>
        <%cookiesView = Data.getInstance().getCookies();%>
        <%g=cookiesView.size();%>

    <h1>Список печенек:</h1>
        <% if (request.getAttribute("list") == null) {%>
        <% request.setAttribute("list", new ArrayList());%>
        <%}%>

        <% ((List)request.getAttribute("list")).clear(); %>

        <% for (int i=1; i<=g; i++) {%>
        <% ((List)request.getAttribute("list")).add (Data.getInstance().getCookieById(i)); %>
        <%}%>

    <div class="wrapper">
        <c:forEach items="${list}" var="item">
            <% ++ig; %>
            <div class="element">
                <span><b>${item.name}</b></span>
                <span>Цена: ${item.price}</span>
                <img
                        src="${item.img}"
                        alt=""
                        class="img"
                />
                <form id=<%=ig%> name="Cookiebutton" method="post" action="/shop">
                    <input id="btn" value=<%=ig%> class="input" name="button" />
                    <button type="submit" class="button">Купить</button>
                </form>
            </div>
        </c:forEach>
    </div>

        <%((List)request.getAttribute("list")).clear(); %>
        <% ig=0; %>
    </div>