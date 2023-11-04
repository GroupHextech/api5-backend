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

    @Column(name = "est_nivel_minimo")
    private Float estNivelMinimo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "uni_id", referencedColumnName = "uni_id")
    private UnidadeEntity uniId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cat_id", referencedColumnName = "cat_id")
    private CategoriaEntity catId; 

}
