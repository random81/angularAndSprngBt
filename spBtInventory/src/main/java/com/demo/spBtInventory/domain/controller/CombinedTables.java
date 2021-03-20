package com.demo.spBtInventory.domain.controller;

public class CombinedTables {
    private Long itemNumber;
    private String itemName;
    private String itemDetails;
    private Long amount;
    private String inventoryCode;
    public CombinedTables(Long itemNumber,Long amount, String itemDetails, String itemName, String inventoryCode){
        this.itemNumber = itemNumber;
        this.inventoryCode=inventoryCode;
        this.amount=amount;
        this.itemDetails=itemDetails;
        this.itemName=itemName;
        this.itemName=itemName;
    }
    public String getItemDetails(){
        return this.itemDetails;
    }
    public void setItemDetails(String details){
        this.itemDetails = details;
    }
    public void setItemName(String name){
        this.itemName = name;
    }
    public String getItemName(){
        return this.itemName;
    }
    public void setInventoryCode(String inventoryCode){
        this.inventoryCode = inventoryCode;
    }
    public String getInventoryCode(){
        return this.inventoryCode;
    }
    public void setAmount(Long amt){
        this.amount = amt;
    }
    public Long getAmount(){
        return this.amount;
    }
    public Long getItemNumber(){
        return this.itemNumber;
    }
    public void setItemNumber(Long itemNumber){
        this.itemNumber = itemNumber;
    }
}
