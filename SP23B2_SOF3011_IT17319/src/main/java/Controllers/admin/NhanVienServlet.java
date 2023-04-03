package controllers.admin;

import DomainModel.ChiTietSP;
import DomainModel.ChucVu;
import DomainModel.CuaHang;
import DomainModel.NhanVien;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repository.ChucVuRepository;
import repository.CuaHangRepository;
import repository.NhanVienRepository;
import view_models.QLNhanVien;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;


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
    private CuaHangRepository chRepo;
    private ChucVuRepository cvRepo;

    public NhanVienServlet() {
        this.nvRepo = new NhanVienRepository();
        this.chRepo = new CuaHangRepository();
        this.cvRepo = new ChucVuRepository();
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

    private void create(HttpServletRequest request,
                        HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("lstCH", this.chRepo.findAll());
        request.setAttribute("lstCV", this.cvRepo.findAll());
        request.setAttribute("view", "/views/NhanVien/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }
    private void edit(HttpServletRequest request,
                      HttpServletResponse response
    ) throws ServletException, IOException {
        UUID id = UUID.fromString(request.getParameter("id"));
        NhanVien nv = this.nvRepo.findById(id);
        request.setAttribute("qlnv", nv);
        request.setAttribute("lstCH", this.chRepo.findAll());
        request.setAttribute("lstCV", this.cvRepo.findAll());
        request.setAttribute("view", "/views/NhanVien/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request,
                        HttpServletResponse response
    ) throws ServletException, IOException {
        UUID id = UUID.fromString(request.getParameter("id"));
        NhanVien nv = this.nvRepo.findById(id);
        this.nvRepo.delete(nv);
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/nhan-vien/index");
    }

    private void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("ds", this.nvRepo.findAll());
        request.setAttribute("lstCH", this.chRepo.findAll());
        request.setAttribute("lstCV", this.cvRepo.findAll());
        request.setAttribute("view", "/views/NhanVien/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
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

    private void store(HttpServletRequest request
            , HttpServletResponse response
    ) throws ServletException, IOException {
        NhanVien nv = new NhanVien();
        ChucVu cv = this.cvRepo.findById(UUID.fromString(request.getParameter("id_cv")));
        CuaHang ch= this.chRepo.findById(UUID.fromString(request.getParameter("id_ch")));
        try {
            BeanUtils.populate(nv, request.getParameterMap());
            nv.setIdCV(cv);
            nv.setIdCH(ch);
            this.nvRepo.insert(nv);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/nhan-vien/index");
    }

    private void update(HttpServletRequest request,
                        HttpServletResponse response
    ) throws ServletException, IOException {
        UUID id = UUID.fromString(request.getParameter("id_nv"));
        NhanVien nv = this.nvRepo.findById(id);
        ChucVu cv = this.cvRepo.findById(UUID.fromString(request.getParameter("id_cv")));
        CuaHang ch= this.chRepo.findById(UUID.fromString(request.getParameter("id_ch")));
        try {
            BeanUtils.populate(nv, request.getParameterMap());
            nv.setIdCV(cv);
            nv.setIdCH(ch);
            this.nvRepo.update(nv);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/nhan-vien/index");
    }
}
