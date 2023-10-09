package api5.cloudKitchen.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "con_confeccao")
public class ConfeccaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "con_id")
    private Long conId;

    @Column(name = "con_qnt_utilizada")
    private Float conQntUtilizada;

    @ManyToOne
    @JoinColumn(name = "est_id", referencedColumnName = "est_id")
    private EstoqueEntity estId;

    @ManyToOne
    @JoinColumn(name = "pra_id", referencedColumnName = "pra_id")
    private PratoEntity praId;

}
