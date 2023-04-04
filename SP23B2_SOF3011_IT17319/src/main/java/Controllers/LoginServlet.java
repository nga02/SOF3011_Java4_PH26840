package controllers;

import DomainModel.KhachHang;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.KhachHangRepository;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private KhachHangRepository khRepo;

    public LoginServlet()
    {
        this.khRepo = new KhachHangRepository();
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.getRequestDispatcher("/views/login.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String matKhau = request.getParameter("matKhau");

        HttpSession session = request.getSession();
        KhachHang kh = this.khRepo.login(ma, matKhau);
        if (kh == null) {
            session.setAttribute("error_message", "Sai tài khoản/mật khẩu");
            response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/login");
        } else {
            session.setAttribute("kh", kh);
            response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/khach-hang/index");
        }
    }
}
