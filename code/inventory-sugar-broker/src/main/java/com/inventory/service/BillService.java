package com.inventory.service;

import com.inventory.entity.Bill;
import com.inventory.entity.BillItem;
import com.inventory.repository.BillItemRepository;
import com.inventory.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BillService {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private BillItemRepository billItemRepository;

    @Autowired
    private StockService stockService;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Bill save(Bill bill) {
        boolean flag = false;

        bill = billRepository.save(bill);
        for(BillItem item : bill.getBillItems()) {
            item.setBill(bill);
            billItemRepository.save(item);
        }

        stockService.updateStockQty(bill.getBillItems().get(0).getStock().getId(), bill.getBillItems().get(0).getBillQuantity());
        return bill;
    }

}
