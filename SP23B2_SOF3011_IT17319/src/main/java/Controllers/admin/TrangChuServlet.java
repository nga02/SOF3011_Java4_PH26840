package controllers.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "TrangChuServlet", value = "/admin")
public class TrangChuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("view","/views/trangchu.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request,response);
    }
}
