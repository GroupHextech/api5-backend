package api5.cloudKitchen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import api5.cloudKitchen.entity.FuncionarioEntity;

public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Long> {
    
    @Query(value = "SELECT * FROM v_funcionario_cargo", nativeQuery = true)
    List<Object[]> getFuncionario();

}
