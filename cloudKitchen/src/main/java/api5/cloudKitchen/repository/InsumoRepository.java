package api5.cloudKitchen.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import api5.cloudKitchen.entity.InsumoEntity;


public interface InsumoRepository extends JpaRepository<InsumoEntity, Long> {

}
