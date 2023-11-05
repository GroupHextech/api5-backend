package api5.cloudKitchen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api5.cloudKitchen.entity.InsumoEntity;

@Repository
public interface InsumoRepository extends JpaRepository<InsumoEntity, Long> {
    // Você pode adicionar métodos personalizados do repositório, se necessário
}
