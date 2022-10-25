package com.inventory.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Set;

@Service
public class PorpertyService {

    @Value("${season.values}")
    private Set<String> seasons;

    @Value("${grade}")
    private Set<String> grades;

    @ModelAttribute(name= "seasonslist")
    public Set<String> getSeasonList() {
        return seasons;
    }

    @ModelAttribute(name= "gradelist")
    public Set<String> getGradeList() {
        return grades;
    }

}
