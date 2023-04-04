package DomainModel;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "HoaDonChiTiet")
@IdClass(HoaDonChiTietId.class)
public class HoaDonCT implements Serializable {
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdChiTietSP", insertable = false, updatable = false)
    private ChiTietSP idChiTietSP;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdHoaDon", insertable = false, updatable = false)
    private HoaDon idHoaDon;

    @Column(name = "SoLuong")
    private int soLuong;

    @Column(name = "DonGia")
    private BigDecimal donGia;

    public HoaDonCT() {
    }

    public HoaDonCT(ChiTietSP idChiTietSP, HoaDon idHoaDon, int soLuong, BigDecimal donGia) {
        this.idChiTietSP = idChiTietSP;
        this.idHoaDon = idHoaDon;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public ChiTietSP getIdChiTietSP() {
        return idChiTietSP;
    }

    public void setIdChiTietSP(ChiTietSP idChiTietSP) {
        this.idChiTietSP = idChiTietSP;
    }

    public HoaDon getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(HoaDon idHoaDon) {
        this.idHoaDon = idHoaDon;
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

    @Override
    public String toString() {
        return "HoaDonCT{" +
                "idChiTietSP=" + idChiTietSP +
                ", idHoaDon=" + idHoaDon +
                ", soLuong=" + soLuong +
                ", donGia=" + donGia +
                '}';
    }
}
