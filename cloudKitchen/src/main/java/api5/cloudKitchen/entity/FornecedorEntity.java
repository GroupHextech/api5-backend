package api5.cloudKitchen.entity;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "for_fornecedor")
public class FornecedorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "for_id")
    private Long forId;

    @Column(name = "for_nome")
    private String forNome;

    @Column(name = "for_telefone")
    private String forTelefone;

    @Column(name = "for_endereco")
    private String forEndereco;

    @Column(name = "for_email")
    private String forEmail;

    public static FornecedorEntity parse(String string) {
        try {
            // Crie um ObjectMapper para analisar a string JSON
            ObjectMapper objectMapper = new ObjectMapper();
            
            // Use o ObjectMapper para desserializar a string em um objeto FornecedorEntity
            FornecedorEntity fornecedor = objectMapper.readValue(string, FornecedorEntity.class);
            
            return fornecedor;
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Em caso de erro na análise, retorne null ou trate a exceção de acordo com a necessidade.
        }
    }

}
