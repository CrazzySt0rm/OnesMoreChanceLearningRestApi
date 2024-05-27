package org.example.service;


import lombok.AllArgsConstructor;
import org.example.dto.PurchaseDTO;
import org.example.model.Customer;
import org.example.model.Purchase;
import org.example.repository.CustomerRepository;
import org.example.repository.PurchaseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;

    private final CustomerRepository customerRepository;

    public Purchase createPurchase(PurchaseDTO purchaseDTO) {
        var customer = customerRepository.findById(purchaseDTO.getCustomerId()).orElseThrow(() -> new RuntimeException("Customer not found"));
        var purchase = Purchase.builder()
                .customer(customer)
                .price(purchaseDTO.getPrice())
                .build();
        return purchaseRepository.save(purchase);
    }

    public List<Purchase> readAllPurchase() {
        return purchaseRepository.findAll();
    }



    public void updatePurchase(Purchase purchase) {
        purchaseRepository.save(purchase);
    }

//раскомментируй чтобы в одной тразакции можно было упасть и она откатилась
//    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Purchase makePurchase(PurchaseDTO dto) {
        var customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        var purchase = Purchase.builder().customer(customer).price(dto.getPrice()).build();
        updatePurchase(purchase);
        broke();
        writeOfMoney(purchase);
        return purchaseRepository.save(purchase);
    }

    private void broke(){
        throw new RuntimeException("Не удалось сделать покупку");
    }


    public void deletePurchase(Long id) {
        purchaseRepository.deleteById(id);

    }

    public Customer writeOfMoney(Purchase purchase) {
        //получить сколько денег у пользователя с id
        Customer currentCustomer = customerRepository.findById(purchase.getCustomer().getId())
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));
        //вычесть из них стоимость товара price
        Double newAmount = currentCustomer.getMoney() - purchase.getPrice();
        //обновить количество денег у пользователя по id
        currentCustomer.setMoney(newAmount);
        customerRepository.save(currentCustomer);
        return currentCustomer;
    }
}
