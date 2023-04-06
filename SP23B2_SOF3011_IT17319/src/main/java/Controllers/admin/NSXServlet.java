package controllers.admin;

import DomainModel.ChiTietSP;
import DomainModel.DongSP;
import DomainModel.NhaSX;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import org.apache.commons.beanutils.BeanUtils;
import repository.ChiTietSPRepository;
import repository.NSXRepository;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

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
    private ChiTietSPRepository ctspRepo;

    public NSXServlet(){
        this.nsxRepo=new NSXRepository();
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
        request.setAttribute("view","/views/NSX/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }
    private void edit(HttpServletRequest request,
                      HttpServletResponse response
    ) throws ServletException, IOException {
        UUID id_ns= UUID.fromString(request.getParameter("id"));
        NhaSX nsx = this.nsxRepo.findById(id_ns);
        request.setAttribute("qlnsx", nsx);
        request.setAttribute("view","/views/NSX/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }
    private void delete(HttpServletRequest request,
                        HttpServletResponse response
    ) throws ServletException, IOException {
        UUID id_nsx= UUID.fromString(request.getParameter("id"));
        NhaSX nsx = this.nsxRepo.findById(id_nsx);
        List<ChiTietSP> nv = this.ctspRepo.findByIdNSX(nsx.getId());
        HttpSession session = request.getSession();
        if(nv.size()!=0){
            session.setAttribute("error","Không thể xoá do ràng buộc khoá ngoại");
        }else{
            this.nsxRepo.delete(nsx);
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/nsx/index");
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

    private void store(HttpServletRequest request,
                       HttpServletResponse response
    ) throws ServletException, IOException {
        NhaSX nsx = new NhaSX();
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

    private void update(HttpServletRequest request,
                        HttpServletResponse response
    ) throws ServletException, IOException{
        UUID id_nsx= UUID.fromString(request.getParameter("id_nsx"));
        NhaSX nsx = this.nsxRepo.findById(id_nsx);
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
}
