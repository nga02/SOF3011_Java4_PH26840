package filters;

import DomainModel.KhachHang;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter({
        "/khach-hang/*",
        "/chuc-vu/*",
        "/nhan-vien/*",
        "/cua-hang/*",
        "/dong-sp/*",
        "/mau-sac/*",
        "/nsx/*",
        "/san-pham/*",
        "/chitiet-sp/*",

})
public class AuthenticationFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
    ) throws ServletException, IOException {
        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpSession session = httpReq.getSession();
        KhachHang kh = (KhachHang) session.getAttribute("kh");

        if (kh == null) {
            HttpServletResponse httpRes = (HttpServletResponse) response;
            httpRes.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/login");
        } else {
            chain.doFilter(request, response);
        }
    }
}
