package Controllers.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

import org.apache.commons.beanutils.BeanUtils;
import Repository.DongSPRepository;
import View_models.QLDongSP;

import java.lang.reflect.InvocationTargetException;

@WebServlet({
        "/dong-sp/index",
        "/dong-sp/create",
        "/dong-sp/store",
        "/dong-sp/edit",
        "/dong-sp/update",
        "/dong-sp/delete",})
public class DongSPServlet extends HttpServlet {
    private DongSPRepository dongSPRepo;
    public DongSPServlet(){
        this.dongSPRepo=new DongSPRepository();
        this.dongSPRepo.insert(new QLDongSP("D01", "Gucci"));
        this.dongSPRepo.insert(new QLDongSP("D02", "Chanel"));
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
        } else {
            this.index(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")) {
            this.store(request, response);
        }else if(uri.contains("update")){
            this.update(request,response);
        }else{
            response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/dong-sp/index");
        }
    }

    private void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("ds", dongSPRepo.findAll());
        request.setAttribute("view", "/views/DongSP/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);

    }
    private void create(HttpServletRequest request,
                        HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view","/views/DongSP/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    private void store(HttpServletRequest request,
                      HttpServletResponse response
    ) throws ServletException, IOException {
        QLDongSP sp = new QLDongSP();
        try {
            BeanUtils.populate(sp,request.getParameterMap());
            this.dongSPRepo.insert(sp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/dong-sp/index");
    }

    private void edit(HttpServletRequest request,
                      HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLDongSP vm = dongSPRepo.findByMa(ma);
        request.setAttribute("qldsp", vm);
        request.setAttribute("view","/views/DongSP/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }
    private void update(HttpServletRequest request,
                        HttpServletResponse response
    ) throws ServletException, IOException{
        QLDongSP sp = new QLDongSP();
        try {
            BeanUtils.populate(sp,request.getParameterMap());
            this.dongSPRepo.update(sp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/dong-sp/index");
    }

    private void delete(HttpServletRequest request,
                     HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLDongSP vm = dongSPRepo.findByMa(ma);
        this.dongSPRepo.delete(vm);
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/dong-sp/index");
    }

}
