package Controllers.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import org.apache.commons.beanutils.BeanUtils;
import Repository.SanPhamRepository;
import View_models.QLSanPham;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

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
    public SanPhamServlet(){
        this.spRepo = new SanPhamRepository();
        spRepo.insert(new QLSanPham("SP01","Kem chống nắng"));
        spRepo.insert(new QLSanPham("SP02","Sữa rửa mặt"));
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
    private void index(
            HttpServletRequest request,
            HttpServletResponse response
    )throws ServletException, IOException {
        request.setAttribute("ds",spRepo.findAll());
        request.setAttribute("view", "/views/SanPham/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    private void create(HttpServletRequest request,
                       HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view","/views/SanPham/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }
    private void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
       QLSanPham s = new QLSanPham();
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

    private void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLSanPham vm = spRepo.findByMa(ma);
        request.setAttribute("qlsp", vm);
        request.setAttribute("view","/views/SanPham/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    private void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        QLSanPham kh = new QLSanPham();
        try {
            BeanUtils.populate(kh, request.getParameterMap());
            this.spRepo.update(kh);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/san-pham/index");
    }

    private void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLSanPham vm = spRepo.findByMa(ma);
        this.spRepo.delete(vm);
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/san-pham/index");
    }
}
