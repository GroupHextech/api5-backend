package api5.cloudKitchen.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @Column(name = "ins_id")
    private Integer insId;

}
