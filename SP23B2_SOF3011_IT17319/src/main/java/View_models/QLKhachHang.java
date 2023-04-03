package view_models;

public class QLKhachHang {
    private String ma;
    private String ten;
    private String ten_dem;
    private String ho;
    private String ngay_sinh;
    private String sdt;
    private String dia_chi;
    private String mat_khau;
    private String quoc_gia;
    private String thanh_pho;

    public QLKhachHang() {
    }

    public QLKhachHang(String ma, String ten, String ten_dem, String ho, String ngay_sinh, String sdt, String dia_chi, String mat_khau, String quoc_gia, String thanh_pho) {
        this.ma = ma;
        this.ten = ten;
        this.ten_dem = ten_dem;
        this.ho = ho;
        this.ngay_sinh = ngay_sinh;
        this.sdt = sdt;
        this.dia_chi = dia_chi;
        this.mat_khau = mat_khau;
        this.quoc_gia = quoc_gia;
        this.thanh_pho = thanh_pho;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTen_dem() {
        return ten_dem;
    }

    public void setTen_dem(String ten_dem) {
        this.ten_dem = ten_dem;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(String ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }

    public String getMat_khau() {
        return mat_khau;
    }

    public void setMat_khau(String mat_khau) {
        this.mat_khau = mat_khau;
    }

    public String getQuoc_gia() {
        return quoc_gia;
    }

    public void setQuoc_gia(String quoc_gia) {
        this.quoc_gia = quoc_gia;
    }

    public String getThanh_pho() {
        return thanh_pho;
    }

    public void setThanh_pho(String thanh_pho) {
        this.thanh_pho = thanh_pho;
    }
}
