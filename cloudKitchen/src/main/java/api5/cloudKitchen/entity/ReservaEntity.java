package api5.cloudKitchen.entity;

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
@Table(name = "res_reserva")
public class ReservaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "res_id")
    private Long resId;

    @Column(name = "res_nome")
    private String resNome; 
    
    @Column(name = "res_telefone")
    private String resTelefone;

    @Column(name = "res_mesa")
    private Integer resMesa;

    @Column(name = "res_qtd_pessoas")
    private Integer resQtdPessoas;

    @Column(name = "res_data_hora")
    private Timestamp resDataHora;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sta_id", referencedColumnName = "sta_id")
    private StatusEntity staId;

}
