package controllers.admin;

import DomainModel.ChiTietSP;
import DomainModel.MauSac;
import DomainModel.NhanVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import org.apache.commons.beanutils.BeanUtils;
import repository.ChiTietSPRepository;
import repository.MauSacRepository;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

@WebServlet({
        "/mau-sac/index",
        "/mau-sac/create",
        "/mau-sac/store",
        "/mau-sac/edit",
        "/mau-sac/update",
        "/mau-sac/delete",
})
public class MauSacServlet extends HttpServlet {
    private MauSacRepository msRepo;
    private ChiTietSPRepository ctspRepo;
    public MauSacServlet(){
        this.msRepo=new MauSacRepository();
        this.ctspRepo=new ChiTietSPRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    private void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("ds",msRepo.findAll());
        request.setAttribute("view","/views/MauSac/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request,response);

    }

    private void edit( HttpServletRequest request,
                       HttpServletResponse response
    ) throws ServletException, IOException {
        UUID id_ms = UUID.fromString(request.getParameter("id"));
        MauSac ms = this.msRepo.findById(id_ms);
        request.setAttribute("qlms",ms);
        request.setAttribute("view","/views/MauSac/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request,response);
    }

    private void delete(HttpServletRequest request,
                        HttpServletResponse response
    ) throws ServletException, IOException {
        UUID id_ms = UUID.fromString(request.getParameter("id"));
        MauSac ms = this.msRepo.findById(id_ms);
        List<ChiTietSP> nv = this.ctspRepo.findByIdMS(ms.getId());
        HttpSession session = request.getSession();
        if(nv.size()!=0){
            session.setAttribute("error4","Không thể xoá do ràng buộc khoá ngoại");

        }else{
            this.msRepo.delete(ms);
            session.setAttribute("error4","");
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/mau-sac/index");
    }

    private void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("ds", msRepo.findAll());
        request.setAttribute("view", "/views/MauSac/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

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
            response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/mau-sac/index");
        }
    }

    private void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        MauSac ms = new MauSac();
        try {
            BeanUtils.populate(ms,request.getParameterMap());
            this.msRepo.insert(ms);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/mau-sac/index");
    }

    private void update( HttpServletRequest request,
                         HttpServletResponse response
    ) throws ServletException, IOException {
        UUID id_ms = UUID.fromString(request.getParameter("id_ms"));
        MauSac ms = this.msRepo.findById(id_ms);
        try {
            BeanUtils.populate(ms,request.getParameterMap());
            this.msRepo.update(ms);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/mau-sac/index");
    }

}
