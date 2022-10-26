package com.inventory.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inventory.entity.Factory;
import com.inventory.service.FactoryService;

@Slf4j
@Controller
public class FactoryController {

	@Autowired
	private FactoryService factoryService;
	
    @GetMapping("/new-factory")
    public String redirectToCreateFactory() {
    	
        return "create-factory";
    }
    
    @PostMapping("/save")
    public String createFactory(@ModelAttribute Factory factory, Model model) {
    	System.out.println("inside createFactory Controller" + factory);
    	model.addAttribute("message", "Factory Added Successfully..!!!");
    	Factory f = factoryService.createFactory(factory);
    	return "redirect:/new-factory?id=";
    	
    }

    @GetMapping("/view-factories")
    public String redirectToViewFactory() {
        return "view-factory";
    }  
    
}
