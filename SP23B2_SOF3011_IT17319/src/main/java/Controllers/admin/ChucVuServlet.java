package controllers.admin;

import DomainModel.ChucVu;
import DomainModel.NhanVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;
import repository.ChucVuRepository;
import repository.NhanVienRepository;


@WebServlet({
        "/chuc-vu/index",
        "/chuc-vu/create",
        "/chuc-vu/store",
        "/chuc-vu/edit",
        "/chuc-vu/update",
        "/chuc-vu/delete",
})
public class ChucVuServlet extends HttpServlet {
    private ChucVuRepository cvRepo;
    private NhanVienRepository nvRepo;

    public ChucVuServlet() {
        this.cvRepo = new ChucVuRepository();
        this.nvRepo = new NhanVienRepository();
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
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
        request.setAttribute("view", "/views/ChucVu/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    private void edit(HttpServletRequest request,
                      HttpServletResponse response
    ) throws ServletException, IOException {
        UUID id_CV = UUID.fromString(request.getParameter("id"));
        ChucVu cv = this.cvRepo.findById(id_CV);
        request.setAttribute("qlcv", cv);
        request.setAttribute("view", "/views/ChucVu/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);

    }

    private void delete(HttpServletRequest request,
                        HttpServletResponse response
    ) throws ServletException, IOException {
        UUID id_CV = UUID.fromString(request.getParameter("id"));
        ChucVu cv = this.cvRepo.findById(id_CV);
        List<NhanVien> nv = this.nvRepo.findByIdCV(cv.getId());
        HttpSession session = request.getSession();
        if(nv.size()!=0){
            session.setAttribute("error","Không thể xoá do ràng buộc khoá ngoại");
        }else{
            this.cvRepo.delete(cv);
            session.setAttribute("error","");
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/chuc-vu/index");

    }

    private void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("ds", cvRepo.findAll());
        request.setAttribute("view", "/views/ChucVu/index.jsp");
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
            response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/chuc-vu/index");
        }
    }


    private void store(HttpServletRequest request,
                       HttpServletResponse response
    ) throws ServletException, IOException {
        ChucVu cv = new ChucVu();
        try {
            BeanUtils.populate(cv, request.getParameterMap());
            this.cvRepo.insert(cv);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/chuc-vu/index");
    }

    private void update(HttpServletRequest request,
                        HttpServletResponse response
    ) throws ServletException, IOException {
        UUID id_CV = UUID.fromString(request.getParameter("id_cv"));
        ChucVu cv = this.cvRepo.findById(id_CV);
        try {
            BeanUtils.populate(cv, request.getParameterMap());
            this.cvRepo.update(cv);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/chuc-vu/index");
    }
}
