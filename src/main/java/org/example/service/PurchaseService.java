package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.PurchaseDTO;
import org.example.model.Customer;
import org.example.model.Purchase;
import org.example.repository.CustomerRepository;
import org.example.repository.PurchaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;

    private final CustomerRepository customerRepository;

    public Purchase createPurchase(PurchaseDTO purchaseDTO) {
        return purchaseRepository.save(Purchase.builder()
                .customerId(purchaseDTO.getCustomerId())
                .price(purchaseDTO.getPrice())
                .build());
    }

    public List<Purchase> readAllPurchase() {
        return purchaseRepository.findAll();
    }

    public Purchase updatePurchase(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    public void deletePurchase(Long id) {
        purchaseRepository.deleteById(id);

    }

    public Customer writeOfMoney(Purchase purchase) {
        //получить сколько денег у пользователя с id
        Customer currentCustomer = customerRepository.findById(purchase.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));
        //вычесть из них стоимость товара price
        Double newAmount = currentCustomer.getMoney() - purchase.getPrice();
        //обновить количество денег у пользователя по id
        currentCustomer.setMoney(newAmount);
        customerRepository.save(currentCustomer);
        return currentCustomer;
    }
}
