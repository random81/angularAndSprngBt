package com.demo.spBtInventory.domain.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.demo.spBtInventory.domain.entity.Inventory;
import com.demo.spBtInventory.domain.exception.ResourceNotFoundException;
import com.demo.spBtInventory.domain.repository.InventoryRepository;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:4200")
@RestController
@RequestMapping("/")
public class InventoryController {

    @Autowired
    private InventoryRepository inventoryRepository;

    // get all items
    @GetMapping("/inventory")
    public List<Inventory> listAllItems(){
        return inventoryRepository.findAll();
    }

    @PostMapping("/inventory")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Execute POST method to create item")
    public ResponseEntity<Inventory> createNewItem_whenPostItem(@RequestBody Inventory inventory) {

        Inventory createdItem = inventoryRepository.save(inventory);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdItem.getItemNumber())
                .toUri();

        return ResponseEntity.created(uri).body(createdItem);
    }

    // get item Details by id rest api
    @GetMapping("/inventory/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Execute GET method to get details")
    //public String getDetails(@PathVariable Long id) throws JsonProcessingException {
    public ResponseEntity<String> getDetails(@PathVariable Long id) throws JsonProcessingException {
        Inventory foundItem = inventoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        System.out.println(foundItem);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonInString = foundItem.getItemDetails();
        Details detail = new Details();
        detail.itemDeets = foundItem.getItemDetails();
        String jsonyString = objectMapper.writeValueAsString(detail);
        System.out.println(detail);
        System.out.println(detail.itemDeets);
        System.out.println(jsonyString);
        return ResponseEntity.ok().body(jsonyString);
    }

    // get item by id rest api
    @GetMapping("/inventory/item/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Execute GET method for one item")
    public ResponseEntity<Inventory> list(@PathVariable Long id) {
        Inventory foundItem = inventoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        return ResponseEntity.ok().body(foundItem);
    }

    // update inventory item
    @PutMapping("/inventory/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Execute PUT method for update")
    public ResponseEntity<Inventory> updateItem_whenPutItem(@RequestBody Inventory item, @PathVariable Long id) {
        inventoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return ResponseEntity.ok().body(inventoryRepository.save(item));
    }

    // delete item rest api
    @DeleteMapping("/inventory/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Execute DELETE method")
    public void deleteItem_whenDeleteItem(@PathVariable Long id) {
        inventoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        inventoryRepository.deleteById(id);
    }
    // withdraw item rest api
    @PutMapping("/inventory/withdraw/{id}/amount/{amt}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Execute a subtraction of amount using PUT method")
    public ResponseEntity<Inventory> withDraw_whenPutItem(@RequestBody Inventory item, @PathVariable Long amt, @PathVariable Long id) {
        Inventory itemOrig = new Inventory();
        itemOrig = inventoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        itemOrig.setAmount(itemOrig.getAmount()-amt);
        return ResponseEntity.ok().body(inventoryRepository.save(itemOrig));
    }

    // deposit item rest api
    @PutMapping("/inventory/deposit/{id}/amount/{amt}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Execute an addition of amount using PUT method")
    public ResponseEntity<Inventory> deposit_whenPutItem(@RequestBody Inventory item, @PathVariable Long amt, @PathVariable Long id) {
        Inventory itemOrig = new Inventory();
        itemOrig = inventoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        itemOrig.setAmount(itemOrig.getAmount()+amt);
        return ResponseEntity.ok().body(inventoryRepository.save(itemOrig));
    }


}
