
package com.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.entity.Stock;
import com.inventory.repository.StockRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j 
public class StockService {

	@Autowired 
	public StockRepository stockRepository;

	public Stock createStock(Stock stock) { 
		System.out.println("Repo :  Factory : "+stock);
		return stockRepository.save(stock);
	}

	public void updateStockQty(int stockId, int qty) {
		stockRepository.updateStockQuantity(stockId, qty);
	}

}
