package api5.cloudKitchen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api5.cloudKitchen.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{
    
}
