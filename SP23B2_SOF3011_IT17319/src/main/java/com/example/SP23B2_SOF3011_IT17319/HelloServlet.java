package com.example.SP23B2_SOF3011_IT17319;
import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet({
        "/hello-servlet","/hello2","/hello3"
})
public class HelloServlet extends HttpServlet {
    private String message;
    public void init() { message = "Hello World!"; }

    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String name = "Ngalt";
        request.setAttribute("hoTen", name);
        request.getRequestDispatcher("/views/login.jsp")
                .forward(request, response);
    }

    public void destroy() {
    }
}
