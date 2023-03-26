package Controllers.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import org.apache.commons.beanutils.BeanUtils;
import Repository.NSXRepository;
import View_models.QLNSX;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({
        "/nsx/index",
        "/nsx/create",
        "/nsx/store",
        "/nsx/edit",
        "/nsx/update",
        "/nsx/delete",
})
public class NSXServlet extends HttpServlet {
    private NSXRepository nsxRepo;
    public NSXServlet(){
        this.nsxRepo=new NSXRepository();
        nsxRepo.insert(new QLNSX("NSX01","NSX Đại học quốc gia HÀ NỘI"));
        nsxRepo.insert(new QLNSX("NSX02","NSX Đại học Bách Khoa"));
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
            response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/nsx/index");
        }
    }
    private void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("ds", nsxRepo.findAll());
        request.setAttribute("view", "/views/NSX/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }
    private void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view","/views/NSX/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }
    private void store(HttpServletRequest request,
                       HttpServletResponse response
    ) throws ServletException, IOException {
        QLNSX nsx = new QLNSX();
        try {
            BeanUtils.populate(nsx,request.getParameterMap());
            this.nsxRepo.insert(nsx);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/nsx/index");
    }
    private void edit(HttpServletRequest request,
                      HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLNSX vm = this.nsxRepo.findByMa(ma);
        request.setAttribute("qlnsx", vm);
        request.setAttribute("view","/views/NSX/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }
    private void update(HttpServletRequest request,
                        HttpServletResponse response
    ) throws ServletException, IOException{
        QLNSX nsx = new  QLNSX();
        try {
            BeanUtils.populate(nsx,request.getParameterMap());
            this.nsxRepo.update(nsx);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/nsx/index");
    }

    private void delete(HttpServletRequest request,
                        HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLNSX vm = nsxRepo.findByMa(ma);
        this.nsxRepo.delete(vm);
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/nsx/index");
    }
}
