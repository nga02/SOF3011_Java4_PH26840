package Controllers.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import Repository.KhachHangRepository;
import View_models.QLKhachHang;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({
        "/khach-hang/index",    // GET
        "/khach-hang/create",   // GET
        "/khach-hang/store",    // POST
        "/khach-hang/edit",     // GET
        "/khach-hang/update",   // POST
        "/khach-hang/delete",   // GET

})

public class KhachHangServlet extends HttpServlet {
    private KhachHangRepository khRepo;
    public KhachHangServlet() {
        this.khRepo = new KhachHangRepository();
            this.khRepo.insert(new QLKhachHang("KH01", "Nga", "Thị", "Lê", "2003-04-03", "0335188503", "Cầu Giấy", "01234", "Việt Nam", "Hà Nội"));
            this.khRepo.insert(new QLKhachHang("KH02", "Nam", "Văn", "Hoàng", "2003-04-03", "0335188246", "Thanh Xuân", "1235", "Thái Lan", "Hồ Chí Minh"));
            this.khRepo.insert(new QLKhachHang("KH03", "Thành", "Văn", "Hoàng","2003-04-03", "0335188246", "Thanh Xuân", "1235", "Thái Lan", "Đà Nẵng"));
            this.khRepo.insert(new QLKhachHang("KH04", "Trang", "Văn", "Hoàng", "2003-04-03", "0335188246", "Thanh Xuân", "1235", "Thái Lan", "Hà Nội"));
            this.khRepo.insert(new QLKhachHang("KH05", "Nam", "Văn", "Hoàng", "2003-04-03", "0335188246", "Thanh Xuân", "1235", "Thái Lan", "Hồ Chí Minh"));

        }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("create") == true) {
            this.create(request, response);
        } else if (uri.contains("edit") == true) {
            this.edit(request, response);
        } else if (uri.contains("delete") == true) {
            this.delete(request, response);
        }
        else {
            this.index(request, response);
        }
    }

//    private void hienThiDS(HttpServletRequest request, HttpServletResponse response) {
//    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String uri =  request.getRequestURI();
        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else {
            response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/khach-hang/index");
        }
    }

    private void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("ds", this.khRepo.findAll());
        request.setAttribute("view", "/views/KhachHang/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }
    //----------------------------------------------
    private void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view", "/views/KhachHang/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }
    private void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException{
        QLKhachHang kh = new QLKhachHang();
        try {
            BeanUtils.populate(kh, request.getParameterMap());
            this.khRepo.insert(kh);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/khach-hang/index");
    }
    //----------------------------------------------
    private void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLKhachHang vm = this.khRepo.findByMa(ma);
        request.setAttribute("qlkh", vm);
        request.setAttribute("view", "/views/KhachHang/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }
    private void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        QLKhachHang kh = new QLKhachHang();
        try {
            BeanUtils.populate(kh, request.getParameterMap());
            this.khRepo.update(kh);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/khach-hang/index");
    }


    private void delete(HttpServletRequest request,
                       HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLKhachHang vm = khRepo.findByMa(ma);
        this.khRepo.delete(vm);
        //Điều hướng request về index
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/khach-hang/index");
    }
}
