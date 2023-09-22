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
@Table(name = "pra_prato")
public class Prato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pra_id")
    private Long id;

    @Column(name = "pra_nome")
    private String nome;

    @Column(name = "pra_custo")
    private Double custo;

    @Column(name = "pra_preco")
    private Double preco;

    @Column(name = "pra_desempenho")
    private Integer desempenho;
    
}
