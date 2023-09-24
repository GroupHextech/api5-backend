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
@Table(name = "rst_restaurante")
public class RestauranteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rst_id")
    private Long rstId;

    @Column(name = "rst_nome")
    private String rstNome;

    @Column(name = "rst_nota")
    private Integer rstNota;

    @ManyToOne
    @JoinColumn(name = "ins_id", referencedColumnName = "ins_id")
    private InsumoEntity insId;

}
