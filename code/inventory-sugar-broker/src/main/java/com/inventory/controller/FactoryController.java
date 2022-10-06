package com.inventory.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class FactoryController {

    @GetMapping("/new-factory")
    public String redirectToCreateFactory() {
        return "create-factory";
    }

    @GetMapping("/view-factories")
    public String redirectToViewFactory() {
        return "view-factory";
    }

}
