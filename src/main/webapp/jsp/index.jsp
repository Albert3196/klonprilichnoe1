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
        <%! private int ig = 0;%>
        <%! private int g = 0;%>
        <%! private double sum = 0.0;%>
        <%! private List<Long> CookieOrd;%>

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
                <form id=<%=ig%> name="Cookiebutton" method="post" action="/index">
                    <input id="btn" value=<%=ig%> class="input" name="button" />
                    <button type="submit" class="button">Купить</button>
                </form>
            </div>
        </c:forEach>
    </div>

        <%((List)request.getAttribute("list")).clear(); %>
        <% ig=0; %>
    </div>

        <% String id = (String) request.getSession().getAttribute("login"); %>

        <%  CookieOrd = Data.getInstance().getOrderByLogin(id).getCookies(); %>

        <% if ( CookieOrd.size() != 0) {%>
            <h1>Корзина (<%= CookieOrd.size()%>):</h1>
        <%}%>

        <div class="wrapper">

            <% sum=0.0; %>
            <%for (int j=0; j< CookieOrd.size(); j++){ %>
            <% sum = sum + Data.getInstance().getCookieById(CookieOrd.get(j)).getPrice(); %>
            <div class="element">
                    <span><b>
                        <%=Data.getInstance().getCookieById(CookieOrd.get(j)).getName()%>
                    </b></span>
                <span>
                        Цена: <%=Data.getInstance().getCookieById(CookieOrd.get(j)).getPrice()%>
                    </span>
                <img
                        src="<%=Data.getInstance().getCookieById(CookieOrd.get(j)).getImg()%>"
                        alt=""
                        class="img"
                />
            </div>
            <% } %>
        </div>

            <% if (CookieOrd.size() != 0) {%>
        <h1>Сумма: <%=sum%></h1>
            <%}%>
            <%-- } --%>

    </body>
</html>
