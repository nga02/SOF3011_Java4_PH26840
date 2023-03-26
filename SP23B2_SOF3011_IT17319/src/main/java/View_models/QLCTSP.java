package View_models;

public class QLCTSP {
    private String idsp;
    private String san_pham;
    private String nsx;
    private String mau_sac;
    private String dong_sp;
    private int nam_bh;
    private String mo_ta;
    private int sl_ton;
    private double gia_nhap;
    private double gia_ban;

    public QLCTSP() {
    }

    public QLCTSP(String idsp, String san_pham, String nsx, String mau_sac, String dong_sp, int nam_bh, String mo_ta, int sl_ton, double gia_nhap, double gia_ban) {
        this.idsp = idsp;
        this.san_pham = san_pham;
        this.nsx = nsx;
        this.mau_sac = mau_sac;
        this.dong_sp = dong_sp;
        this.nam_bh = nam_bh;
        this.mo_ta = mo_ta;
        this.sl_ton = sl_ton;
        this.gia_nhap = gia_nhap;
        this.gia_ban = gia_ban;
    }

    public String getIdsp() {
        return idsp;
    }

    public void setIdsp(String idsp) {
        this.idsp = idsp;
    }

    public String getSan_pham() {
        return san_pham;
    }

    public void setSan_pham(String san_pham) {
        this.san_pham = san_pham;
    }

    public String getNsx() {
        return nsx;
    }

    public void setNsx(String nsx) {
        this.nsx = nsx;
    }

    public String getMau_sac() {
        return mau_sac;
    }

    public void setMau_sac(String mau_sac) {
        this.mau_sac = mau_sac;
    }

    public String getDong_sp() {
        return dong_sp;
    }

    public void setDong_sp(String dong_sp) {
        this.dong_sp = dong_sp;
    }

    public int getNam_bh() {
        return nam_bh;
    }

    public void setNam_bh(int nam_bh) {
        this.nam_bh = nam_bh;
    }

    public String getMo_ta() {
        return mo_ta;
    }

    public void setMo_ta(String mo_ta) {
        this.mo_ta = mo_ta;
    }

    public int getSl_ton() {
        return sl_ton;
    }

    public void setSl_ton(int sl_ton) {
        this.sl_ton = sl_ton;
    }

    public double getGia_nhap() {
        return gia_nhap;
    }

    public void setGia_nhap(double gia_nhap) {
        this.gia_nhap = gia_nhap;
    }

    public double getGia_ban() {
        return gia_ban;
    }

    public void setGia_ban(double gia_ban) {
        this.gia_ban = gia_ban;
    }
}
