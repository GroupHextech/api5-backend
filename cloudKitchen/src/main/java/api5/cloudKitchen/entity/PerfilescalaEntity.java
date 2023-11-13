package api5.cloudKitchen.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "per_perfilescala")
public class PerfilescalaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "per_id")
    private Long PerId;

    @Column(name = "per_nomeperfil")
    private String perNomeperfil;

    @Column(name = "per_hora_entrada")
    private Timestamp perHoraEntrada;

    @Column(name = "per_hora_saida")
    private Timestamp perHoraSaida;

}
