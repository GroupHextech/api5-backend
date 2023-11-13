package api5.cloudKitchen.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "log_login")
public class LoginEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id")
    private Long logId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fun_id", referencedColumnName = "fun_id")
    private FuncionarioEntity funId;

    @Column(name =  "log_username")
    private String logUsername;

    @Column(name =  "log_password")
    private String logPassword;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pms_id", referencedColumnName = "pms_id")
    private PermissaoEntity pmsId;

}
