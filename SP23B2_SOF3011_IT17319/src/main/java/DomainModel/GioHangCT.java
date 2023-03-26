package DomainModel;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "GioHangChiTiet")

public class GioHangCT {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdGioHang", insertable = false, updatable = false)
    private GioHang idGioHang;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdChiTietSP",nullable = false)
    private ChiTietSP idChiTietSP;

    @Column(name = "SoLuong")
    private int soLuong;

    @Column(name = "DonGia")
    private BigDecimal donGia;

    @Column(name = "DonGiaKhiGiam")
    private BigDecimal donGiaKhiGiam;

    public GioHangCT() {
    }
    public GioHangCT(GioHang idGioHang, ChiTietSP idChiTietSP, int soLuong, BigDecimal donGia, BigDecimal donGiaKhiGiam) {
        this.idGioHang = idGioHang;
        this.idChiTietSP = idChiTietSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.donGiaKhiGiam = donGiaKhiGiam;
    }

    public GioHang getIdGioHang() {
        return idGioHang;
    }

    public void setIdGioHang(GioHang idGioHang) {
        this.idGioHang = idGioHang;
    }

    public ChiTietSP getIdChiTietSP() {
        return idChiTietSP;
    }

    public void setIdChiTietSP(ChiTietSP idChiTietSP) {
        this.idChiTietSP = idChiTietSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public BigDecimal getDonGiaKhiGiam() {
        return donGiaKhiGiam;
    }

    public void setDonGiaKhiGiam(BigDecimal donGiaKhiGiam) {
        this.donGiaKhiGiam = donGiaKhiGiam;
    }

    @Override
    public String toString() {
        return "GioHangCT{" +
                "idGioHang=" + idGioHang +
                ", idChiTietSP=" + idChiTietSP +
                ", soLuong=" + soLuong +
                ", donGia=" + donGia +
                ", donGiaKhiGiam=" + donGiaKhiGiam +
                '}';
    }
}
