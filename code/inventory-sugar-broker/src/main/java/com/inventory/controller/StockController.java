package com.inventory.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inventory.entity.Factory;
import com.inventory.entity.Stock;
import com.inventory.service.FactoryService;
import com.inventory.service.StockService;

@Slf4j
@Controller
public class StockController {


	@Autowired
	private StockService stockService;
	
	@Autowired
	private FactoryService factoryService;
	
    @GetMapping("/new-stock")
    public String redirectToCreateFactory( Model model) {
    	model.addAttribute("factoryList", factoryService.getListOfFactory());
        return "create-stock";
    }
    
    @PostMapping("/save-stock")
    public String createStock(@ModelAttribute Stock stock, Model model) {
    	System.out.println("inside StockService Controller" + stock);
    	stockService.createStock(stock);
    	
    	model.addAttribute("message", "Factory Added Successfully..!!!");
    	
    	return "redirect:/new-factory?id=";
    	
    }

    @GetMapping("/view-stock")
    public String redirectToViewFactory() {
        return "view-stock";
    }

    
    @GetMapping("/get-factory-list")
    public List<Factory>  getListOfFactory(){
    	return factoryService.getListOfFactory();
    	
    }
}
