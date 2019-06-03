package moc.vonidnikA.neutralesprojekt;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class Main extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("IsAuthorization") == null)
            req.getSession().setAttribute("IsAuthorization", false);


        if ((Boolean) req.getSession().getAttribute("IsAuthorization"))
            req.getRequestDispatcher("/jsp/index.jsp").forward(req, resp);
        else
            req.getRequestDispatcher("/jsp/authorization.jsp").forward(req, resp);
    }
}
