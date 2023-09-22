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
public class Reserva {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "res_id")
    private Long id;

    @Column(name = "res_nome")
    private String nome; 
    
    @Column(name = "res_mesa")
    private Integer mesa;

    @Column(name = "res_data_hora")
    private LocalDateTime dataHora;

    @Column(name = "res_status")
    private String status;

    @Column(name = "pra_id")
    private Long idPrato;

}
