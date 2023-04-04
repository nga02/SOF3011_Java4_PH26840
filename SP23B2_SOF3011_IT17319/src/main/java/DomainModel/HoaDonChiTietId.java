package DomainModel;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;


@Setter
@Getter
public class HoaDonChiTietId implements Serializable {
    private HoaDon idHoaDon;
    private ChiTietSP idChiTietSP;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.idHoaDon);
        hash = 71 * hash + Objects.hashCode(this.idChiTietSP);
        return hash;
    }

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
        final HoaDonChiTietId other = (HoaDonChiTietId) obj;
        if (!Objects.equals(this.idHoaDon, other.idHoaDon)) {
            return false;
        }
        return Objects.equals(this.idChiTietSP, other.idChiTietSP);
    }
}
