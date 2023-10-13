package api5.cloudKitchen.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pra_prato")
public class PratoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pra_id")
    private Long praId;

    @Column(name = "pra_nome")
    private String praNome;

    @Column(name = "pra_custo")
    private Float praCusto;

    @Column(name = "pra_preco_venda")
    private Float praPrecoVenda;

    @Column(name = "pra_tempo_preparo")
    private Timestamp praTempoPreparo;

}
