package Controllers.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import org.apache.commons.beanutils.BeanUtils;
import Repository.MauSacRepository;
import View_models.QLMauSac;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

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
    public MauSacServlet(){
        this.msRepo=new MauSacRepository();
      msRepo.insert(new QLMauSac("MS01", "Đỏ"));
        msRepo.insert(new QLMauSac("MS02", "Xanh"));
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
        String uri =  request.getRequestURI();
        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else {
            response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/mau-sac/index");
        }
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

    private void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("ds",msRepo.findAll());
       request.setAttribute("view","/views/MauSac/create.jsp");
       request.getRequestDispatcher("/views/layout.jsp").forward(request,response);

    }
    private void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        QLMauSac ms = new QLMauSac();
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

    private void edit( HttpServletRequest request,
                       HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLMauSac vm = this.msRepo.findByMa(ma);
        request.setAttribute("qlms",vm);
        request.setAttribute("view","/views/MauSac/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request,response);
    }

    private void update( HttpServletRequest request,
                         HttpServletResponse response
    ) throws ServletException, IOException {
        QLMauSac ms = new QLMauSac();
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

    private void delete(HttpServletRequest request,
                        HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLMauSac vm = msRepo.findByMa(ma);
        this.msRepo.delete(vm);
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/mau-sac/index");
    }

}
