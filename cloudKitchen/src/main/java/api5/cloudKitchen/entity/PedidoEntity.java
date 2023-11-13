package api5.cloudKitchen.entity;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ped_pedido")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ped_id")
    private Long pedId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fun_id", referencedColumnName = "fun_id")
    private FuncionarioEntity funId;

    @Column(name = "ped_hora_pedido")
    private Timestamp pedHoraPedido;

    @Column(name = "ped_hora_entregue")
    private Timestamp pedHoraEntregue;

    @Column(name = "ped_valor_total")
    private Float pedValorTotal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "res_id", referencedColumnName = "res_id")
    private ReservaEntity resId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "res_telefone", referencedColumnName = "res_telefone")
    private ReservaEntity resTelefone;

    @OneToMany(mappedBy = "pedId")
    private List<ItemPedidoEntity>  itens;

}