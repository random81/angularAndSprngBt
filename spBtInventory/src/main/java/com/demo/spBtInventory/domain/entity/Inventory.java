package com.demo.spBtInventory.domain.entity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "inventory")
public class Inventory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemNumber; //itemNumber

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_details")
    private String itemDetails;

    @Column(name = "amount")
    private Long amount;

    public void setAmount(Long amt){
        this.amount = amt;
    }
    public Long getAmount(){
        return this.amount;
    }
/*
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="itemNumber", referencedColumnName ="id" )
    */

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private InventoryCode inventoryCode;

    public void fixInvenoryCode(Long x){
        this.inventoryCode.setId(x);
    }

    public String toString(){
        return "";
    }

    public String getInventoryCodeValue(){
        return inventoryCode.getInventoryCode();
    }
    public InventoryCode getInventoryCode(){
        return inventoryCode;
    }
    public void setInventoryCode(InventoryCode inventoryCode){
        this.inventoryCode= inventoryCode;
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

