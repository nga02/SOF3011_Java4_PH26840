package controllers.admin;

import DomainModel.ChiTietSP;
import DomainModel.NhaSX;
import DomainModel.SanPham;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import org.apache.commons.beanutils.BeanUtils;
import repository.ChiTietSPRepository;
import repository.SanPhamRepository;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

@WebServlet({
        "/san-pham/index",
        "/san-pham/create",
        "/san-pham/store",
        "/san-pham/edit",
        "/san-pham/update",
        "/san-pham/delete",
})
public class SanPhamServlet extends HttpServlet {
    private SanPhamRepository spRepo;
    private ChiTietSPRepository ctspRepo;
    public SanPhamServlet(){
        this.spRepo = new SanPhamRepository();
        this.ctspRepo=new ChiTietSPRepository();
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
        }
        else if (uri.contains("delete") == true) {
            this.delete(request, response);
        } else {
            this.index(request, response);
        }
    }

    private void create(HttpServletRequest request,
                        HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view","/views/SanPham/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    private void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        UUID id_nsp= UUID.fromString(request.getParameter("id"));
        SanPham sp = this.spRepo.findById(id_nsp);
        request.setAttribute("qlsp", sp);
        request.setAttribute("view","/views/SanPham/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    private void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        UUID id_nsx= UUID.fromString(request.getParameter("id"));
        SanPham sp = this.spRepo.findById(id_nsx);
        List<ChiTietSP> nv = this.ctspRepo.findByIdSP(sp.getId());
        HttpSession session = request.getSession();
        if(nv.size()!=0){
            session.setAttribute("error1","Không thể xoá do ràng buộc khoá ngoại");
        }else{
            this.spRepo.delete(sp);
            session.setAttribute("error1","");
        }

        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/san-pham/index");
    }

    private void index(
            HttpServletRequest request,
            HttpServletResponse response
    )throws ServletException, IOException {
        request.setAttribute("ds",spRepo.findAll());
        request.setAttribute("view", "/views/SanPham/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")) {
            this.store(request, response);
        }else if(uri.contains("update")){
            this.update(request,response);
        }else{
            response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/san-pham/index");
        }
    }


    private void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
      SanPham s = new SanPham();
        try {
            BeanUtils.populate(s,request.getParameterMap());
            this.spRepo.insert(s);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/san-pham/index");
    }



    private void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        UUID id_sp1= UUID.fromString(request.getParameter("id_sp"));
        SanPham sp = this.spRepo.findById(id_sp1);
        try {
            BeanUtils.populate(sp, request.getParameterMap());
            this.spRepo.update(sp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/san-pham/index");
    }
}
