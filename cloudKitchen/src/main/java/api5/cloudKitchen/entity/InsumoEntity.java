package api5.cloudKitchen.entity;

import java.util.Date;
import java.time.LocalDateTime;

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
@Table(name = "ins_insumo")
public class InsumoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ins_id")
    private Long insId;

    @Column(name = "ins_qtd_entrada")
    private Float insQtdEntrada;

    @Column(name = "ins_validade")
    private Date insValidade;

    @Column(name = "ins_data_hora_compra")
    private LocalDateTime insDataHoraCompra;

    @Column(name = "ins_valor_compra")
    private Float insValorCompra;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "for_id", referencedColumnName = "for_id")
    private FornecedorEntity forId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "est_id", referencedColumnName = "est_id")
    private EstoqueEntity estId;

    @Column(name = "ins_previsao_entrega")
    private Date insPrecisaoEntrega;

    @Column(name = "ins_data_recebimento")
    private Date insDataRecebimento;

    @Column(name = "ins_nota_fiscal")
    private String insNotaFiscal;

    @Column(name = "ins_previsao_pagamento")
    private Date insPrecisaoPagamento;

    @Column(name = "ins_data_pagamento")
    private Date insDataPagamento;

}
