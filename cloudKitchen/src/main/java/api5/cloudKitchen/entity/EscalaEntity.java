package api5.cloudKitchen.entity;

import java.sql.Date;
import java.sql.Timestamp;

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
@Table(name = "esc_escala")
public class EscalaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "esc_id")
    private Long escId;

    @Column(name = "esc_data")
    private Date escData;

    @Column(name = "esc_entrada_func")
    private Timestamp escEntradaFunc;

    @Column(name = "esc_entrada_refeicao")
    private Timestamp escEntradaRefeicao;

    @Column(name = "esc_saida_refeicao")
    private Timestamp escSaidaRefeicao;

    @Column(name = "esc_saida_func")
    private Timestamp escSaidaFunc;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fun_id", referencedColumnName = "fun_id")
    private FuncionarioEntity funId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tip_id", referencedColumnName = "tip_id")
    private TipoescalaEntity tipId;

}
