package com.inventory.controller;

import lombok.extern.slf4j.Slf4j;

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
public class CreateBillController {

	
    @GetMapping("/new-bill")
    public String redirectToCreateFactory() {
    	
        return "create-bill";
    }
    
    @PostMapping("/save-bill")
    public String createStock(@ModelAttribute Factory factory, Model model) {
    	System.out.println("inside createFactory Controller" + factory);
    	model.addAttribute("message", "Factory Added Successfully..!!!");
    	
    	return "redirect:/new-factory?id=";
    	
    }

    @GetMapping("/view-bills")
    public String redirectToViewFactory() {
        return "view-bill";
    }

}
