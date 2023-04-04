package DomainModel;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
public class GioHangChiTietId implements Serializable {
    private GioHang idGioHang;
    private ChiTietSP idChiTietSP;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GioHangChiTietId other = (GioHangChiTietId) obj;
        if (!Objects.equals(this.idGioHang, other.idGioHang)) {
            return false;
        }
        return Objects.equals(this.idChiTietSP, other.idChiTietSP);
    }



    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.idGioHang);
        hash = 67 * hash + Objects.hashCode(this.idChiTietSP);
        return hash;
    }

}
