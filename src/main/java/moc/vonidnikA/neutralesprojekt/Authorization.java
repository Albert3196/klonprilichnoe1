package moc.vonidnikA.neutralesprojekt;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Authorization extends HttpServlet {

    static Map<String,String> users = new HashMap<String, String>();

    {
        users.put("admin","admin");
        users.put("albertik","1");
        users.put("buzma","2");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String loginField = req.getParameter("login");
        String passwordField = req.getParameter("password");

        try {
            if (users.get(loginField).equals(passwordField)) {
                req.getSession().setAttribute("IsAuthorization", true);
                req.getSession().setAttribute("login", loginField);
            }

        } catch (NullPointerException e) {
            System.out.println("login not found");
        }

        resp.sendRedirect("/index");
    }
}