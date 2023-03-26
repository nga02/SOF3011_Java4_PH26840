package DomainModel;

import jakarta.persistence.*;

@Entity
@Table(name="ChucVu")
public class ChucVu {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name="Ma")
    private String ma;

    @Column(name="Ten")
    private String ten;
}
