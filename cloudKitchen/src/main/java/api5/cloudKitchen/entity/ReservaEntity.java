package api5.cloudKitchen.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @Column(name = "res_qnt_pessoas")
    private Integer resQntPessoas;

    @Column(name = "res_data_hora")
    private LocalDateTime resDataHora;

}
