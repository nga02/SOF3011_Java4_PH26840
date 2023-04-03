package controllers.admin;

import DomainModel.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repository.*;
import view_models.QLCTSP;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.UUID;

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
    private SanPhamRepository spRepo;
    private NSXRepository nsxRepo;
    private MauSacRepository msRepo;
    private DongSPRepository dongspRepo;

    public ChiTietSPServlet() {
        this.ctspRepo = new ChiTietSPRepository();
        this.spRepo = new SanPhamRepository();
        this.nsxRepo = new NSXRepository();
        this.msRepo = new MauSacRepository();
        this.dongspRepo = new DongSPRepository();
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

    private void create(HttpServletRequest request,
                        HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("lstSP", this.spRepo.findAll());
        request.setAttribute("lstNSX", this.nsxRepo.findAll());
        request.setAttribute("lstMauSac", this.msRepo.findAll());
        request.setAttribute("lstDongSP", this.dongspRepo.findAll());
        request.setAttribute("view", "/views/ChiTietSP/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    private void edit(HttpServletRequest request,
                      HttpServletResponse response
    ) throws ServletException, IOException {
        UUID id = UUID.fromString(request.getParameter("id"));
        ChiTietSP ct = this.ctspRepo.findById(id);
        request.setAttribute("ctsp", ct);
        request.setAttribute("lstSP", this.spRepo.findAll());
        request.setAttribute("lstNSX", this.nsxRepo.findAll());
        request.setAttribute("lstMauSac", this.msRepo.findAll());
        request.setAttribute("lstDongSP", this.dongspRepo.findAll());
        request.setAttribute("view", "/views/ChiTietSP/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request,
                        HttpServletResponse response
    ) throws ServletException, IOException {
        UUID id = UUID.fromString(request.getParameter("id"));
        ChiTietSP ct = this.ctspRepo.findById(id);
        this.ctspRepo.delete(ct);
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/chitiet-sp/index");
    }

    private void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("ds", this.ctspRepo.findAll());
        request.setAttribute("lstSP", this.spRepo.findAll());
        request.setAttribute("lstNSX", this.nsxRepo.findAll());
        request.setAttribute("lstMS", this.msRepo.findAll());
        request.setAttribute("lstDongSP", this.dongspRepo.findAll());
        request.setAttribute("view", "/views/ChiTietSP/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
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

    private void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
//        double giaNhapStr = Double.parseDouble(request.getParameter("giaNhap"));
//        BigDecimal giaNhap = BigDecimal.valueOf(giaNhapStr);
//        ctsp.setGiaNhap(giaNhap);

        ChiTietSP ctsp = new ChiTietSP();
        MauSac ms = this.msRepo.findById(UUID.fromString(request.getParameter("id_MauSac")));
        NhaSX nsx = this.nsxRepo.findById(UUID.fromString(request.getParameter("id_Nsx")));
        DongSP dsp = this.dongspRepo.findById(UUID.fromString(request.getParameter("id_DongSP")));
        SanPham sp = this.spRepo.findById(UUID.fromString(request.getParameter("id_SP")));

        try {
            BeanUtils.populate(ctsp, request.getParameterMap());
            ctsp.setIdSP(sp);
            ctsp.setIdNsx(nsx);
            ctsp.setIdMauSac(ms);
            ctsp.setIdDongSP(dsp);
            this.ctspRepo.insert(ctsp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/chitiet-sp/index");
    }

    private void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        UUID id = UUID.fromString(request.getParameter("id_ctsp"));
        ChiTietSP ctsp = this.ctspRepo.findById(id);
        MauSac ms = this.msRepo.findById(UUID.fromString(request.getParameter("id_MauSac")));
        NhaSX nsx = this.nsxRepo.findById(UUID.fromString(request.getParameter("id_Nsx")));
        DongSP dsp = this.dongspRepo.findById(UUID.fromString(request.getParameter("id_DongSP")));
        SanPham sp = this.spRepo.findById(UUID.fromString(request.getParameter("id_SP")));

        try {
            BeanUtils.populate(ctsp, request.getParameterMap());
            ctsp.setIdSP(sp);
            ctsp.setIdNsx(nsx);
            ctsp.setIdMauSac(ms);
            ctsp.setIdDongSP(dsp);
            this.ctspRepo.update(ctsp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/SP23B2_SOF3011_IT17319_war_exploded/chitiet-sp/index");
    }
}
