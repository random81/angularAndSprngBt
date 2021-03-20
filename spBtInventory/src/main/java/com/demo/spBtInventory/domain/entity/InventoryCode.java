package com.demo.spBtInventory.domain.entity;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "inventoryCode")
public class InventoryCode implements Serializable {
/*
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    */

    @Id //specified the primary key
    @GeneratedValue(strategy=GenerationType.IDENTITY) //uses the database identity column
    @Column(name="id",unique = true,nullable = false) //name is optional is variable name matches table field name
    private Long id;
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

   @OneToOne(mappedBy = "inventoryCode")
   private Inventory inventory;


    @Column(name = "inventoryCode")
    private String inventoryCode;
    public void setInventoryCode(String value){
        this.inventoryCode = value;
    }
    public void setInventory(Inventory inventory){
        this.inventory = inventory;
    }
    public String getInventoryCode() {
        return this.inventoryCode;
    }
    public InventoryCode(String inventoryCode) {
        this.inventoryCode = inventoryCode;
    }
}

