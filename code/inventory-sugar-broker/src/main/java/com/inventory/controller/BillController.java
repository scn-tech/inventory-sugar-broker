package com.inventory.controller;

import com.inventory.entity.Bill;
import com.inventory.entity.Factory;
import com.inventory.service.BillService;
import com.inventory.service.FactoryService;
import com.inventory.service.PartyService;
import com.inventory.service.PorpertyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class BillController  extends PorpertyService {

    @Autowired
    private PartyService partyService;

    @Autowired
    private FactoryService factoryService;

    @Autowired
    private BillService billService;
	
    @GetMapping("/new-bill")
    public ModelAndView redirectToCreateFactory(@ModelAttribute(name= "seasonslist") List<String> seasonslist,
                                                @ModelAttribute(name= "gradelist") List<String> gradelist) {

        ModelAndView model = new ModelAndView("create-bill");
        model.addObject("partiesList", partyService.getByFlag(false));
        model.addObject("factoriesList", factoryService.getByFlag(false));
        return model;
    }
    
    @PostMapping("/save-bill")
    public String createStock(@ModelAttribute Bill bill) {
    	System.out.println("inside createBill Controller" + bill);
        int code = billService.save(bill)?201:500;
    	return "redirect:/new-bill?code="+code;
    }

    @GetMapping("/view-bills")
    public String redirectToViewFactory() {
        return "view-bill";
    }

}
