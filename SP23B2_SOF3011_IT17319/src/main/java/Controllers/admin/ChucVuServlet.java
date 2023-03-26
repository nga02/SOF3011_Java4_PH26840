package Controllers.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import Repository.ChucVuRepository;
import View_models.QLChucVu;


@WebServlet({
        "/chuc-vu/index",
        "/chuc-vu/create",
        "/chuc-vu/store",
        "/chuc-vu/edit",
        "/chuc-vu/update",
        "/chuc-vu/delete",
})
public class ChucVuServlet extends HttpServlet {
    private ChucVuRepository cvRepo;

    public ChucVuServlet() {
        this.cvRepo = new ChucVuRepository();
        cvRepo.insert(new QLChucVu("CV01", "Nhân viên"));
        cvRepo.insert(new QLChucVu("CV02", "Trưởng phòng"));
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
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")) {
            this.store(request, response);
        }else if(uri.contains("update")){
            this.update(request,response);
        }else{
//            this.index(request,response);
            response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/chuc-vu/index");
        }
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("ds", cvRepo.findAll());
        request.setAttribute("view", "/views/ChucVu/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }
//    --------------------------------------
    private void create(HttpServletRequest request,
                       HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view","/views/ChucVu/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    private void store(HttpServletRequest request,
                      HttpServletResponse response
    ) throws ServletException, IOException{
        QLChucVu cv = new QLChucVu();
        try {
            BeanUtils.populate(cv,request.getParameterMap());
            this.cvRepo.insert(cv);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/chuc-vu/index");
    }

//edit

    private void edit(HttpServletRequest request,
                       HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLChucVu vm = this.cvRepo.findByMa(ma);
        request.setAttribute("qlcv", vm);
        request.setAttribute("view","/views/ChucVu/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);

    }

    private void update(HttpServletRequest request,
                       HttpServletResponse response
    ) throws ServletException, IOException{
        QLChucVu cv = new QLChucVu();
        try {
            BeanUtils.populate(cv,request.getParameterMap());
            this.cvRepo.update(cv);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/chuc-vu/index");
    }

//    ________________________________________________

    private void delete(HttpServletRequest request,
                       HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLChucVu vm = cvRepo.findByMa(ma);
        this.cvRepo.delete(vm);
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/chuc-vu/index");
    }


}
