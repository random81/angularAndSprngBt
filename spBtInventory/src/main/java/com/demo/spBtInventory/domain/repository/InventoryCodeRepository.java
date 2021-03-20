
package com.demo.spBtInventory.domain.repository;
import com.demo.spBtInventory.domain.entity.InventoryCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryCodeRepository extends JpaRepository<InventoryCode, Long> {
}
