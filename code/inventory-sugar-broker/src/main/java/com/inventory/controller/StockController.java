package com.inventory.controller;

import com.inventory.service.PorpertyService;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class StockController extends PorpertyService {


	@Autowired
	private StockService stockService;
	
	@Autowired
	private FactoryService factoryService;

    @GetMapping("/new-stock")
    public ModelAndView redirectToCreateFactory(@ModelAttribute(name= "seasonslist") List<String> seasonslist,
                                                @ModelAttribute(name= "gradelist") List<String> gradelist) {
        ModelAndView model = new ModelAndView();
        model.addObject("factoryList", factoryService.getListOfFactory());
        model.setViewName("create-stock");
        return model;
    }
    
    @PostMapping("/save-stock")
    public String createStock(@ModelAttribute Stock stock, Model model) {
    	log.info("inside StockService Controller" + stock);
    	stockService.createStock(stock);
    	
    	model.addAttribute("message", "Stock Added Successfully..!!!");
    	
    	return "redirect:/new-stock?code=201";
    	
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
