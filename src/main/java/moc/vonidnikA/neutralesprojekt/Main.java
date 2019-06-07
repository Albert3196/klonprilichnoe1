package moc.vonidnikA.neutralesprojekt;

import moc.vonidnikA.neutralesprojekt.Model.Cookie;
import moc.vonidnikA.neutralesprojekt.Model.Data;
import moc.vonidnikA.neutralesprojekt.Model.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //первый заход без авторизации
        if (req.getSession().getAttribute("IsAuthorization") == null)
            req.getSession().setAttribute("IsAuthorization", false);

        if ((Boolean) req.getSession().getAttribute("IsAuthorization")) {
            req.getRequestDispatcher("/jsp/index.jsp").forward(req, resp);
        }
        else {
            req.getRequestDispatcher("/jsp/authorization.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Cookie> list = new ArrayList<Cookie>();
        req.setAttribute("list", list);

        ArrayList<Order> or = new ArrayList<Order>();
        List<Long> ShopCart = new ArrayList<Long>();

        String user_login = (String) req.getSession().getAttribute("login");

        ShopCart = Data.getInstance().getOrderByLogin(user_login).getCookies();

        // если корзина пустая и не записан в сессия массив печенек, создаем новую корзину
        if (ShopCart.size()==0){
            List<Long> EmptyCart = new ArrayList<Long>();

            String name = req.getParameter("button");
            EmptyCart.add(Long.parseLong(name));
            req.getSession().setAttribute("ArrayIdCookie",EmptyCart);
            ShopCart = EmptyCart;
        }
        // иначе добавляем в старую
        else{
            List<Long> Add2Cart = ShopCart;
            String name = req.getParameter("button");
            Add2Cart.add(Long.parseLong(name));
            req.getSession().setAttribute("ArrayIdCookie",Add2Cart);
            ShopCart = Add2Cart;
        }

        or.add(new Order(user_login, ShopCart));
        Data.getInstance().setOrders(or);
        resp.sendRedirect("/index");
    }

}
