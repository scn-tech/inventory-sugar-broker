package com.inventory.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.inventory.entity.Factory;
import com.inventory.service.FactoryService;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView redirectToViewFactory(@RequestParam(defaultValue = "0", name = "pno") int pageNo,
                                              @RequestParam(defaultValue = "10", name = "psz") int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by("id"));
        ModelAndView m = new ModelAndView("view-factory");
        Page<Factory> pages = factoryService.getAllFactoryByPageable(paging);
        m.addObject("number", pages.getNumber());
        m.addObject("totalPages", pages.getTotalPages());
        m.addObject("totalElements", pages.getTotalElements());
        m.addObject("size", pages.getSize());
        m.addObject("data",pages.getContent());
        return m;
    }



    
}
