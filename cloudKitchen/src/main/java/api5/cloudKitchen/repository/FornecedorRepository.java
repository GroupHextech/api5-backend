package api5.cloudKitchen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import api5.cloudKitchen.entity.FornecedorEntity;

public interface FornecedorRepository extends JpaRepository<FornecedorEntity, Long> {
    @Query(value = "SELECT * FROM for_fornecedor", nativeQuery = true)
    List<Object[]> getFornecedor();
}
