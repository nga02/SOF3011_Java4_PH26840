package controllers.admin;

import DomainModel.ChiTietSP;
import DomainModel.ChucVu;
import DomainModel.DongSP;
import DomainModel.SanPham;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

import org.apache.commons.beanutils.BeanUtils;
import repository.ChiTietSPRepository;
import repository.DongSPRepository;
import view_models.QLDongSP;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

@WebServlet({
        "/dong-sp/index",
        "/dong-sp/create",
        "/dong-sp/store",
        "/dong-sp/edit",
        "/dong-sp/update",
        "/dong-sp/delete",})
public class DongSPServlet extends HttpServlet {
    private DongSPRepository dongSPRepo;
    private ChiTietSPRepository ctspRepo;

    public DongSPServlet() {
        this.dongSPRepo = new DongSPRepository();
        this.ctspRepo=new ChiTietSPRepository();
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


    private void create(HttpServletRequest request,
                        HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view", "/views/DongSP/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    private void edit(HttpServletRequest request,
                      HttpServletResponse response
    ) throws ServletException, IOException {
        UUID id_DSP = UUID.fromString(request.getParameter("id"));
        DongSP dsp = this.dongSPRepo.findById(id_DSP);
        request.setAttribute("qldsp", dsp);
        request.setAttribute("view", "/views/DongSP/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    private void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        UUID id_DSP = UUID.fromString(request.getParameter("id"));
        DongSP dsp = this.dongSPRepo.findById(id_DSP);
        List<ChiTietSP> nv = this.ctspRepo.findByIdSP(dsp.getId());
        HttpSession session = request.getSession();
        if(nv.size()!=0){
            session.setAttribute("error31","Không thể xoá do ràng buộc khoá ngoại");
        }else{
            this.dongSPRepo.delete(dsp);
            session.setAttribute("error31","");
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/dong-sp/index");
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else {
            response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/dong-sp/index");
        }
    }



    private void store(HttpServletRequest request,
                       HttpServletResponse response
    ) throws ServletException, IOException {
        DongSP dsp = new DongSP();
        try {
            BeanUtils.populate(dsp, request.getParameterMap());
            this.dongSPRepo.insert(dsp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/dong-sp/index");
    }



    private void update(HttpServletRequest request,
                        HttpServletResponse response
    ) throws ServletException, IOException {
        UUID id_DSP = UUID.fromString(request.getParameter("id_DSP"));
        DongSP dsp = this.dongSPRepo.findById(id_DSP);
        try {
            BeanUtils.populate(dsp, request.getParameterMap());
            this.dongSPRepo.update(dsp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/dong-sp/index");
    }
}
