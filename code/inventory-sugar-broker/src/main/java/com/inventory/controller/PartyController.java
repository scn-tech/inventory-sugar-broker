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
import com.inventory.entity.Party;
import com.inventory.service.FactoryService;
import com.inventory.service.PartyService;

@Slf4j
@Controller
public class PartyController {

	@Autowired
	private PartyService createPartyService;
	
    @GetMapping("/new-party")
    public String redirectToCreateFactory() {
    	
        return "create-party";
    }
    
    @PostMapping("/save-party")
    public String createFactory(@ModelAttribute Party party, Model model) {
    	System.out.println("inside createParty Controller" + party);
    	model.addAttribute("message", "Party Added Successfully..!!!");
    	Party p = createPartyService.createParty(party);
    	return "redirect:/new-party?id=";
    	
    }

    @GetMapping("/view-parties")
    public String redirectToViewFactory() {
        return "view-party";
    }

}
