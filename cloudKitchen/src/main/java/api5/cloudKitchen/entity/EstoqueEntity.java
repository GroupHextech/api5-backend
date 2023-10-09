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
@Table(name = "est_estoque")
public class EstoqueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "est_id")
    private Long estId;

    @Column(name = "est_nome")
    private String estNome;

    @Column(name = "est_qtd_estoque")
    private Float estQtdEstoque;

    @ManyToOne
    @JoinColumn(name = "uni_id", referencedColumnName = "uni_id")
    private UnidadeEntity uniId; 

}
