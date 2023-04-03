package DomainModel;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name="ChiTietSP")
public class ChiTietSP {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "IdSP", nullable = false)
    private SanPham idSP;

    @ManyToOne
    @JoinColumn(name = "IdNsx",nullable = false)
    private NhaSX idNsx;

    @ManyToOne
    @JoinColumn(name = "IdMauSac",nullable = false)
    private MauSac idMauSac;

    @ManyToOne
    @JoinColumn(name = "IdDongSP",nullable = false)
    private DongSP idDongSP;

    @Column(name = "NamBH")
    private int namBH;

    @Column(name = "MoTa")
    private String mota;

    @Column(name = "SoLuongTon")
    private int soLuongTon;

    @Column(name = "GiaNhap")
    private BigDecimal giaNhap;

    @Column(name = "GiaBan")
    private BigDecimal giaBan;

    public ChiTietSP() {
    }

    public ChiTietSP(UUID id, SanPham idSP, NhaSX idNsx, MauSac idMauSac, DongSP idDongSP, int namBH, String mota, int soLuongTon, BigDecimal giaNhap, BigDecimal giaBan) {
        this.id = id;
        this.idSP = idSP;
        this.idNsx = idNsx;
        this.idMauSac = idMauSac;
        this.idDongSP = idDongSP;
        this.namBH = namBH;
        this.mota = mota;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public SanPham getIdSP() {
        return idSP;
    }

    public void setIdSP(SanPham idSP) {
        this.idSP = idSP;
    }

    public NhaSX getIdNsx() {
        return idNsx;
    }

    public void setIdNsx(NhaSX idNsx) {
        this.idNsx = idNsx;
    }

    public MauSac getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(MauSac idMauSac) {
        this.idMauSac = idMauSac;
    }

    public DongSP getIdDongSP() {
        return idDongSP;
    }

    public void setIdDongSP(DongSP idDongSP) {
        this.idDongSP = idDongSP;
    }

    public int getNamBH() {
        return namBH;
    }

    public void setNamBH(int namBH) {
        this.namBH = namBH;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public BigDecimal getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(BigDecimal giaNhap) {
        this.giaNhap = giaNhap;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }

}
