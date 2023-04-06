package controllers.admin;

import DomainModel.ChucVu;
import DomainModel.CuaHang;
import DomainModel.NhanVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

import org.apache.commons.beanutils.BeanUtils;
import repository.CuaHangRepository;
import repository.NhanVienRepository;
import view_models.QLCuaHang;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

@WebServlet({
        "/cua-hang/index", // GET
        "/cua-hang/create", // GET
        "/cua-hang/store", // POST
        "/cua-hang/edit", // GET
        "/cua-hang/update", // POST
        "/cua-hang/delete", // GET
})
public class CuaHangServlet extends HttpServlet {
    private CuaHangRepository chRepo;
    private NhanVienRepository nvRepo;

    public CuaHangServlet() {
        this.chRepo = new CuaHangRepository();
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
        }else if(uri.contains("edit")==true){
            this.edit(request,response);
        }
        else if (uri.contains("delete") == true) {
            this.delete(request, response);
        }
        else {
            this.index(request, response);
        }
    }

    private void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view","/views/CuaHang/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    private void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        UUID id_CH = UUID.fromString(request.getParameter("id"));
        CuaHang ch = this.chRepo.findById(id_CH);
        request.setAttribute("qlch", ch);
        request.setAttribute("view","/views/CuaHang/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    private void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        UUID id_CH = UUID.fromString(request.getParameter("id"));
        CuaHang ch = this.chRepo.findById(id_CH);
        List<NhanVien> nv = this.nvRepo.findByIdCH(ch.getId());
       HttpSession session = request.getSession();
        if (nv.size() != 0) {
            session.setAttribute("error2", "Không thể xoá do ràng buộc khoá ngoại");
        } else {
            this.chRepo.delete(ch);
            session.setAttribute("error2", "");
        }
        this.chRepo.delete(ch);
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/cua-hang/index");
    }

        private void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("ds", chRepo.findAll());
        request.setAttribute("view", "/views/CuaHang/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("store")){
            this.store(request,response);
        }else if(uri.contains("update")){
            this.update(request,response);
        }else{
            response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/cua-hang/index");
        }
    }

    private void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        CuaHang ch = new CuaHang();
        try {

            BeanUtils.populate(ch,request.getParameterMap());
            this.chRepo.insert(ch);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/cua-hang/index");
    }



    private void update(HttpServletRequest request,
                        HttpServletResponse response
    ) throws ServletException, IOException{
        UUID id_CH = UUID.fromString(request.getParameter("id_ch"));
        CuaHang ch = this.chRepo.findById(id_CH);
        try {
            BeanUtils.populate(ch,request.getParameterMap());
            this.chRepo.update(ch);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/cua-hang/index");
    }

}
