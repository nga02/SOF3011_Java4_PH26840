package Controllers.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import Repository.ChiTietSPRepository;
import View_models.QLCTSP;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({
        "/chitiet-sp/index",
        "/chitiet-sp/create",
        "/chitiet-sp/store",
        "/chitiet-sp/edit",
        "/chitiet-sp/update",
        "/chitiet-sp/delete",
})
public class ChiTietSPServlet extends HttpServlet {
    private ChiTietSPRepository ctspRepo;

    public ChiTietSPServlet() {
        this.ctspRepo = new ChiTietSPRepository();
        this.ctspRepo.insert(new QLCTSP("bfuyrgf8yrgt8","Sữa rửa mặt","Maybelline","Orange","Biore",2022,"Nhập khẩu từ Pháp",10,500,550));
        this.ctspRepo.insert(new QLCTSP("jjhjhjjt43c","Nước tẩy trang","Shu Uemura","Blue","Obagi Medical",2023,"Nhập khẩu từ Nhật",25,600,650));
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
        if (uri.contains("store") == true) {
            this.store(request, response);
        } else if (uri.contains("update") == true) {
            this.update(request, response);
        } else {
            response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/chitiet-sp/index");
        }
    }

    private void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("ds", this.ctspRepo.findAll());
        request.setAttribute("view", "/views/ChiTietSP/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    private void create(HttpServletRequest request,
                        HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view", "/views/ChiTietSP/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    private void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        QLCTSP spct = new QLCTSP();
        try {
            BeanUtils.populate(spct, request.getParameterMap());
            this.ctspRepo.insert(spct);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/chitiet-sp/index");
    }

    private void edit(HttpServletRequest request,
                      HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("idsp");
        QLCTSP vm = this.ctspRepo.findById(ma);
        request.setAttribute("ctsp", vm);
        request.setAttribute("view", "/views/ChiTietSP/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    private void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        QLCTSP vm = new QLCTSP();
        try {
            BeanUtils.populate(vm, request.getParameterMap());
            this.ctspRepo.update(vm);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/chitiet-sp/index");
    }

    private void delete(HttpServletRequest request,
                        HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("idsp");
        QLCTSP vm = ctspRepo.findById(ma);
        this.ctspRepo.delete(vm);
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/chitiet-sp/index");
    }

}
