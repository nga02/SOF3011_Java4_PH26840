package controllers.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repository.NhanVienRepository;
import View_models.QLNhanVien;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


@WebServlet({
        "/nhan-vien/index",
        "/nhan-vien/create",
        "/nhan-vien/store",
        "/nhan-vien/edit",
        "/nhan-vien/update",
        "/nhan-vien/delete",
})
public class NhanVienServlet extends HttpServlet {
    private NhanVienRepository nvRepo;

    public NhanVienServlet() {
        this.nvRepo = new NhanVienRepository();
        this.nvRepo.insert(new QLNhanVien("NV01", "Nga", "Thị", "Lê", "Nữ", "2003-04-20", "Bắc Từ Liêm", "0335188503", "123", "Cửa hàng 1", "Trưởng phòng", 1));
        this.nvRepo.insert(new QLNhanVien("NV02", "A", "Văn", "Nguyễn", "Nam","2003-04-20", "Bắc Từ Liêm", "0335188503", "123", "Cửa hàng 2", "Quản lý", 0));
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("create") == true) {
            this.create(request, response);
        } else if (uri.contains("edit") == true) {
            this.edit(request, response);
        } else if (uri.contains("delete") == true) {
            this.delete(request, response);
        } else {
            this.index(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else {
            response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/nhan-vien/index");
        }
    }

    private void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("ds", this.nvRepo.findAll());
        request.setAttribute("view", "/views/NhanVien/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    private void create(HttpServletRequest request,
                        HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view", "/views/NhanVien/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    private void store(HttpServletRequest request
            , HttpServletResponse response
    ) throws ServletException, IOException {
        QLNhanVien nv = new QLNhanVien();
        try {

            BeanUtils.populate(nv, request.getParameterMap());
            this.nvRepo.insert(nv);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/nhan-vien/index");
    }

    private void edit(HttpServletRequest request,
                      HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLNhanVien vm = this.nvRepo.findByMa(ma);
        request.setAttribute("qlnv", vm);
        request.setAttribute("view", "/views/NhanVien/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    private void update(HttpServletRequest request,
                        HttpServletResponse response
    ) throws ServletException, IOException {
        QLNhanVien nv = new QLNhanVien();
        try {
            BeanUtils.populate(nv, request.getParameterMap());
            this.nvRepo.update(nv);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/nhan-vien/index");
    }

    private void delete(HttpServletRequest request,
                        HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLNhanVien vm = nvRepo.findByMa(ma);
        this.nvRepo.delete(vm);
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/nhan-vien/index");
    }
}
