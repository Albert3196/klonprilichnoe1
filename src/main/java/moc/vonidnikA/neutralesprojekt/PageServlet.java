package moc.vonidnikA.neutralesprojekt;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class PageServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getAttribute("list") == null)
            req.setAttribute("list", new ArrayList());
        req.getRequestDispatcher("/jsp/index.jsp").forward(req, resp);

    }
}
