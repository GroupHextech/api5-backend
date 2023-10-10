package api5.cloudKitchen.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "fun_funcionario")
public class FuncionarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fun_id")
    private Long funId;

    @Column(name = "fun_nome")
    private String funNome;

    @Column(name = "fun_funcao")
    private String funFuncao;

    @Column(name = "fun_salario")
    private Float funSalario;

    @Column(name = "fun_folga") 
    private Date funFolga;

    @Column(name = "fun_data_contrato") 
    private Date funDataContrato;

}
