package api5.cloudKitchen.entity;

import java.sql.Date;
import java.time.LocalDateTime;

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
@Table(name = "ins_insumo")
public class InsumoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ins_id")
    private Long insId;

    @Column(name = "ins_quantidade")
    private Integer insQuantidade;

    @Column(name = "ins_validade")
    private Date insValidade;

    @Column(name = "ins_data_hora_compra")
    private LocalDateTime insDataHoraCompra;

    @Column(name = "ins_valor_compra")
    private Float insValorCompra;

    @ManyToOne
    @JoinColumn(name = "for_id", referencedColumnName = "for_id")
    private FornecedorEntity forID;

    @ManyToOne
    @JoinColumn(name = "ite_id", referencedColumnName = "ite_id")
    private ItemEntity iteId;

}