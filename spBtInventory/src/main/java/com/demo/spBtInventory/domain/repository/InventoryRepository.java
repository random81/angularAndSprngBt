package com.demo.spBtInventory.domain.repository;
import com.demo.spBtInventory.domain.controller.CombinedTables;
import com.demo.spBtInventory.domain.entity.Inventory;
import com.demo.spBtInventory.domain.entity.InventoryCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    // join tables for get all method in controller
    @Query("select new com.demo.spBtInventory.domain.controller.CombinedTables(i.itemNumber, i.amount, i.itemDetails, i.itemName, iv.inventoryCode) from Inventory i join InventoryCode iv on i.itemNumber = iv.id")
    //@Query("select new com.demo.spBtInventory.domain.controller.CombinedTables(i.itemNumber, i.amount, i.itemDetails, i.itemName, iv.inventoryCode) from Inventory i join InventoryCode iv on i.itemNumber = iv.id-1")
    public List<CombinedTables> joinedTables();
}
