package com.inventory.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.inventory.entity.Factory;
import com.inventory.entity.Party;
import com.inventory.service.FactoryService;
import com.inventory.service.PartyService;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView redirectToViewParty(@RequestParam(defaultValue = "0", name = "pno") int pageNo,
                                        @RequestParam(defaultValue = "10", name = "psz") int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by("id"));
        ModelAndView m = new ModelAndView("view-party");
        Page<Party> pages = createPartyService.getAllPartyByPageable(paging);
        m.addObject("number", pages.getNumber());
        m.addObject("totalPages", pages.getTotalPages());
        m.addObject("totalElements", pages.getTotalElements());
        m.addObject("size", pages.getSize());
        m.addObject("data",pages.getContent());
        return m;
    }

}
