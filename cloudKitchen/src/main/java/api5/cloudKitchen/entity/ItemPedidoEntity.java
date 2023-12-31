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
@Table(name = "ite_item_pedido")
public class ItemPedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ite_id")
    private Long iteId;
    
    @Column(name = "ite_quantidade")
    private Long iteQuantidade;

    @ManyToOne
    @JoinColumn(name = "pra_id", referencedColumnName = "pra_id")
    private PratoEntity praId;

    @ManyToOne
    @JoinColumn(name = "ped_id", referencedColumnName = "ped_id")
    private PedidoEntity pedId;

}
