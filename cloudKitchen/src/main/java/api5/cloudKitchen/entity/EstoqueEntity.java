package api5.cloudKitchen.entity;

import com.fasterxml.jackson.databind.ObjectMapper;

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
@Table(name = "est_estoque")
public class EstoqueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "est_id")
    private Long estId;

    @Column(name = "est_nome")
    private String estNome;

    @Column(name = "est_qtd_estoque")
    private Float estQtdEstoque;

    @Column(name = "est_nivel_minimo")
    private Float estNivelMinimo;

    @ManyToOne
    @JoinColumn(name = "uni_id", referencedColumnName = "uni_id")
    private UnidadeEntity uniId;

    @ManyToOne
    @JoinColumn(name = "cat_id", referencedColumnName = "cat_id")
    private CategoriaEntity catId;

    public static EstoqueEntity parse(String string) {
        try {
            // Crie um ObjectMapper para analisar a string JSON
            ObjectMapper objectMapper = new ObjectMapper();
            
            // Use o ObjectMapper para desserializar a string em um objeto EstoqueEntity
            EstoqueEntity estoque = objectMapper.readValue(string, EstoqueEntity.class);
            
            return estoque;
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Em caso de erro na análise, retorne null ou trate a exceção de acordo com a necessidade.
        }
    }

}
