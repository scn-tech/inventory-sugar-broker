package com.inventory.controller;

import com.inventory.entity.Stock;
import com.inventory.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BillRestController {

    @Autowired
    private StockRepository repository;

    @GetMapping("/get-factory-stock/{factoryid}/{season}")
    public List<Stock> getAvailableStockByFactory(@PathVariable("factoryid") int factoryid,
                                                  @PathVariable("season") String season) {
        List<Stock> list = repository.getStockByFactoryAndSeason(factoryid, season);
        return list;
    }



}
