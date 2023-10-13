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
@Table(name = "uni_unidade")
public class UnidadeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uni_id")
    private Long uniId;

    @Column(name = "uni_nome")
    private String uniNome;

    @Column(name = "uni_sigla", columnDefinition = "CHAR")
    private String uniSigla;
}
