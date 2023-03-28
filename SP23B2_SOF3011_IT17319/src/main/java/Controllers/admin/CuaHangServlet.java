package controllers.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

import org.apache.commons.beanutils.BeanUtils;
import repository.CuaHangRepository;
import View_models.QLCuaHang;

import java.lang.reflect.InvocationTargetException;

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

    public CuaHangServlet() {
        this.chRepo = new CuaHangRepository();
        chRepo.insert(new QLCuaHang("CH01", "Cửa hàng 1", "Cầu Diễn", "Hà Nội", "Việt Nam"));
        chRepo.insert(new QLCuaHang("CH02", "Cửa hàng 2", "Cầu Diễn", "Đà Nẵng", "Thái Lan"));

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
        else if(uri.contains("delete")==true){
            this.delete(request,response);
        }
        else {
            this.index(request, response);
        }
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

    private void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("ds", chRepo.findAll());
        request.setAttribute("view", "/views/CuaHang/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    private void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view","/views/CuaHang/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }
    private void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        QLCuaHang ch = new QLCuaHang();
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

    private void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLCuaHang vm = chRepo.findByMa(ma);
        request.setAttribute("qlch", vm);
        request.setAttribute("view","/views/CuaHang/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    private void update(HttpServletRequest request,
                        HttpServletResponse response
    ) throws ServletException, IOException{
        QLCuaHang ch = new QLCuaHang();
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
    private void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLCuaHang vm = chRepo.findByMa(ma);
        this.chRepo.delete(vm);
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/cua-hang/index");
    }
}
