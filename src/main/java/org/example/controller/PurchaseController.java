package org.example.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.PurchaseDTO;
import org.example.model.Purchase;
import org.example.service.PurchaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:8081")
public class PurchaseController {

    private final PurchaseService purchaseService;

    @PostMapping("/purchase")
    public ResponseEntity makePurchase(@RequestBody PurchaseDTO purchaseDTO) {
        return new ResponseEntity<>(purchaseService.createPurchase(purchaseDTO), HttpStatus.OK);
    }

    @GetMapping("/purchase")
    public ResponseEntity readAllPurchase() {
        return new ResponseEntity<>(purchaseService.readAllPurchase(), HttpStatus.OK);
    }

    @PutMapping("/purchase")
    public ResponseEntity updatePurch(@RequestBody PurchaseDTO purchase) {
        purchaseService.makePurchase(purchase);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/purchase/{id}")
    public HttpStatus deletePurch(@PathVariable(value = "id") Long id) {
        purchaseService.deletePurchase(id);
        return HttpStatus.OK;
    }
}
