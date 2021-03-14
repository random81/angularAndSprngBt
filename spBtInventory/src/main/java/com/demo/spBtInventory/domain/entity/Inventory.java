package com.demo.spBtInventory.domain.entity;

//package com.com.example.inventorySpring.domain.entity.inventory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "inventory")
public class Inventory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemNumber; //itemNumber

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_details")
    private String itemDetails;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "Inventory_code")
    private Long InventoryCode;

    public void setAmount(Long amt){
        this.amount = amt;
    }
    public Long getAmount(){
        return this.amount;
    }
    public void setInventoryCode(Long InventoryCode){
        this.InventoryCode = InventoryCode;
    }
    public Long getInventoryCode(){
        return this.InventoryCode;
    }
    public void setItemName(String name){
        this.itemName = name;
    }
    public String getItemName(){
        return this.itemName;
    }
    public void setItemDetails(String details){
        this.itemDetails = details;
    }
    public String getItemDetails(){
        return this.itemDetails;
    }

    public Long getItemNumber(){
        return this.itemNumber;
    }

}

